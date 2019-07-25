package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.StoryDTO;
import it.contrader.model.Story;

@Component
public class StoryConverter extends AbstractConverter<Story, StoryDTO>{

	@Autowired
	private CategoryConverter categoryConverter;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private NovelConverter novelConverter;

	@Override
	public Story toEntity(StoryDTO dto) {
		Story story = null;
		if(dto != null) {
			story = new Story();
			story.setId(dto.getId());
			story.setTitle(dto.getTitle());
			story.setPlot(dto.getPlot());
			story.setCategory(categoryConverter.toEntity(dto.getCategory()));
			story.setUser(userConverter.toEntity(dto.getUser()));
			story.setPublished(dto.isPublished());
			story.setNovel(novelConverter.toEntity(dto.getNovel()));
			story.setLike(userConverter.toEntitySet(dto.getLike()));
			story.setBookmark(userConverter.toEntitySet(dto.getBookmark()));
		}
		return story;
	}

	@Override
	public StoryDTO toDTO(Story entity) {
		StoryDTO storyDTO = null;
		if(entity != null) {
			storyDTO = new StoryDTO();
			storyDTO.setId(entity.getId());
			storyDTO.setTitle(entity.getTitle());
			storyDTO.setPlot(entity.getPlot());
			storyDTO.setCategory(categoryConverter.toDTO(entity.getCategory()));
			storyDTO.setUser(userConverter.toDTO(entity.getUser()));
			storyDTO.setPublished(entity.isPublished());
			storyDTO.setNovel(novelConverter.toDTO(entity.getNovel()));
			storyDTO.setLike(userConverter.toDTOSet(entity.getLike()));
			storyDTO.setBookmark(userConverter.toDTOSet(entity.getBookmark()));
		}
		return storyDTO;
	}

}
