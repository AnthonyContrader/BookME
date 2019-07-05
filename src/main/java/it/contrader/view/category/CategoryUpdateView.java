package it.contrader.view.category;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CategorieDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryUpdateView extends AbstractView{

	private String choice;
	private Request request;
	List<CategorieDTO> lista;
	
	@SuppressWarnings("unchecked")
	@Override
	public void showResults(Request request) {
		
		this.request = request;
		System.out.println("------------------- UPDATE VIEW ----------------\n");
		lista = (List<CategorieDTO>) request.get("categorie");
		for(CategorieDTO categoria : lista) {
			System.out.print("["+categoria.getId()+"] "+categoria.getNome_Categorie()+"\t");
		}
		
	}

	@Override
	public void showOptions() {
		System.out.print("\n[0~9] Update");
		System.out.println("\t[T]orna al menù");
		choice = getInput();
		
	}

	@Override
	public void submit() {
		if(choice.matches("\\d+")) {
			int categoryId = Integer.parseInt(choice);
			Request.getInstance().put("idToUpdate", categoryId);
			System.out.print("Modifica nome categoria: ");
			choice = getInput();
			Request.getInstance().put("nameToUpdate", choice);
		} else { request.remove("mode"); }
		MainDispatcher.getInstance().callAction("Category", "doControl", Request.getInstance());
		
		
	}

}
