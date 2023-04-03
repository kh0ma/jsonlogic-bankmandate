package com.kh0ma.jsonlogicbankmandate.mvp.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map build() {
        var result = new HashMap<>();
        result.put("individualId", this.individualId);
        result.put("assignedGroups", this.assignedGroups);
        return result;
    }
}
