package com.group8.dalsmartteamwork.groupformationlogic.models;

import java.util.List;

public class NumericComparator implements IComparator {

    @Override
    public int compare(List<String> studentOneResponse, List<String> studentTwoResponse, IGroupFormationRules iGroupFormationRules) {
        int distance = 0;
        String rule = iGroupFormationRules.getNumericRule();

        if (rule.equals("similar")) {
            if (studentOneResponse.get(0).equals(studentTwoResponse.get(0))) {
                distance += 1;
            }
        } else if (rule.equals("dissimilar")) {
            if (studentOneResponse.get(0).equals(studentTwoResponse.get(0)) == false) {
                distance += 1;
            }
        }
        return distance;
    }
}
