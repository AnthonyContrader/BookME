package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;
import it.contrader.services.CategoryService;

@Controller
@RequestMapping("/Category")
public class CategoryController {

	private final CategoryService service;
	
	@Autowired
	public CategoryController(CategoryService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/categoryManagement", method = RequestMethod.GET)
	public String categoryManagement(HttpServletRequest request) {
		List<CategoryDTO> list = this.service.getListaCategoryDTO();
		request.setAttribute("categoriesList", list);
		return "category";
	}
}
