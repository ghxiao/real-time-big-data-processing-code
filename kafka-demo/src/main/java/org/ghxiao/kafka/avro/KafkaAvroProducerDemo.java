package org.ghxiao.kafka.avro;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.ghxiao.kafka.avro.model.CardSuit;
import org.ghxiao.kafka.avro.model.SimpleCard;

import java.util.Properties;

public class KafkaAvroProducerDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Configure serializer classes
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
        // Configure schema repository server
        props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        // Create the producer expecting Avro objects
        KafkaProducer<Object, Object> avroProducer = new KafkaProducer<>(props); // Create the Avro objects for the key and value
        CardSuit suit = new CardSuit("spades");
        SimpleCard card = new SimpleCard("spades", "ace");
        // Create the ProducerRecord with the Avro objects and send them
        ProducerRecord<Object, Object> record = new ProducerRecord<>("my_avro_topic", suit, card);
        avroProducer.send(record);
        avroProducer.close();
    }
}
