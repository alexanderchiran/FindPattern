package com.belatrixsf.findpatternweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.belatrixsf.findpatternweb.model.Message;
import com.belatrixsf.findpatternweb.model.RegexModel;
import com.belatrixsf.findpatternweb.service.IConsumingAPI;
import com.belatrixsf.findpatternweb.service.IRegex;

/**
 * Product controller.
 */
@Controller
public class ProcessURLController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	//@Autowired
	//private ProductService productService;
	@Autowired
	private IRegex iRegex;
	@Autowired
	private IConsumingAPI iConsumingAPI;

	@RequestMapping("/")
	String index() {
		return "index";
	}

	/**
	 * List all products.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/regexModels", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("listRegexModel", iRegex.findAll());
		return "regexModels";
	}

	/**
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	public String process(Model model) {

		try {
			RegexModel regexModel = new RegexModel();
			model.addAttribute("regexModel", regexModel);

			List<RegexModel> listRegexModel = new ArrayList<>();
			listRegexModel = iRegex.findAll();
			model.addAttribute("listRegexModel", listRegexModel);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "process";
	}

	@RequestMapping(value = "/initprocess", method = RequestMethod.GET)
	public String initprocess(@ModelAttribute("regexModel") RegexModel regexModel, Model model) {

		try {
			Integer i= new Integer(regexModel.getId());
			Message message = iConsumingAPI.callFindPattern(i);
			if (message != null) {
				model.addAttribute("message", message.getMessage());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return "index";
	}

	/**
	 * View a specific product by its id.
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("regexModel/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("regexModel", iRegex.getRegexModelById(id));
		return "regexModelsshow";
	}

	/**
	 * Edit regexModel 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("regexModel/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("regexModel", iRegex.getRegexModelById(id));
		return "regexModelform";
	}

	/**
	 * New regexModel.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("regexModel/new")
	public String newProduct(Model model) {
		RegexModel regexModel= new RegexModel();
		model.addAttribute("regexModel", regexModel);
		return "regexModelform";
	}

	/**
	 * Save regexModel to Mongo.
	 *
	 * @param regexModel
	 * @return
	 */
	@RequestMapping(value = "regexModel", method = RequestMethod.POST)
	public String saveProduct(RegexModel regexModel) {
		iRegex.saveRegexModel(regexModel);		
		return "redirect:/regexModel/" + regexModel.getId();
	}

	/**
	 * Delete regexModel by its id.
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("regexModel/delete/{id}")
	public String delete(@PathVariable Integer id) {
		iRegex.deleteRegexModel(id);
		
		return "redirect:/regexModels";
	}

}
