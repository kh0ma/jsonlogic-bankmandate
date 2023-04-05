package com.kh0ma.jsonlogicbankmandate.mvp.dto;

import java.util.Arrays;
import java.util.List;

public class ApprovalBuilder {
    private String individualId;
    private List<String> assignedGroups;

    private ApprovalBuilder(String individualId, List<String> assignedGroups) {
        this.individualId = individualId;
        this.assignedGroups = assignedGroups;
    }

    public static ApprovalBuilder of(String individualId) {
        return new ApprovalBuilder(individualId, List.of());
    }

    public static ApprovalBuilder of(List<String> assignedGroups) {
        return new ApprovalBuilder(null, assignedGroups);
    }

    public static ApprovalBuilder of(String individualId, String... groups) {
        return new ApprovalBuilder(individualId, Arrays.asList(groups));
    }

    public ApprovalDto build() {
        return ApprovalDto.builder()
                .userId(this.individualId)
                .assignedGroups(this.assignedGroups.toArray(new String[] {}))
                .build();
    }
}
