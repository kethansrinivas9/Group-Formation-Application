package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.courseadmin.Pair;

import java.util.ArrayList;
import java.util.List;

public class MakePairServiceImpl implements MakePairService {

    @Override
    public List<Pair<User, Boolean>> getUserDetails(List<User> users, List<Boolean> status) {
        List<Pair<User, Boolean>> details = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            Pair<User, Boolean> temp = new Pair<User, Boolean>(users.get(i), status.get(i));
            details.add(temp);
        }
        return details;
    }
}
