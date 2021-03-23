package pl.ciechocinek.mb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.ciechocinek.mb.domain.User;
import pl.ciechocinek.mb.service.FacultyService;
import pl.ciechocinek.mb.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private FacultyService facultyService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("faculty", facultyService.listOfFaculty());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		System.out.println(userForm.getFaculty().getId());
		userForm.setFaculty(facultyService.findById(userForm.getFaculty().getId()));
		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		return "redirect:/home";
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		System.out.println("Jest");
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		System.out.println("Jest ok");

		return "index";
	}
}
