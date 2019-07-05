package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryReadView extends AbstractView{

	private String choice;
	private Request request;
	
	@Override
	public void showResults(Request request) {
		
		this.request = request;
		String categoryName = this.request.remove("categoryName").toString();
		System.out.print("------------------- READ VIEW ----------------");
		System.out.println("\n------------------- "+ categoryName + " ----------------\n");
		System.out.println("Nothing to display apparently...");
		
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
