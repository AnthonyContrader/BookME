package it.contrader.controller;

import java.util.List;

import it.contrader.dto.LibroDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.LibroService;

public class LibroController implements Controller {

	private static String sub_package = "libro.";

	private LibroService libroService;
	Request request;

	public LibroController() {
		libroService = new LibroService();
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
		List<LibroDTO> libroList = libroService.getAll();
		request.put("libri", libroList);
		MainDispatcher.getInstance().callView("Libro", Request.getInstance());
		
	}
}
