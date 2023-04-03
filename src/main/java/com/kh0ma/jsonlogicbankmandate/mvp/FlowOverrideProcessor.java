package com.kh0ma.jsonlogicbankmandate.mvp;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh0ma.jsonlogicbankmandate.mvp.dto.FlowRequirementDto;
import com.kh0ma.jsonlogicbankmandate.mvp.dto.RequestDataDto;
import io.github.jamsesso.jsonlogic.JsonLogic;
import lombok.SneakyThrows;


public class FlowOverrideProcessor {
    
    public static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static FlowRequirementDto process(String jsonLogicString, RequestDataDto requestData) {
        var jsonLogic = new JsonLogic();

        var flowRequirementString = (String) jsonLogic.apply(jsonLogicString, getMap(requestData));
        return objectMapper.readValue(flowRequirementString, FlowRequirementDto.class);
    }

    private static Map getMap(RequestDataDto requestData) throws JsonProcessingException {
        return objectMapper.readValue(objectMapper.writeValueAsString(requestData), Map.class);
    }
}
