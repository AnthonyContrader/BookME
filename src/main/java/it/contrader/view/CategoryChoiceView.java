package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;


public class CategoryChoiceView extends AbstractView {

	private String choice;
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.print("Seleziona la categoria\n [E] per uscire: ");
		choice = getInput();
	}

	@Override
	public void submit() {
		Request request;
		switch(choice)
		{
		case "e":
			request = null;
			MainDispatcher.getInstance().callAction("Login", "doControl", request);
			break;
			
		
			default : 
			request = new Request();
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("Category", "doControl", request);
			break;
		}
		
	}

}
