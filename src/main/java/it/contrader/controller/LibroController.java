package it.contrader.controller;


import java.util.List;

import it.contrader.dto.CategorieDTO;
import it.contrader.dto.LibroDTO;
import it.contrader.dto.StoryDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.CategorieService;
import it.contrader.service.LibroService;
import it.contrader.service.StoryService;

public class LibroController implements Controller {

	private static String sub_package = "libro.";

	private LibroService libroService;
	private CategorieService categoryService;
	private StoryService storyService;
	Request request;

	public LibroController() {
		libroService = new LibroService();
		categoryService = new CategorieService();
		storyService = new StoryService();
	}

	@Override
	public void doControl(Request request) {

		this.request = request;
		if(request.get("mode")!= null) {
			switch(request.remove("mode").toString()) {
			case "READ":
				int idLibro = (int) request.remove("idLibro");
				LibroDTO libro = libroService.read(idLibro);
				request.put("libro", libro);
				MainDispatcher.getInstance().callView(sub_package + "LibroRead", request);
				break;
			
			}
		}
		LibroDTO libro, l;
		List<LibroDTO> libroList;
		List<CategorieDTO> categoryList = categoryService.GetCategoryList();
		for(CategorieDTO c : categoryList) {
			String nomeLibro = "Il bellissimo libro "+ c.getNome_Categorie();
			libro = new LibroDTO();
			libro.setId_Categoria(c.getId());
			libro.setNome_Libro(nomeLibro);
			
			
			List<StoryDTO> lista = 	storyService.getStoriesByCategoryId(c.getId());
			
			for(StoryDTO s : lista) {
				libro.addStoria(s.getTrama());
			}
			
			l=libroService.getLibroByName(nomeLibro);
			
			if(l == null) {
				libroService.insert(libro);
			} else {
				//libroService.update(libro);
			}
		
				
		}
		
		libroList = libroService.getAll();
		
		request.put("libri", libroList);
		MainDispatcher.getInstance().callView("Libro", Request.getInstance());
		
	}
}
