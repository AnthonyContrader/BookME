package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CategorieDTO;
import it.contrader.main.MainDispatcher;

public class CategoryView extends AbstractView{

	private String choice;
	private int lenght;
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		if (request != null) {
			System.out.println("\n------------------- Categorie ----------------\n\n\n");
			
			@SuppressWarnings("unchecked")
			List<CategorieDTO> categories = (List<CategorieDTO>) request.get("categorie");
			int i = 0;
				for (CategorieDTO u: categories)
				{
				System.out.println("\t" + "[" + ++i + "] " + u.toString());
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
		// TODO Auto-generated method stub
		Request request;
		if((Integer.parseInt(choice) > 0) && (Integer.parseInt(choice) < lenght)  )
		{
			request = new Request();
			
			
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("Category", "doControl", request);
		} else 
		{
			request = null;
			MainDispatcher.getInstance().callAction("Login", "doControl", request);
		}
	
		
	}
}
