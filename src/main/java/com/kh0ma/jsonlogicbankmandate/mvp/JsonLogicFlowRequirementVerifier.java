package com.kh0ma.jsonlogicbankmandate.mvp;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh0ma.jsonlogicbankmandate.mvp.dto.ApprovalDto;
import com.kh0ma.jsonlogicbankmandate.mvp.dto.FlowRequirementDto;
import io.github.jamsesso.jsonlogic.JsonLogic;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.paukov.combinatorics3.Generator;

@Slf4j
public class JsonLogicFlowRequirementVerifier {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static final JsonLogic JSON_LOGIC = new JsonLogic();

    private static <T> Stream<List<T>> buildPermutationStream(List<T> object) {
        return Generator.permutation(object)
                .simple()
                .stream()
                .parallel();
    }


    @SneakyThrows
    public static boolean verify(FlowRequirementDto flowRequirementDto, List<Map> approvals) {

        var jsonLogicString = objectMapper.writeValueAsString(flowRequirementDto.getJsonLogic());

        return buildPermutationStream(approvals)
//                .peek(el -> log.info("Combination: {}", el))
                .anyMatch(el -> verifyInternal(jsonLogicString, el));
    }

    @SneakyThrows
    private static boolean verifyInternal(String jsonLogicString, List<Map> approvalCombination) {
        return (boolean) JSON_LOGIC.apply(jsonLogicString, approvalCombination);
    }
}
