package com.kh0ma.jsonlogicbankmandate.mvp.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ParticipationDto {

    private List<String> users;
    private List<String> userGroups;
}
