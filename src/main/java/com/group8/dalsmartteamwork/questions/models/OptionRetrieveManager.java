package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.questions.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class OptionRetrieveManager implements IOptionRetrieveManager {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public List<Option> getOptions(HttpServletRequest request) {
        List<Option> options = new ArrayList<>();
        String displayText, storedAs;
        int inputIndex = 1;
        while (true) {
            displayText = request.getParameter("display-text-" + inputIndex + "");
            storedAs = request.getParameter("stored-as-" + inputIndex + "");
            if (displayText == null || storedAs == null) {
                break;
            }
            Option option = new Option(displayText, Integer.parseInt(storedAs));
            options.add(option);
            inputIndex++;
        }
        LOGGER.info("Options successfully retrieved");
        return options;
    }
}
