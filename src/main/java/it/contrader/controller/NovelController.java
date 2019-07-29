package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CategoryDTO;
import it.contrader.dto.NovelDTO;
import it.contrader.service.NovelService;

@RestController
@RequestMapping("/novel")
@CrossOrigin(origins = "http://localhost:4200")
public class NovelController extends AbstractController<NovelDTO>{
	
	@Autowired
	private NovelService service;

	@PostMapping(value = "getbycategory")
	public List<NovelDTO> getNovelsByCategory(@RequestBody CategoryDTO category){
		return service.getNovelsByCategory(category);
	}
}
