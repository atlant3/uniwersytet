package pl.ciechocinek.mb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.ciechocinek.mb.domain.Faculty;
import pl.ciechocinek.mb.service.FacultyService;

@Controller
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value = "/addFaculty", method = RequestMethod.GET)
	public String addFaculty(Model model) {
		model.addAttribute("formAddFaculty", new Faculty());

		return "addFaculty";
	}

	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
	public String addFaculty(@ModelAttribute("formAddFaculty") Faculty formAddFaculty, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "addFaculty";
		}

		facultyService.save(formAddFaculty);

		return "redirect:/admin";
	}

}
