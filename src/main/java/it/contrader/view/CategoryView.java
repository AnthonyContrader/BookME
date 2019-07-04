package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CategorieDTO;
import it.contrader.main.MainDispatcher;

public class CategoryView extends AbstractView{

	private String choice;
	private int lenght;
	
	Request request;
	@Override
	public void showResults(Request request) {
		this.request = request;
		
		if (request != null) {
			System.out.println("\n------------------- Categorie ----------------\n");
			
			@SuppressWarnings("unchecked")
			List<CategorieDTO> categories = (List<CategorieDTO>) request.get("categorie");
			int i = 0;
				for (CategorieDTO u: categories)
				{
				System.out.println("\t" + "[" + i++ + "] " + u.toString());
				}
				lenght = i;
			
		}
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.print("Seleziona la categoria\nOppure premi [E] per uscire: ");
		choice = getInput();
	}

	@Override
	public void submit() {
		if(choice.matches("\\d+")) {
			int categoryId = Integer.parseInt(choice);
			System.out.println(categoryId);
			if(categoryId >= 0 && categoryId < lenght) {
				request.put("categoryId", categoryId);
				MainDispatcher.getInstance().callAction("Category", "doControl", request);
			}
		} else {
			request.remove("categoryId");
			MainDispatcher.getInstance().callAction("Home", "doControl", request);
		}
		
	}
}
