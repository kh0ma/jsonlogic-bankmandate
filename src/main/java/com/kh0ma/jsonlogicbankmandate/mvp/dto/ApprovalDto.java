package com.kh0ma.jsonlogicbankmandate.mvp.dto;


import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@EqualsAndHashCode(of = "userId", callSuper = false)
@Getter
@ToString
public class ApprovalDto extends AbstractMap<String, Object> {

    private final String userId;
    private final String[] assignedGroups;
    private Map<String, Object> map;

    public Map<String, Object> getMap() {
        if (this.map == null) {
            this.map = toMap();
        }
        return this.map;
    }

    private Map<String, Object> toMap() {
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("userId", this.userId);
        objectObjectHashMap.put("assignedGroups", Arrays.asList(this.assignedGroups));
        return objectObjectHashMap;
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return getMap().entrySet();
    }
}
