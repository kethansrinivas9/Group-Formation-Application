package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.questions.Option;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ParseRequest implements IParseRequest {
    public List<Option> getOptions(HttpServletRequest request){
        List<Option> options = new ArrayList<>();
        String displayText, storedAs;
        int iX = 1;
        while(true){
            displayText = request.getParameter("display-text-"+iX+"");
            storedAs = request.getParameter("stored-as-"+iX+"");
            if(displayText == null || storedAs == null){
                break;
            }
            Option option = new Option(displayText, Integer.parseInt(storedAs));
            options.add(option);
            iX++;
        }
        return options;
    }
}
