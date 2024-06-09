package com.rslakra.hellokafka.producer;

import com.rslakra.hellokafka.Producer;
import com.rslakra.hellokafka.utils.KafkaUtils;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: Rohtash Lakra (rlakra)
 * @since: 10/30/19 5:37 PM
 */
public class ProducerWithCallback extends AbstractProducer<String, String> implements Producer {

    private Logger logger = LoggerFactory.getLogger(ProducerWithCallback.class);

    public ProducerWithCallback() {
        super(KafkaUtils.INSTANCE.getProducerConfigs());
        initProducer();
    }

    /**
     * Inner <code>Callback</code> handler
     */
    private class CallBackHandler implements Callback {

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception ex) {
            if (KafkaUtils.isNull(ex)) {
                StringBuilder sBuilder = new StringBuilder();
                sBuilder.append("\nTopic: ").append(recordMetadata.topic());
                sBuilder.append("\nPartition: ").append(recordMetadata.partition());
                sBuilder.append("\nOffset: ").append(recordMetadata.offset());
                sBuilder.append("\nTimestamp: ").append(recordMetadata.timestamp());
                logger.info(sBuilder.toString());
            } else {
                logger.error(ex.toString());
            }
        }
    }

    public void produce() {
        setTopic("basicTopic");
        ProducerRecord<String, String> record = null;
        for (int i = 0; i < 10; i++) {
            final String key = "Id_" + Integer.toString(i);
            final String value = "Hello - " + Integer.toString(i);
            record = newProducerRecord(getTopic(), key, value);
            getProducer().send(record, new CallBackHandler());
        }
        super.flushAndClose();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Producer producer = new ProducerWithCallback();
        producer.produce();
    }
}
