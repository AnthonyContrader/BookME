package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.StoryDTO;
import it.contrader.services.StoryService;

@Controller
@RequestMapping("/Story")
public class StoryController {

	private final StoryService storyService;
	private HttpSession session;
	
	@Autowired
	public StoryController(StoryService storyService) {
		this.storyService = storyService;
	}
	
	private void visualStory(HttpServletRequest request){
		List<StoryDTO> allStory = this.storyService.getListaStoryDTO();
		request.setAttribute("allStoryDTO", allStory);
	}
	
	@RequestMapping(value = "/viewStory", method = RequestMethod.GET)
	public String storyManagement(HttpServletRequest request) {
		visualStory(request);
		return "story/homestory";		
	}
	
	@RequestMapping(value = "/deleteStory", method = RequestMethod.GET)
	public String deleteStory(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.storyService.deleteStoryById(id);
		visualStory(request);
		return "story/homestory";
	}
	
	@RequestMapping(value = "/updateStory" , method = RequestMethod.GET)
	public String updateStory(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		final String title = request.getParameter("title");
		final String plot = request.getParameter("plot");
		int idCategory = Integer.parseInt(request.getParameter("idCategory"));
		
		StoryDTO storyDTO = new StoryDTO(id,title,plot,idCategory);
		boolean result = this.storyService.updateStory(storyDTO);
		
		if(result) {
			request.setAttribute("result", "updated");
		}
		
		return "story/homestory";
	}
	
	@RequestMapping(value = "/readStory", method = RequestMethod.GET)
	public String readStory(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		//request.setAttribute("id", id);
		StoryDTO storyDTO = this.storyService.getStoryDTOById(id);
		request.setAttribute("readStory", storyDTO);
		
		return "story/homestory";
		
	}
	
	/*
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualStory(request);
		request.setAttribute("option", "insert");
		return "creaStory";
		
	}*/
	
	@RequestMapping(value = "/searchStory", method = RequestMethod.GET)
	public String searchStory(HttpServletRequest request) {

		final String content = request.getParameter("search");
		
		List<StoryDTO> allStory = this.storyService.findStoryDTOByTitle(content);
		request.setAttribute("allStoryDTO", allStory);

		return "story/homestory";

	}
	
	
	@RequestMapping(value = "/insertStory", method = RequestMethod.POST)
	public String insertStory(HttpServletRequest request) {
		String title = request.getParameter("title").toString();
		String plot = request.getParameter("plot").toString();
		//int idCategory = Integer.parseInt(request.getParameter("idCategory"));

		StoryDTO storyObj = new StoryDTO(0,title,plot,1);
		
		storyService.insertStory(storyObj);

		visualStory(request);
		return "story/homestory";
	}
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String ruolo = userDTO.getRuolo();
		if (!StringUtils.isEmpty(ruolo)) {
			session.setAttribute("utenteCollegato", userDTO);
			if (ruolo.equals("ADMIN")) {
				return "home";
			} else if (ruolo.equals("CHATMASTER")) {
				return "home";
			}
		}
		return "home";
	}
	*/
}
