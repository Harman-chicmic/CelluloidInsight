package com.example.CelluloidInsight.configurations;

import com.example.CelluloidInsight.Dto.ProducerDto;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ProducerDtoSerializer implements Serializer<ProducerDto> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, ProducerDto data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing DTO", e);
        }
    }
}

