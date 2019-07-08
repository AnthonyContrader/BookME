package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryReadView extends AbstractView{

	private String choice;
	private Request request;
	private String mode;
	
	@Override
	public void showResults(Request request) {
		
		this.request = request;
		String categoryName = this.request.remove("categoryName").toString();
		int categoryId = (int) this.request.get("categoryId");
		
		System.out.print("------------------- READ VIEW ----------------");
		System.out.println("\n------------------- "+ categoryName + " ----------------\n\n\n");
		System.out.print(categoryId + "\n\n");
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("[T]orna al menù  [V]vedi storie");
		choice = getInput();
	}

	@Override
	public void submit() {
		switch(choice.toUpperCase())
		{
		
		case("V") :
			mode = "READ";
			request.put("Read", mode);
			MainDispatcher.getInstance().callAction("Story", "doControl", request);
		break;
		
		
			default : 
				request.remove("mode");
				MainDispatcher.getInstance().callAction("Category", "doControl", request);
				break;
		}
		
	}

}
