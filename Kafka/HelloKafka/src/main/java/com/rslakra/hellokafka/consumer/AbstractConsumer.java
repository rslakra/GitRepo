package com.rslakra.hellokafka.consumer;

import com.rslakra.hellokafka.AbstractKafka;
import com.rslakra.hellokafka.Consumer;
import com.rslakra.hellokafka.utils.KafkaUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Objects;
import java.util.Properties;

/**
 * @author: Rohtash Lakra (rlakra)
 * @since: 10/30/19 5:40 PM
 */
public abstract class AbstractConsumer<K, V> extends AbstractKafka<K, V> implements Consumer {

    private KafkaConsumer<K, V> consumer;
    private ConsumerRecord<K, V> record;

    /**
     * @param properties
     */
    public AbstractConsumer(final Properties properties) {
        super(properties);
    }

    /**
     * @return
     */
    public KafkaConsumer<K, V> getConsumer() {
        return this.consumer;
    }

    /**
     * @return
     */
    public ConsumerRecord<K, V> getRecord() {
        return this.record;
    }

    /**
     * @param properties
     */
    protected void initConsumer(final Properties properties) {
        consumer = new KafkaConsumer<K, V>(properties);
    }

    protected void initConsumer() {
        initConsumer(getProperties());
    }

//    /**
//     * @param topic
//     * @param key
//     * @param value
//     */
//    protected void initConsumerRecord(final String topic, final K key, final V value) {
//        setTopic(topic);
//        if (KafkaUtils.isNull(consumer)) {
//            initConsumer();
//        }
//        record = newConsumerRecord(topic, key, value);
//    }
//
//    /**
//     * @param topic
//     * @param value
//     */
//    protected void initConsumerRecord(final String topic, final V value) {
//        initConsumerRecord(topic, null, value);
//    }
//
//    /**
//     * @param topic
//     * @param key
//     * @param value
//     * @return
//     */
//    protected ConsumerRecord<K, V> newConsumerRecord(final String topic, final K key, final V value) {
//        setTopic(topic);
//        ConsumerRecord<K, V> consumerRecord = null;
//        if (Objects.isNull(key)) {
//            consumerRecord = new ConsumerRecord<K, V>(getTopic());
//        } else {
//            consumerRecord = new ConsumerRecord<K, V>(topic, key, value);
//        }
//
//        return consumerRecord;
//    }

}
