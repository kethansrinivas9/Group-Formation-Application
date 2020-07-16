package com.group8.dalsmartteamwork.questionmanager.controller;

import com.group8.dalsmartteamwork.questionmanager.dao.SortDao;
import com.group8.dalsmartteamwork.questionmanager.dao.SortDaoImpl;
import com.group8.dalsmartteamwork.questions.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class SortController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/questionManager")
	public String getInstructor() {
		return "questionManager";
	}

	@GetMapping("/sortQuestion")
	public String sortQuestions(Principal principal, Model model) {
		SortDao sortDaoImpl = new SortDaoImpl();
		List<Question> sortedQuestionList = sortDaoImpl.getAllQuestion(principal.getName());
		model.addAttribute("list", sortedQuestionList);
		if (model.containsAttribute("list")) {
			return "sortQuestion";
		} else {
			LOGGER.warn("Failed to sort questons.");
			return "questionManager";
		}
	}

	@GetMapping("/sortQuestionByTitle")
	public String sortQuestionsBasedOnTitle(Principal principal, Model model) {
		SortDao sortDaoImpl = new SortDaoImpl();
		List<Question> sortedList = sortDaoImpl.sortQuestionsByTitle(principal.getName());
		model.addAttribute("list", sortedList);
		return "sortQuestionByTitle";
	}

	@GetMapping("/sortQuestionByDate")
	public String sortQuestionsBasedOnDate(Principal principal, Model model) {
		SortDao sortDaoImpl = new SortDaoImpl();
		List<Question> sortedList = sortDaoImpl.sortAllQuestionByDate(principal.getName());
		model.addAttribute("list", sortedList);
		return "sortQuestionByDate";
	}
}