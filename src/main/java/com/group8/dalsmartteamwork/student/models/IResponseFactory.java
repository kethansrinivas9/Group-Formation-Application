package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.student.IResponseObject;

public interface IResponseFactory {
    IResponseObject getResponseObject(int questionId);
}
