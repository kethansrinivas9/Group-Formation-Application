package com.group8.dalsmartteamwork.courseadmin.services;

import com.group8.dalsmartteamwork.courseadmin.models.Pair;
import com.group8.dalsmartteamwork.utils.User;

import java.util.List;

public interface MakePairService {
    List<Pair<User, Boolean>> getUserDetails(List<User> users, List<Boolean> status);
}
