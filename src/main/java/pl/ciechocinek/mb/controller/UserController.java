package pl.ciechocinek.mb.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pl.ciechocinek.mb.domain.User;
import pl.ciechocinek.mb.domain.Result;
import pl.ciechocinek.mb.service.FacultyService;
import pl.ciechocinek.mb.service.ResultService;
import pl.ciechocinek.mb.service.SubjectService;
import pl.ciechocinek.mb.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ResultService resultService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		model.addAttribute("faculty", facultyService.listOfFaculty());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, @RequestParam("imgFile") MultipartFile file,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		try {
			Long id = userForm.getFaculty().getId();
			System.out.println(id);

			userService.save(userForm, file);
			int s = subjectService.subjectsFaculty(id).size();
			for (int i = 0; s > i; i++) {
				Result res = new Result(0, userForm, subjectService.subjectsFaculty(id).get(i));
				resultService.save(res);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "index";
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout, HttpServletRequest request) {
		System.out.println("Jest");
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		System.out.println("Jest ok");
		Object name = request.getAttribute("userName");
		System.out.println(name);
		return "index";
	}

	@RequestMapping(value = "/listStudents", method = RequestMethod.GET)
	public ModelAndView getAllItems() {
		return showStudents();
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getStudentOne(Model model, Principal principal) {
		String login = principal.getName();
		return showStudentByUsername(login);
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public String delete(@RequestParam Long id) {
		userService.deleteUser(id);
		return "redirect:/listStudents";
	}

	@RequestMapping(value = "/acceptStudent", method = RequestMethod.GET)
	public String acceptStudent(@RequestParam Long id) {
		User user = userService.getUserById(id);
		user.setStatus(2);
		userService.saveOnlyUser(user);
		return "redirect:/listStudents";
	}

	@RequestMapping(value = "/resultsByStudent", method = RequestMethod.GET)
	public ModelAndView getResultByStudent(@RequestParam Long id) {
		return resultsByStudents(id);
	}

	public ModelAndView showStudents() {
		ModelAndView map = new ModelAndView("listStudents");
		map.addObject("students", userService.findAllStudents());
		return map;
	}

	public ModelAndView showStudentByUsername(String userName) {
		ModelAndView map = new ModelAndView("home");
		map.addObject("user", userService.getByUsername(userName));
		return map;
	}

	public ModelAndView resultsByStudents(Long id) {
		ModelAndView map = new ModelAndView("resultsByStudent");
		map.addObject("resultsByStudent", resultService.showResultByUserId(id));
		return map;
	}

}
