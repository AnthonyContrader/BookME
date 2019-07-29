package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.StoryDTO;
import it.contrader.model.Story;

@Component
public class StoryConverter extends AbstractConverter<Story,StoryDTO>{

	@Autowired
	private UserConverter userConverter;

	@Override
	public Story toEntity(StoryDTO dto) {
		Story story = null;
		if(dto != null) {
			story = new Story();
			story.setIdStory(dto.getIdStory());
			story.setTitle(dto.getTitle());
			story.setPlot(dto.getPlot());
			story.setUser(userConverter.toEntity(dto.getUser()));
//			story.setLike(userConverter.toEntityList(dto.getLike()));
		}
		return story;
	}

	@Override
	public StoryDTO toDTO(Story entity) {
		StoryDTO dto = null;
		if(entity != null) {
			dto = new StoryDTO();
			dto.setIdStory(entity.getIdStory());
			dto.setTitle(entity.getTitle());
			dto.setPlot(entity.getPlot());
			dto.setUser(userConverter.toDTO(entity.getUser()));
//			dto.setLike(userConverter.toDTOList(entity.getLike()));
		}
		return dto;
	}
	
	

}
