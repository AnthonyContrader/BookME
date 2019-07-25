package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.StoryDTO;
import it.contrader.service.StoryService;

@RestController
@RequestMapping("/story")
@CrossOrigin(origins = "http://localhost:4200")
public class StoryController extends AbstractController<StoryDTO>{

	@Autowired
	private StoryService storyService;
}
