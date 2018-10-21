package com.belatrixsf.findpatternweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.belatrixsf.findpatternweb.model.RegexModel;

@Controller
public class IndexController {

	/*@RequestMapping("/")
	public String index() {
		return "index";
	}*/
	
	

	@PostMapping("/hello")
	public String sayHello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);

		RegexModel test = new RegexModel();
		List<RegexModel> tests = new ArrayList<>();
		RegexModel regexModel = new RegexModel(1, "prmero", "regex");
		tests.add(regexModel);
		RegexModel regexModel2 = new RegexModel(2, "segundo", "regex");
		tests.add(regexModel2);
		model.addAttribute("test", test);

		model.addAttribute("tests", tests);

		return "hello";
	}
	
	@PostMapping("/validate")
	public String validate(Model model) {
		
		//String fff = model.
		return "index";
	}

	/**
	 * List all products.
	 *
	 * @param model
	 * @return
	 */
	/*
	 * @RequestMapping(value = "/hello", method = RequestMethod.GET) public String
	 * list(Model model) { RegexModel test = new RegexModel(); List<RegexModel>
	 * tests = new ArrayList<>(); RegexModel regexModel = new RegexModel(1,
	 * "prmero", "regex"); tests.add(regexModel); RegexModel regexModel2 = new
	 * RegexModel(2, "segundo", "regex"); tests.add(regexModel2);
	 * model.addAttribute("test", test);
	 * 
	 * model.addAttribute("tests", tests);
	 * 
	 * System.out.println("Returning rpoducts:"); return "hello"; }
	 * 
	 * @RequestMapping(value = "/hello", method = RequestMethod.POST) public String
	 * validate(@RequestParam("name") String name, Model model) {
	 * System.out.println("entra a validate"); return "hello"; }
	 */

}
