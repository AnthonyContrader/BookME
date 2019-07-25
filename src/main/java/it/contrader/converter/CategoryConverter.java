package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

@Component
public class CategoryConverter extends AbstractConverter<Category,CategoryDTO> {

	@Autowired
	private StoryConverter storyConverter;
	
	@Autowired
	private NovelConverter novelConverter;
	@Override
	public Category toEntity(CategoryDTO dto) {
		Category c = null;
		if(dto != null) {
			c = new Category();
			c.setId(dto.getId());
			c.setName(dto.getName());
			c.setStories(storyConverter.toEntitySet(dto.getStories()));
			c.setNovels(novelConverter.toEntitySet(dto.getNovels()));
		}
		return c;
	}

	@Override
	public CategoryDTO toDTO(Category entity) {
		CategoryDTO dto = null;
		if(entity != null) {
			dto = new CategoryDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setStories(storyConverter.toDTOSet(entity.getStories()));
			dto.setNovels(novelConverter.toDTOSet(entity.getNovels()));
		}
		return dto;
	}

}
