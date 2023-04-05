package com.kh0ma.jsonlogicbankmandate;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.kh0ma.jsonlogicbankmandate.mvp.FlowOverrideHolder;
import com.kh0ma.jsonlogicbankmandate.mvp.FlowOverrideProcessor;
import com.kh0ma.jsonlogicbankmandate.mvp.JsonLogicFlowRequirementVerifier;
import com.kh0ma.jsonlogicbankmandate.mvp.dto.ApprovalBuilder;
import com.kh0ma.jsonlogicbankmandate.mvp.dto.RequestDataDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlaygroundMain {

    public static void main(String[] args) {
        boolean result = validate(
                FlowOverrideHolder.FLOW_OVERRIDE,
                RequestDataDto.builder()
                        .amount(BigDecimal.TEN)
                        .currencyCode("AED")
                        .operation("LOCAL_TRANSFER")
                        .build(),
                List.of(
                        ApprovalBuilder.of(List.of("A", "B")).build(),
                        ApprovalBuilder.of(List.of("C")).build())
        );

        log.info("Result of validation. result={}", result);
    }

    private static boolean validate(String flowOverrideString, RequestDataDto requestDataDto, List<Map> approvals) {
        var requirementDto = FlowOverrideProcessor.process(flowOverrideString, requestDataDto);

        log.info("Requirement was found. requirement={}", requirementDto.getDescription());
        return JsonLogicFlowRequirementVerifier.verify(requirementDto, approvals);
    }
}
