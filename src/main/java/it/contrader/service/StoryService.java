package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CategoryConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.StoryRepository;
import it.contrader.dto.CategoryDTO;
import it.contrader.dto.StoryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Story;

@Service
public class StoryService extends AbstractService<Story, StoryDTO>{

	@Autowired
	UserConverter c;
	
	@Autowired
	CategoryConverter catconv;
	
	public List<StoryDTO> getStoriesByUser(UserDTO user){
		return converter.toDTOList(((StoryRepository)repository).findByUser(c.toEntity(user)));
	}
	
	public List<StoryDTO> getStoriesByCategory(CategoryDTO category){
		return converter.toDTOList(((StoryRepository)repository).findAllByCategory(catconv.toEntity(category)));
	}
}