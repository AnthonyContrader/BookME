package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.CategoryDTO;
import it.contrader.service.CategoryService;

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

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	CategoryService service = new CategoryService();
    	String option = request.getAttribute("Option").toString();  // Scompone la richiesta e fa lo switch 
    	
    	
    	int numOfCategory = request.getIntHeader("Category");
    	CategoryDTO cat;
    	if(request != null)
    	{
    		
    	
    		switch(option.toUpperCase())
    		{
	    		case "READ" :
	    		cat = service.Read(numOfCategory);
	    		cat.getNomeCategoria();
	    		break;
	    		
	    		case "GETCATEGORYLIST" :
	    		List<CategoryDTO> categories = service.GetAll();
	    		break;
    		}
    	}
    }
    
	

}
