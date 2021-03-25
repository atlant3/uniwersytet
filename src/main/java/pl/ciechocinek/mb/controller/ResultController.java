package pl.ciechocinek.mb.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.ciechocinek.mb.domain.Result;
import pl.ciechocinek.mb.domain.Subject;
import pl.ciechocinek.mb.domain.User;
import pl.ciechocinek.mb.domain.UserRole;
import pl.ciechocinek.mb.service.ResultService;
import pl.ciechocinek.mb.service.SubjectService;

@Controller
public class ResultController {

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ResultService resultService;
	

	@RequestMapping(value = "/addPoints", method = RequestMethod.GET)
	public ModelAndView showSubjects(@RequestParam Long id) {
		ModelAndView map = new ModelAndView("addPoints");
		map.addObject("subjects", subjectService.subjectsFaculty(id));
		return map;

	}

}
