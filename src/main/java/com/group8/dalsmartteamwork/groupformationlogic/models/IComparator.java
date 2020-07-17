package com.group8.dalsmartteamwork.groupformationlogic.models;

import java.util.List;

public interface IComparator {
    int compare(List<String> studentOneResponse, List<String> studentTwoResponse, IGroupFormationRules iGroupFormationRules);
}
