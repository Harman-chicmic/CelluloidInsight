package com.example.CelluloidInsight.services;

import com.example.CelluloidInsight.Dto.ProducerDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@EnableKafka
@Slf4j
@RequiredArgsConstructor
public class ProducerService {
    @Autowired
    private KafkaTemplate<Integer,ProducerDto> kafkaTemplate;

    @Value("${kafka.topic-create}")
    private String TOPIC_CREATE;
    @Value("${kafka.topic-update}")
    private String TOPIC_UPDATE;

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return objectMapper;
    }

    public CompletableFuture<SendResult<Integer, String>> produceCreateRatingMessage(ProducerDto producerDto) {

        ProducerRecord<Integer,ProducerDto> producerRecord = buildProducerRecord(producerDto,TOPIC_CREATE);        // can later see if need seperate keys
        kafkaTemplate.send(producerRecord);     // send message
        return new CompletableFuture<>();
    }
    public CompletableFuture<SendResult<Integer, String>> produceUpdateRatingMessage(ProducerDto producerDto) {

        ProducerRecord<Integer,ProducerDto> producerRecord = buildProducerRecord(producerDto,TOPIC_UPDATE);        // can later see if need seperate keys
        kafkaTemplate.send(producerRecord);     // send message
        return new CompletableFuture<>();
    }
    private ProducerRecord<Integer, ProducerDto> buildProducerRecord(ProducerDto value, String topic) {

//        List<Header> recordHeaders = List.of(new RecordHeader("authentication", "Bearer 1234567890".getBytes()));
        return new ProducerRecord<>(topic, value);
    }
}
