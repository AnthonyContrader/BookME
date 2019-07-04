package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.StoryDTO;
import it.contrader.model.Story;

public class StoryConverter implements Converter<Story,StoryDTO>{

	@Override
	public StoryDTO toDTO(Story story) {
		StoryDTO storyDTO = new StoryDTO(story.getId_storie(), story.getTrama());
		return storyDTO;
	}

	@Override
	public Story toEntity(StoryDTO storyDTO) {
		Story story = new Story(storyDTO.getId_story(),storyDTO.getTrama());
		return story;
	}

	@Override
	public List<StoryDTO> toDTOList(List<Story> storyList) {
		
		List<StoryDTO> storyDTOList = new ArrayList<StoryDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Story story : storyList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			storyDTOList.add(toDTO(story));
		}
		return storyDTOList;
	}

}
