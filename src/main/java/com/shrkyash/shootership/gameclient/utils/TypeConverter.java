package com.shrkyash.shootership.gameclient.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shrkyash.shootership.gameclient.models.base.ConcreteFrame;
import com.shrkyash.shootership.gameclient.models.base.UserFrame;
import org.springframework.stereotype.Component;

@Component
public class TypeConverter {
    private final ObjectMapper objectMapper;

    public TypeConverter() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public UserFrame getFrame(String payloadInString) throws JsonProcessingException {
        return this.objectMapper.readValue(payloadInString, UserFrame.class);
    }

    public String toString(Object object) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(object);
    }
}
