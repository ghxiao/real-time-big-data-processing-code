package org.ghxiao.kafka.avro;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.ghxiao.kafka.avro.model.CardSuit;
import org.ghxiao.kafka.avro.model.SimpleCard;

import java.util.Arrays;
import java.util.Properties;

public class kafkaAvroConsumerDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "testgroup");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,
                "http://localhost:8081");
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
        KafkaConsumer<CardSuit, SimpleCard> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("my_avro_topic"));
        while (true) {
            ConsumerRecords<CardSuit, SimpleCard> records = consumer.poll(100);
            for (ConsumerRecord<CardSuit, SimpleCard> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key().getSuit(), record.value().getCard());
            }
        }
    }
}
