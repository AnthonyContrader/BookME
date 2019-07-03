package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CategorieDTO;
import it.contrader.main.MainDispatcher;

public class CategoryView extends AbstractView{

	private String choice;
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		if (request != null) {
			System.out.println("\n------------------- Categorie ----------------\n\n\n");
			
			@SuppressWarnings("unchecked")
			List<CategorieDTO> categories = (List<CategorieDTO>) request.get("categorie");
			for (CategorieDTO u: categories)
				System.out.println("\t" + u.toString());
			System.out.println();
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
		// TODO Auto-generated method stub
		switch(choice)
		{
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;
			default : 
				System.out.print("Comando invalido");
				MainDispatcher.getInstance().callAction("Category", "doControl", null);
				break;
		}
		
	}

}
