package com.rslakra.hellokafka;

import java.util.Objects;
import java.util.Properties;

/**
 * @author: Rohtash Lakra (rlakra)
 * @since: 10/30/19 5:40 PM
 */
public abstract class AbstractKafka<K, V> {

    private String topic;
    private Properties properties;

    /**
     * @param properties
     */
    public AbstractKafka(final Properties properties) {
        setProperties(properties);
    }

    public AbstractKafka() {
        this(new Properties());
    }

    /**
     * @return
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * @param topic
     */
    public void setTopic(final String topic) {
        this.topic = topic;
    }

    /**
     * @return
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * @param properties
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
        if (Objects.isNull(this.properties)) {
            this.properties = new Properties();
        }
    }

    /**
     * @param key
     * @param value
     */
    public final void addProperty(final String key, final Object value) {
        properties.put(key, value);
    }

    /**
     * @param key
     * @param value
     */
    public final void addProperty(final String key, final String value) {
        addProperty(key, value);
    }

}
