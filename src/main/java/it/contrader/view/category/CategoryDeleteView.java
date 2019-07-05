package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryDeleteView extends AbstractView{

	private String choice;
	private Request request;
	
	@Override
	public void showResults(Request request) {
		
		this.request = request;
		System.out.println("------------------- DELETE VIEW ----------------\n");
		System.out.println("Nothing to display apparently...\n");
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("[T]orna al menù");
		choice = getInput();
	}

	@Override
	public void submit() {
		switch(choice.toUpperCase())
		{
			default : 
				request.remove("mode");
				MainDispatcher.getInstance().callAction("Category", "doControl", request);
				break;
		}
		
	}

}
