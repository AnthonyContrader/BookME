package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.NovelDTO;
import it.contrader.model.Novel;

@Component
public class NovelConverter extends AbstractConverter<Novel,NovelDTO>{

	@Autowired
	private CategoryConverter categoryConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private StoryConverter storyConverter;
	
	@Override
	public Novel toEntity(NovelDTO dto) {
		Novel novel = null;
		if(dto != null) {
			novel = new Novel();
			novel.setId(dto.getId());
			novel.setTitle(dto.getTitle());
			novel.setPlot(dto.getPlot());
			novel.setCategory(categoryConverter.toEntity(dto.getCategory()));
			novel.setLike(userConverter.toEntitySet(dto.getLike()));
			novel.setBookmark(userConverter.toEntitySet(dto.getBookmark()));
			novel.setMadeBy(storyConverter.toEntitySet(dto.getMadeBy()));
		}
		return novel;
	}

	@Override
	public NovelDTO toDTO(Novel entity) {
		NovelDTO novelDTO = null;
		if(entity != null) {
			novelDTO = new NovelDTO();
			novelDTO.setId(entity.getId());
			novelDTO.setTitle(entity.getTitle());
			novelDTO.setPlot(entity.getPlot());
			novelDTO.setCategory(categoryConverter.toDTO(entity.getCategory()));
			novelDTO.setLike(userConverter.toDTOSet(entity.getLike()));
			novelDTO.setBookmark(userConverter.toDTOSet(entity.getBookmark()));
			novelDTO.setMadeBy(storyConverter.toDTOSet(entity.getMadeBy()));
		}
		return novelDTO;
	}

}
