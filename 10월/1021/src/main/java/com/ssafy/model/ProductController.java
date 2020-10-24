package com.ssafy.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

@RequestMapping("/main")
@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value ="/regist",method = RequestMethod.POST)
	public String regist(String id, String name, int price, String description, Model model ) {
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setDescription(description);
		service.insert(product);
		return "redirect: list";
	}
	
	@RequestMapping(value = "/list", method= RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list",service.selectAll());
		
		return "list";
	}
}
