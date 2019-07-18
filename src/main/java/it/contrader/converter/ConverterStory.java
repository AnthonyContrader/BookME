package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.StoryDTO;
import it.contrader.model.Story;

public class ConverterStory {
	
	public static StoryDTO toDTO(Story story) {
		StoryDTO storyDTO = null;
		if (story != null) {
			storyDTO = new StoryDTO();
	        storyDTO.setIdStory(story.getIdStory());
	        storyDTO.setTitle(story.getTitle());
			storyDTO.setPlot(story.getPlot());
			storyDTO.setIdCategory(story.getIdCategory());
		}
		return storyDTO;
	}
	
	public static Story toEntity(StoryDTO storyDTO) {
		Story story = null;
		if (storyDTO != null) {
			story = new Story();
			story.setIdStory(storyDTO.getIdStory());
			story.setTitle(storyDTO.getTitle());
			story.setPlot(storyDTO.getPlot());
			story.setIdCategory(storyDTO.getIdCategory());
		}
		return story;
	}
	
	public static List<StoryDTO> toListDTO(List<Story> list) {
		List<StoryDTO> listStoryDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Story story : list) {
				listStoryDTO.add(ConverterStory.toDTO(story));
			}
		}
		return listStoryDTO;
	}

	public static List<Story> toListEntity(List<StoryDTO> listStoryDTO) {
		List<Story> list = new ArrayList<>();
		if (!listStoryDTO.isEmpty()) {
			for (StoryDTO storyDTO : listStoryDTO) {
				list.add(ConverterStory.toEntity(storyDTO));
			}
		}
		return list;
	}

}
