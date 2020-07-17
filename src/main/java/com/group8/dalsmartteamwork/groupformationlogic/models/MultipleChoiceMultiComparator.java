package com.group8.dalsmartteamwork.groupformationlogic.models;

import java.util.Comparator;
import java.util.List;

public class MultipleChoiceMultiComparator implements IComparator {

    @Override
    public int compare(List<String> studentOneResponse, List<String> studentTwoResponse, IGroupFormationRules iGroupFormationRules) {
        int distance = 0;
        int index = 0;
        String rule = iGroupFormationRules.getMultipleChoiceMultipleOptionRule();

        studentOneResponse.sort(Comparator.naturalOrder());
        studentTwoResponse.sort(Comparator.naturalOrder());

        if (rule.equals("similar")) {
            if (studentOneResponse.size() != studentTwoResponse.size()) {
                return distance;
            } else {
                while (index < studentOneResponse.size()) {
                    if (studentOneResponse.get(index).equals(studentTwoResponse.get(index)) == false) {
                        return distance;
                    }
                    index++;
                }
                distance += 1;
            }
        } else if (rule.equals("dissimilar")) {
            if (studentOneResponse.size() != studentTwoResponse.size()) {
                distance += 1;
            } else {
                while (index < studentOneResponse.size()) {
                    if (studentOneResponse.get(index).equals(studentTwoResponse.get(index)) == false) {
                        distance += 1;
                        break;
                    }
                    index++;
                }
            }
        }
        return distance;
    }
}
