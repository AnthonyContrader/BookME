package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.LibroDTO;
import it.contrader.service.CategoryService;
import it.contrader.service.LibroService;
import it.contrader.service.Service;

/**
 * Servlet implementation class CategoryServlett
 */
public class CategoryServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlett() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void updateList(HttpServletRequest request) {
		Service<CategoryDTO> service = new CategoryService();
		List<CategoryDTO> categoryDTO = service.getAll();
		request.setAttribute("list", categoryDTO);
    }
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	CategoryService service = new CategoryService();
    	String option = request.getAttribute("Option").toString();  // Scompone la richiesta e fa lo switch 
    	
    	boolean ans;
    	int numOfCategory = request.getIntHeader("Category");
    	CategoryDTO cat = new CategoryDTO();
    	
    	if(request != null)
    	{
    		
    	
    		switch(option.toUpperCase())
    		{
	    		case "READ" :
	    		cat = service.Read(numOfCategory);
	    		cat.getNomeCategoria();
	    		cat.getId();
	    		getServletContext().getRequestDispatcher("/storyRead.jsp").forward(request, response);
	    		break;

	    		case "GETCATEGORYLIST" :
	    		List<CategoryDTO> categories = service.GetAll();
	    		break;
	    		
	    		case "DELETE":
	    			
	    			ans = service.delete(numOfCategory);
	    			request.setAttribute("ans", ans);
	    			updateList(request);
	    			getServletContext().getRequestDispatcher("/category/categorymanager.jsp").forward(request, response);
	    			break;
    		}
    	}
    }
    
	

}
