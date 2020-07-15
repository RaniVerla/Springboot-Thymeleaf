package org.o7plannng.sbshoppingcart.controller;

import org.o7plannng.sbshoppingcart.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class StudentController {

	@Autowired
	private StudentService service;

	@RequestMapping(value = "/login")
	public String homePage() {
		return "customLogin";
	}

	@RequestMapping(value = "/secure/studentDetail")
	public String studentDetail(Model model) {
		model.addAttribute("students", service.getStudents());
		return "student";
	}

}
