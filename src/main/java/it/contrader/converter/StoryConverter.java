package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.StoryDTO;
import it.contrader.model.Story;

public class StoryConverter implements Converter<Story, StoryDTO>{

	
	public StoryDTO toDTO(Story story) {
		StoryDTO storyDTO = new StoryDTO(story.getTrama(), story.getId_Categoria(),story.getId_Storie());
		return storyDTO;
	}


	public Story toEntity(StoryDTO storyDTO) {
		// TODO Auto-generated method stub
		Story story = new Story(storyDTO.getTrama(),storyDTO.getId_Categoria(),storyDTO.getId_Storie());
		return story;
	}


	public List<StoryDTO> toDTOList(List<Story> storyList) {
		// TODO Auto-generated method stub
		List<StoryDTO> storyDTOList = new ArrayList<StoryDTO>();
		for(Story story: storyList) {
			storyDTOList.add(toDTO(story));
		}
		return storyDTOList;
	}
	

}
