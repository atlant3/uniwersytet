package pl.ciechocinek.mb.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.ciechocinek.mb.domain.Faculty;
import pl.ciechocinek.mb.domain.Result;
import pl.ciechocinek.mb.domain.Subject;
import pl.ciechocinek.mb.domain.User;
import pl.ciechocinek.mb.domain.UserRole;
import pl.ciechocinek.mb.service.ResultService;
import pl.ciechocinek.mb.service.SubjectService;
import pl.ciechocinek.mb.service.UserService;

@Controller
public class ResultController {

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private ResultService resultService;
	Long resultId;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/results", method = RequestMethod.GET)
	public ModelAndView showSubjects(@RequestParam Long id) {
		ModelAndView map = new ModelAndView("results");
		map.addObject("results", resultService.showResultByUserId(id));
		return map;

	}

	@RequestMapping(value = "/setResult", method = RequestMethod.GET)
	public String setResult(@RequestParam Long id, Model model) {
		model.addAttribute("formSetResult", new Result());
		resultId = id;
		return "setResult";
	}

	@RequestMapping(value = "/setResult", method = RequestMethod.POST)
	public String setResult(@ModelAttribute("formSetResult") Result formSetResult, BindingResult bindingResult,
			Model model, Principal principal) {

		if (bindingResult.hasErrors()) {
			return "home";
		}

		Result result = resultService.getResultById(resultId);
		result.setAmount(formSetResult.getAmount());
		resultService.save(result);
		resultService.sumResultUser(userService.findByUserName(principal.getName()).getId());

		return "redirect:/home";
	}

	@RequestMapping(value = "/sendResults", method = RequestMethod.GET)
	public String sendUserResults(@RequestParam Long id) {
		User user = userService.getUserById(id);
		user.setStatus(1);
		userService.saveOnlyUser(user);
		return "redirect:/home";
	}

}
