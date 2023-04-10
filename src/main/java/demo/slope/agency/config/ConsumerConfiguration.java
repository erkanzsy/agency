package demo.slope.agency.config;

import java.util.HashMap;
import java.util.Map;

import demo.slope.agency.dto.FlightDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
public class ConsumerConfiguration {

    @Value(value = "${kafka.address}")
    private String serverAddress;

    @Value(value = "${kafka.group}")
    private String group;

    @Bean
    public ConsumerFactory<String, FlightDto> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(
                props, new StringDeserializer(),
                new JsonDeserializer<>(FlightDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FlightDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, FlightDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}