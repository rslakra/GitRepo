package com.rslakra.hellokafka.producer;

import com.rslakra.hellokafka.AbstractKafka;
import com.rslakra.hellokafka.Producer;
import com.rslakra.hellokafka.utils.KafkaUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Objects;
import java.util.Properties;

/**
 * @author: Rohtash Lakra (rlakra)
 * @since: 10/30/19 5:40 PM
 */
public abstract class AbstractProducer<K, V> extends AbstractKafka<K, V> implements Producer {

    private KafkaProducer<K, V> producer;
    private ProducerRecord<K, V> record;

    /**
     * @param properties
     */
    public AbstractProducer(final Properties properties) {
        super(properties);
    }

    public KafkaProducer getProducer() {
        return this.producer;
    }

    public ProducerRecord getRecord() {
        return this.record;
    }

    protected void initProducer() {
        producer = new KafkaProducer<K, V>(getProperties());
    }

    /**
     * @param topic
     * @param key
     * @param value
     */
    protected void initProducerRecord(final String topic, final K key, final V value) {
        setTopic(topic);
        if (KafkaUtils.isNull(producer)) {
            initProducer();
        }
        record = newProducerRecord(topic, key, value);
    }

    /**
     * @param topic
     * @param value
     */
    protected void initProducerRecord(final String topic, final V value) {
        initProducerRecord(topic, null, value);
    }

    /**
     * @param topic
     * @param key
     * @param value
     * @return
     */
    protected ProducerRecord newProducerRecord(final String topic, final K key, final V value) {
        ProducerRecord<K, V> newRecord = null;
        if (Objects.isNull(key)) {
            newRecord = new ProducerRecord<K, V>(topic, value);
        } else {
            newRecord = new ProducerRecord<K, V>(topic, key, value);
        }

        return newRecord;
    }

    /**
     * @param topic
     * @param value
     * @return
     */
    protected ProducerRecord newProducerRecord(final String topic, final V value) {
        return newProducerRecord(topic, null, value);
    }

    /**
     *
     */
    protected void flushAndClose() {
        getProducer().flush();
        getProducer().close();
    }

}
