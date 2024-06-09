package com.rslakra.hellokafka.consumer;

import com.rslakra.hellokafka.Consumer;
import com.rslakra.hellokafka.utils.KafkaUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;

/**
 * @author: Rohtash Lakra (rlakra)
 * @since: 10/30/19 5:37 PM
 */
public class BasicConsumer extends AbstractConsumer<String, String> implements Consumer {

    private Logger logger = LoggerFactory.getLogger(BasicConsumer.class);

    public BasicConsumer() {
        super(KafkaUtils.INSTANCE.getConsumerConfigs("basicConsumer", AutoOffsetReset.EARLIEST));
        initConsumer();
        setTopic("basicTopic");
    }


    @Override
    public void consume() {
        getConsumer().subscribe(Arrays.asList(getTopic()));
        while (true) {
            ConsumerRecords<String, String> records = getConsumer().poll(Duration.ofMillis(100));
            for (ConsumerRecord record : records) {
                logger.info("Key:" + record.key() + ", Value: " + record.value());
                logger.info("Partition:" + record.partition() + ", Offset: " + record.offset());
            }

        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Consumer consumer = new BasicConsumer();
        consumer.consume();
    }
}
