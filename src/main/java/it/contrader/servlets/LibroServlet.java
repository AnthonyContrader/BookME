package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.LibroDTO;
import it.contrader.service.LibroService;
import it.contrader.service.Service;

public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LibroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void updateList(HttpServletRequest request) {
		Service<LibroDTO> service = new LibroService();
		List<LibroDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<LibroDTO> service = new LibroService();
		String mode = request.getParameter("mode");
		LibroDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "LIBROLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/libro/libromanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);

			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/libro/readlibro.jsp").forward(request, response);

			}

			else
				getServletContext().getRequestDispatcher("/libro/updatelibro.jsp").forward(request, response);

			break;

		case "INSERT":
			String nomeLibro = request.getParameter("nomeLibro").toString();
			int id_Categoria = Integer.parseInt(request.getParameter("id_Categoria"));
			dto = new LibroDTO(nomeLibro, id_Categoria);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/libro/libromanager.jsp").forward(request, response);
			break;

		case "UPDATE":
			nomeLibro = request.getParameter("nomeLibro");
			id_Categoria = Integer.parseInt(request.getParameter("id_Categoria"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new LibroDTO(nomeLibro, id_Categoria);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/libro/libromanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/libro/libromanager.jsp").forward(request, response);
			break;
		}
	}
}