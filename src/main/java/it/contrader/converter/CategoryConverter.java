package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

public class CategoryConverter implements Converter<Category, CategoryDTO>
{

	public CategoryDTO toDTO(Category c) {
		CategoryDTO category = new CategoryDTO(c.getId(), c.getNomeCategoria());
		return category; 
	}

	public Category toEntity(CategoryDTO dto) {
		Category category = new Category(dto.getId(), dto.getNomeCategoria());
		return category;
	}

	public List<CategoryDTO> toDTOList(List<Category> categoryList) {
		 List<CategoryDTO> categoryList1 = new ArrayList<CategoryDTO>();
		 for(Category category : categoryList)
		 {
			 categoryList1.add(toDTO(category));
		 }
		 return categoryList1;
	}

}
