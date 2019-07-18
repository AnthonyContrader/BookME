package it.contrader.controller;

import static org.mockito.Matchers.anyObject;

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
	
	public void getList(HttpServletRequest request) {
		List<CategoryDTO> list = this.service.getListaCategoryDTO();
		request.setAttribute("categoryList", list);
	}
	
	@RequestMapping(value = "/categoryManagement", method = RequestMethod.GET)
	public String categoryManagement(HttpServletRequest request) {
		getList(request);
		return "category/category";
	}
	
	@RequestMapping(value = "/categoryRead", method = RequestMethod.GET)
	public String categoryRead(HttpServletRequest request) {
		Integer id =  Integer.parseInt(request.getParameter("id"));
		CategoryDTO category = this.service.getCategoryDTOByIdCategory(id);
		request.setAttribute("category", category);
		return "category/categoryView";
	}
	
	@RequestMapping(value = "/categoryInsert", method = RequestMethod.POST)
	public String categoryInsert(HttpServletRequest request) {
		String name = request.getParameter("categoryName");
		CategoryDTO newCategory = new CategoryDTO(0,name);
		this.service.insertCategory(newCategory);
		List<CategoryDTO> list = this.service.getListaCategoryDTO();
		request.setAttribute("categories", list);
		return "category/category";
	}
	
	@RequestMapping(value = "/categoryDelete", method = RequestMethod.GET)
	public String categoryDelete(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		this.service.deleteCategoryById(id);
		List<CategoryDTO> list = this.service.getListaCategoryDTO();
		request.setAttribute("categories", list);
		return "category/category";
	}
	
	@RequestMapping(value = "/categoryUpdate", method = RequestMethod.POST)
	public String categoryUpdate(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("newName");
		CategoryDTO category = new CategoryDTO(id,name);
		this.service.updateCategory(category);
		List<CategoryDTO> list = this.service.getListaCategoryDTO();
		request.setAttribute("categories", list);
		return "category/category";
	}
	
}
