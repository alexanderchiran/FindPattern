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
import com.belatrixsf.findpatternweb.model.Product;
import com.belatrixsf.findpatternweb.model.RegexModel;
import com.belatrixsf.findpatternweb.service.IConsumingAPI;
import com.belatrixsf.findpatternweb.service.IRegex;
import com.belatrixsf.findpatternweb.service.ProductService;

/**
 * Product controller.
 */
@Controller
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;
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
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("products", productService.listAllProducts());
		System.out.println("Returning rpoducts:");
		return "products";
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
		System.out.println("Objeto seleccionado: " + regexModel.getId());
		Message message= iConsumingAPI.callFindPattern(regexModel.getId());
		if(message!=null) {
			logger.info(message.toString());
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
	@RequestMapping("product/{id}")
	public String showProduct(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productshow";
	}

	// Afficher le formulaire de modification du Product
	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "productform";
	}

	/**
	 * New product.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("product/new")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		return "productform";
	}

	/**
	 * Save product to database.
	 *
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "product", method = RequestMethod.POST)
	public String saveProduct(Product product) {
		productService.saveProduct(product);
		return "redirect:/product/" + product.getId();
	}

	/**
	 * Delete product by its id.
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("product/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}

}
