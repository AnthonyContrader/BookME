package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.StoryDTO;
import it.contrader.service.Service;
import it.contrader.service.StoryService;

public class StoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public StoryServlet() {

	}

	public void updateList(HttpServletRequest request) {
		Service<StoryDTO> service = new StoryService();
		List<StoryDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<StoryDTO> service = new StoryService();
		String mode = request.getParameter("mode");
		StoryDTO dto;
		int id_Storie;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "STORYLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/story/storymanager.jsp").forward(request, response);
			break;

		case "READ":
			id_Storie = Integer.parseInt(request.getParameter("id_Storie"));
			dto = service.read(id_Storie);
			request.setAttribute("dto", dto);

			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/story/readstory.jsp").forward(request, response);

			}

			else
				getServletContext().getRequestDispatcher("/story/updatestory.jsp").forward(request, response);

			break;

		case "INSERT":
			String trama = request.getParameter("trama").toString();
			int id_Categoria = Integer.parseInt(request.getParameter("id_Categoria"));
			dto = new StoryDTO(trama, id_Categoria);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/story/storymanager.jsp").forward(request, response);
			break;

		case "UPDATE":
			trama = request.getParameter("trama");
			id_Categoria = Integer.parseInt(request.getParameter("id_Categoria"));
			id_Storie = Integer.parseInt(request.getParameter("id_Storie"));
			dto = new StoryDTO(trama, id_Categoria);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/story/storymanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id_Storie = Integer.parseInt(request.getParameter("id_Storie"));
			ans = service.delete(id_Storie);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/story/storymanager.jsp").forward(request, response);
			break;
		}
	}

}
