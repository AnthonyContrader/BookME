package it.contrader.controller;

import java.util.List;

import it.contrader.dto.CategorieDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CategorieService;

public class CategoryController implements Controller{

	private CategorieService categoryService;
	private final String sub_package = "category.";
	
	public CategoryController()
	{
		categoryService = new CategorieService();
	}
	
	@Override
	public void doControl(Request request) {
		if(request.get("mode")!=null) {
			switch(request.get("mode").toString()) {
			
				case "READ":
					int categoryId;
					categoryId = (int) request.get("categoryId");
					String categoryName = categoryService.getCategoryName(categoryId);
					request.put("categoryName", categoryName);
					MainDispatcher.getInstance().callView(sub_package + "CategoryRead", Request.getInstance());
					break;
					
				case "INSERT":
					if(request.get("newCategory")!=null) {
						String newCategoryName = request.remove("newCategory").toString();
						CategorieDTO nuovaCategoria = new CategorieDTO(newCategoryName);
						System.out.println(categoryService.insert(nuovaCategoria));
						request.remove("mode");
					} else {
						MainDispatcher.getInstance().callView(sub_package + "CategoryInsert", Request.getInstance());
					}
					break;
					
				case "DELETE":
					if(request.get("idToDelete")!= null) {
						int idToDelete = (int) request.remove("idToDelete");
						categoryService.delete(idToDelete);
						request.remove("mode");
					} else {
						MainDispatcher.getInstance().callView(sub_package + "CategoryDelete", Request.getInstance());
					}	
					break;
					
				case "UPDATE":
					MainDispatcher.getInstance().callView(sub_package + "CategoryUpdate", Request.getInstance());
					break;
					
				default:
					
					break;
			}
		}		
		// else
		List<CategorieDTO> categoryList = categoryService.GetCategoryList();
		request.put("categorie", categoryList);
		MainDispatcher.getInstance().callView("Category", Request.getInstance());
		
		
	}
	

}
