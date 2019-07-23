package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

@Component
public class CategoryConverter extends AbstractConverter<Category,CategoryDTO> {

	@Override
	public Category toEntity(CategoryDTO dto) {
		Category c = null;
		if(dto != null) {
			c = new Category();
			c.setId(dto.getId());
			c.setName(dto.getName());
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
		}
		return dto;
	}

}
