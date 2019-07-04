package it.contrader.view;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;


public class CategoryChoiceView extends AbstractView {

	private String choice;
	private Request request;
	@Override
	public void showResults(Request request) {
		
		this.request = request;
		String categoryName = this.request.remove("categoryName").toString();
		
		System.out.println("\n------------------- "+ categoryName + " ----------------\n");
		System.out.println("Nothing to display apparently...");
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Premi [E] per uscire: ");
		choice = getInput();
	}

	@Override
	public void submit() {
		switch(choice)
		{
			case "e":
				request.remove("choice");
				MainDispatcher.getInstance().callAction("Category", "doControl", request);
				break;
					
			default : 
				request.remove("choice");
				MainDispatcher.getInstance().callAction("Category", "doControl", request);
				break;
		}
		
	}

}
