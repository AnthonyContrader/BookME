package it.contrader.view.category;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.CategorieDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryDeleteView extends AbstractView{

	private String choice;
	private Request request;
	List<CategorieDTO> lista;
	
	@SuppressWarnings("unchecked")
	@Override
	public void showResults(Request request) {
		
		this.request = request;
		System.out.println("------------------- DELETE VIEW ----------------\n");
		lista = (List<CategorieDTO>) request.get("categorie");
		for(CategorieDTO categoria : lista) {
			System.out.print("["+categoria.getId()+"] "+categoria.getNome_Categorie()+"\t");
		}
		
	}

	@Override
	public void showOptions() {
		System.out.print("\n[0~9] Elimina");
		System.out.println("\t[T]orna al menù");
		choice = getInput();
	}

	@Override
	public void submit() {
		if(choice.matches("\\d+")) {
			int categoryId = Integer.parseInt(choice);
			Request.getInstance().put("idToDelete", categoryId);
		} else { request.remove("mode"); }

		MainDispatcher.getInstance().callAction("Category", "doControl", request);
		
		
	}

}
