package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.NovelDTO;
import it.contrader.service.NovelService;

@RestController
@RequestMapping("/novel")
@CrossOrigin(origins = "http://localhost:4200")
public class NovelController extends AbstractController<NovelDTO>{

	@Autowired
	private NovelService novelService;
}
