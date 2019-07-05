package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryInsertView extends AbstractView{

	private String categoryName;
	private Request request;
	
	@Override
	public void showResults(Request request) {
		
		this.request = request;
		System.out.println("------------------- INSERT VIEW ----------------\n");
		
	}

	@Override
	public void showOptions() {
		
		System.out.print("Nome nuova categoria: ");
		categoryName = getInput();
	}

	@Override
	public void submit() {
		request.put("newCategory", categoryName);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
		
	}

	
}
