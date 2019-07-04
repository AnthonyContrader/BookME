package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CategorieDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CategorieService;

public class CategoryController implements Controller{

	private CategorieService categoryService;
	private Request request;
	
	public CategoryController()
	{
		categoryService = new CategorieService();
	}
	
	@Override
	public void doControl(Request request) {
		// TODO Auto-generated method stub
		//entri in questo blocco se hai scelto la categoria
		this.request = request;
		int categoryId;
		if(this.request.get("categoryId") != null)
		{
			categoryId = (int) this.request.remove("categoryId");
			String categoryName = categoryService.getCategoryName(categoryId);
			this.request.put("categoryName", categoryName);
			MainDispatcher.getInstance().callView("CategoryChoice", this.request);
		}
		else
		{
			List<CategorieDTO> categoryList = categoryService.GetCategoryList();
			this.request.put("categorie", categoryList);
			MainDispatcher.getInstance().callView("Category", this.request);
		}
		
	}

}
