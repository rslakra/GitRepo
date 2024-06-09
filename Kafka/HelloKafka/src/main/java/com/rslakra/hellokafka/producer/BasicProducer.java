package com.rslakra.hellokafka.producer;

import com.rslakra.hellokafka.Producer;
import com.rslakra.hellokafka.utils.KafkaUtils;

/**
 * @author: Rohtash Lakra (rlakra)
 * @since: 10/30/19 5:37 PM
 */
public class BasicProducer extends AbstractProducer<String, String> implements Producer {

    public BasicProducer() {
        super(KafkaUtils.INSTANCE.getProducerConfigs());
        initProducerRecord("basicTopic", "Basic Topic");
    }

    public void produce() {
        getProducer().send(getRecord());
        super.flushAndClose();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        Producer producer = new BasicProducer();
        producer.produce();
    }
}
