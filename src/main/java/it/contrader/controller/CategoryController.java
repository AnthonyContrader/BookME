package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CategorieDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CategorieService;

public class CategoryController implements Controller{

	public CategorieService categoryService;
	public CategoryController()
	{
		categoryService = new CategorieService();
	}
	
	@Override
	public void doControl(Request request) {
		// TODO Auto-generated method stub
		request = new Request();
		List<CategorieDTO> categoryList = categoryService.GetCategoryList();
		request.put("categorie", categoryList);
		MainDispatcher.getInstance().callView("Category", request);
		
	}

}
