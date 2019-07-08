package it.contrader.view.category;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.StoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryReadView extends AbstractView{

	private String choice;
	private Request request;
	private String mode;
	private List<StoryDTO> list;
	
	@SuppressWarnings("unchecked")
	@Override
	public void showResults(Request request) {
		
		this.request = request;
		String categoryName = this.request.remove("categoryName").toString();
		int categoryId = (int) this.request.get("categoryId");
		
		System.out.print("------------------- READ VIEW ----------------");
		System.out.println("\n------------------- "+ categoryName + " ----------------");
		System.out.print("\n\n");
		list = (List<StoryDTO>) request.get("lista");
		for(StoryDTO t : list)
		{
			System.out.println(t.getId_story()+ " "+t.getTrama()+ " "+t.getId_Categoria());
		}
		
	}

	
	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		
		System.out.println("[T]orna al menù  [I]inserisci storie");
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
		
		case("I") :
			//System.out.print("\n\nSei chiamiamo storyContl");
			mode = "INSERT";
			choice = "GETCHOICE";
			request.put("mode", mode);
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("Story", "doControl", request);
		break;
		
		
			default : 
				request.remove("mode");
				MainDispatcher.getInstance().callAction("Category", "doControl", request);
				break;
		}
		
	}

}
