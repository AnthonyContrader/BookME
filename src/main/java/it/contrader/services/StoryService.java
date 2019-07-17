package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.contrader.converter.ConverterStory;
import it.contrader.dao.StoryRepository;
import it.contrader.dto.StoryDTO;
import it.contrader.model.Story;

@Service
public class StoryService {
	
	private final StoryRepository storyRepository;
	
	@Autowired
	public StoryService(StoryRepository storyRepository) {
		this.storyRepository = storyRepository;
	}
	
	public List<StoryDTO> getListaStoryDTO() {
		return ConverterStory.toListDTO((List<Story>) storyRepository.findAll());
	}

	public StoryDTO getStoryDTOById(Integer id) {
		return ConverterStory.toDTO(storyRepository.findById(id).get());
	}

	public StoryDTO getByIdStory(Integer idStory) {

		final Story story = storyRepository.findStoryByIdStory(idStory);

		return ConverterStory.toDTO(story);
	}

	public boolean insertStory(StoryDTO storyDTO) {
		return storyRepository.save(ConverterStory.toEntity(storyDTO)) != null;
	}

	public boolean updateStory(StoryDTO storyDTO) {
		return storyRepository.save(ConverterStory.toEntity(storyDTO)) != null;
	}
	
	public void deleteStoryById(Integer id) {
		storyRepository.deleteById(id);
	}
	
	public List<StoryDTO> findStoryDTOByTitle(String title) {
		
		final List<Story> list = storyRepository.findAllByTitle(title);
		final List<StoryDTO> storyDTOs = new ArrayList<>();
		list.forEach(i -> storyDTOs.add(ConverterStory.toDTO(i)));
		return storyDTOs;
		
	
	}

}
