package com.group8.dalsmartteamwork.groupformationlogic.models;

import java.util.List;

public class FreeTextComparator implements IComparator {

    @Override
    public int compare(List<String> studentOneResponse, List<String> studentTwoResponse, IGroupFormationRules iGroupFormationRules) {
        int distance = 0;
        String rule = iGroupFormationRules.getFreeTextRule();

        if (rule.equals("matching")) {
            if (studentOneResponse.get(0).equalsIgnoreCase(studentTwoResponse.get(0))) {
                distance += 1;
            }
        } else if (rule.equals("not-matching")) {
            if (studentOneResponse.get(0).equalsIgnoreCase(studentTwoResponse.get(0)) == false) {
                distance += 1;
            }
        }
        return distance;
    }
}
