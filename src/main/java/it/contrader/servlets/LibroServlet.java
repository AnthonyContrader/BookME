package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.LibroDTO;

import it.contrader.service.LibroService;


public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LibroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	LibroService service = new LibroService();
    	String option = request.getAttribute("mode").toString();
    	int id_Libro;
    	
    	if(request != null)
    	{
    		switch(option.toUpperCase())
    		{
    			case "GETLIBROLIST" :
    			List<LibroDTO> listLibriDTO = service.GetAll();
    			request.setAttribute("libroyList", listLibriDTO);
	    		getServletContext().getRequestDispatcher("libro/libromanager.jsp").forward(request, response);
	    		break;
	    		
    			case "READ" : 
    			id_Libro = Integer.parseInt(request.getParameter("id_Libro"));
    			LibroDTO libro = service.Read(id_Libro);
    			request.setAttribute("dto", libro);
    			getServletContext().getRequestDispatcher("/libro/readlibro.jsp").forward(request, response);
    			
    			
    				
    		}
    	}
    	
    	
    }

}
