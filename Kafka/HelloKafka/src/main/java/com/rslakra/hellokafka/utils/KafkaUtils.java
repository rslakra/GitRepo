package com.rslakra.hellokafka.utils;

import com.rslakra.hellokafka.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * @author: Rohtash Lakra (rlakra)
 * @since: 10/31/19 5:47 PM
 */
public enum KafkaUtils {
    INSTANCE;

    public static boolean isNull(Object object) {
        return Objects.isNull(object);
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    public static boolean isNullOrEmpty(Object object) {
        if (isNull(object)) {
            return true;
        } else if (object instanceof String && ((String) object).trim().length() == 0) {
            return true;
        } else if (object instanceof Object[] && ((Object[]) object).length == 0) {
            return true;
        } else if (object instanceof Collection<?> && isNullOrEmpty((Collection<?>) object)) {
            return true;
        } else if (object instanceof Map<?, ?> && isNullOrEmpty((Map<?, ?>) object)) {
            return true;
        }

        return false;
    }

    public static boolean isNotNullOrEmpty(Object object) {
        return (!isNullOrEmpty(object));
    }

    public static boolean isNullOrEmpty(Collection<?> collection) {
        return (isNull(collection) || collection.isEmpty());
    }

    public static boolean isNotNullOrEmpty(Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return (isNull(map) || map.isEmpty());
    }

    public static boolean isNotNullOrEmpty(Map<?, ?> map) {
        return !isNullOrEmpty(map);
    }

    private final Properties producerConfigs = new Properties();
    private final Properties consumerConfigs = new Properties();

    /**
     * Returns the bootstrap server.
     *
     * @return
     */
    public String getBootStrapServer() {
        return "127.0.0.1:9092";
    }

    /**
     * @return
     */
    public Properties getProducerConfigs() {
        if (producerConfigs.isEmpty()) {
            producerConfigs
                .put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaUtils.INSTANCE.getBootStrapServer());
            producerConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            producerConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        }

        return producerConfigs;
    }


    /**
     * @return
     */
    public Properties getConsumerConfigs(final String groupId, final Consumer.AutoOffsetReset autoOffsetReset) {
        if (consumerConfigs.isEmpty()) {
            consumerConfigs
                .put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaUtils.INSTANCE.getBootStrapServer());
            consumerConfigs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            consumerConfigs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            if (KafkaUtils.isNotNullOrEmpty(groupId)) {
                consumerConfigs.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            }

            if (KafkaUtils.isNotNull(autoOffsetReset)) {
                consumerConfigs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset.toString());
            }
        }

        return consumerConfigs;
    }

}
