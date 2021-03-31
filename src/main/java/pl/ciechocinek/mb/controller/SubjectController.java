package pl.ciechocinek.mb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.ciechocinek.mb.domain.Subject;
import pl.ciechocinek.mb.service.FacultyService;
import pl.ciechocinek.mb.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private FacultyService facultyService;
	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/addSubject", method = RequestMethod.GET)
	public String addFaculty(Model model) {
		model.addAttribute("formAddSubject", new Subject());
		model.addAttribute("faculty", facultyService.listOfFaculty());

		return "addSubject";
	}

	@RequestMapping(value = "/addSubject", method = RequestMethod.POST)
	public String addFaculty(@ModelAttribute("formAddSubject") Subject formAddSubject, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "addSubject";
		}

		subjectService.save(formAddSubject);

		return "redirect:/admin";
	}

}
