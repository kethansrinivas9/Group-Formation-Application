package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.questions.Option;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IOptionRetrieveManager {
    List<Option> getOptions(HttpServletRequest request);
}
