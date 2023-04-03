package com.kh0ma.jsonlogicbankmandate.mvp.dto;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class FlowRequirementDto {
    private String flowType;
    private Map<String, Object> jsonLogic;

    private String description;
    private ParticipationDto participation;
}
