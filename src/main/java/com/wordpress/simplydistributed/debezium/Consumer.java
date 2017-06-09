package com.wordpress.simplydistributed.debezium;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.wordpress.simplydistributed.debezium.domain.key.Key;
import com.wordpress.simplydistributed.debezium.domain.val.Event;
import com.wordpress.simplydistributed.debezium.domain.val.Payload;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer implements Runnable {

    private KafkaConsumer<String, JsonNode> kc;
    private String topic = null;
    private String pollTimeout = null;

    public Consumer() {
        Properties consumerProps = new Properties();
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, System.getenv().getOrDefault("KAFKA_CLUSTER", "192.168.99.100:9092"));
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "kafEEne-group");
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.connect.json.JsonDeserializer");

        topic = System.getenv().getOrDefault("TOPIC_NAME", "test-topic");

        kc = new KafkaConsumer<>(consumerProps);
        kc.subscribe(Arrays.asList(topic));
        System.out.println("Subscribed to topic " + topic);

        pollTimeout = System.getenv().getOrDefault("KAFKA_CONSUMER_POLL_TIMEOUT", "30000"); //default is 30 seconds
    }
    private ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public void run() {
        ConsumerRecords<String, JsonNode> records = kc.poll(Long.valueOf(pollTimeout)); // timeout
        System.out.println("Got " + records.count() + " records");

        for (ConsumerRecord<String, JsonNode> record : records) {
            try {
                Event event = mapper.readValue(record.value().toString(), Event.class);
                Key key = mapper.readValue(record.key(), Key.class);
                Payload payload = event.getPayload();
                if(payload!=null){
                    System.out.println("Record with ID "+key.getPayload().getId() + " was "+ watHappened(payload));
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private String watHappened(Payload payload){
        String action = null;
        
        if(payload.getOp().equals("c")){
            action = "Created";
        }else if(payload.getOp().equals("u")){
            action = "Updated";
        }else if(payload.getOp().equals("d")){
            action = "Deleted";
        }
        
        return action;
    }
}
