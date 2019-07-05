package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CategorieDTO;
import it.contrader.main.MainDispatcher;

public class CategoryView extends AbstractView{

	private String action;
	private int lenght;
	Request request;
	@Override
	public void showResults(Request request) {
		
			this.request = request;
			System.out.println("\n------------------- Categorie ----------------\n");
			
			@SuppressWarnings("unchecked")
			List<CategorieDTO> categories = (List<CategorieDTO>) request.get("categorie");
			lenght=0;
				for (CategorieDTO u: categories)
				{
				System.out.println("\t" + "[" + lenght++ + "] " + u.toString());
				}
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.print("\n[0-"+ (lenght-1) +"] Seleziona la categoria");
		System.out.print("\t[I]nserisci");
		System.out.print("\t[E]limina");
		System.out.print("\t[M]odifica");
		System.out.print("\t[T]orna al menù\n");
		action = getInput();
	}

	@Override
	public void submit() {
		if(action.matches("\\d+")) {
			int categoryId = Integer.parseInt(action);
			if(categoryId >= 0 && categoryId < lenght) {
				Request.getInstance().put("mode", "READ");
				Request.getInstance().put("categoryId", categoryId);
			} else {
				Request.getInstance().remove("mode");
			}
		} else {
			switch(action.toUpperCase()) {
				case "I":
					Request.getInstance().put("mode", "INSERT");
					break;
				case "E":
					Request.getInstance().put("mode", "DELETE");
					break;
				case "M":
					Request.getInstance().put("mode", "UPDATE");
					break;
				case "T":
					Request.getInstance().remove("mode");
					MainDispatcher.getInstance().callAction("Home", "doControl", request);
				default:
					Request.getInstance().remove("mode");
					MainDispatcher.getInstance().callAction("Category", "doControl", request);
					break;
			}
			
		}
		MainDispatcher.getInstance().callAction("Category", "doControl", request);	
	}
}
