package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.PersonaggiDTO;
import it.contrader.service.PersonaggiService;
import it.contrader.service.Service;

public class PersonaggiServlet extends HttpServlet {

	public PersonaggiServlet() {

	}

	public void updateList(HttpServletRequest request) {
		Service<PersonaggiDTO> service = new PersonaggiService();
		List<PersonaggiDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<PersonaggiDTO> service = new PersonaggiService();
		String mode = request.getParameter("mode");
		PersonaggiDTO dto;
		int id_Personaggio;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "PERSONAGGILIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/personaggi/personaggimanager.jsp").forward(request, response);
			break;

			
		case "READ":
			id_Personaggio = Integer.parseInt(request.getParameter("id_Personaggio"));
			dto = service.read(id_Personaggio);
			request.setAttribute("dto", dto);

			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/personaggi/readpersonaggi.jsp").forward(request, response);

			}

			else
				getServletContext().getRequestDispatcher("/personaggi/updatepersonaggi.jsp").forward(request, response);

			break;

		case "INSERT":
			String nome = request.getParameter("nome").toString();
			int id_Storie = Integer.parseInt(request.getParameter("id_Personaggio"));
			dto = new PersonaggiDTO (id_Storie, nome);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/personaggi/personaggimanager.jsp").forward(request, response);
			break;

		case "UPDATE":
			nome = request.getParameter("nome");
			id_Storie = Integer.parseInt(request.getParameter("id_Categoria"));
			id_Personaggio = Integer.parseInt(request.getParameter("id_Personaggio"));
			dto = new PersonaggiDTO(id_Storie, nome);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/story/storymanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id_Personaggio = Integer.parseInt(request.getParameter("id_Personaggio"));
			ans = service.delete(id_Personaggio);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/personaggio/personaggiomanager.jsp").forward(request, response);
			break;
		}
	}

}
