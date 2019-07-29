package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CategoryConverter;
import it.contrader.dao.NovelRepository;
import it.contrader.dto.CategoryDTO;
import it.contrader.dto.NovelDTO;
import it.contrader.model.Novel;

@Service
public class NovelService extends AbstractService<Novel,NovelDTO>{

	@Autowired
	CategoryConverter catconv;
	
	public List<NovelDTO> getNovelsByCategory(CategoryDTO category){
		return converter.toDTOList(((NovelRepository)repository).findAllByCategory(catconv.toEntity(category)));
	}
}