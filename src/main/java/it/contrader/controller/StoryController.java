package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.StoryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.StoryService;

@RestController
@RequestMapping("/story")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
public class StoryController extends AbstractController<StoryDTO>{
	
	@Autowired
	private StoryService storyService;
	
	@PostMapping(value = "getbyuser")
	public List<StoryDTO> getStoriesByUserId(@RequestBody UserDTO user){
		return storyService.getStoriesByUser(user);
	}
}
