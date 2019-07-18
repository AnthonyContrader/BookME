package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

public class ConverterCategory{

	public static CategoryDTO toDTO(Category category) {
		CategoryDTO categoryDTO = null;
		if (category != null) {
			categoryDTO = new CategoryDTO();
			categoryDTO.setIdCategory(category.getIdCategory());
			categoryDTO.setName(category.getName());
		}
		return categoryDTO;
	}

	public static Category toEntity(CategoryDTO categoryDTO) {
		Category category = null;
		if (categoryDTO != null) {
			category = new Category();
			category.setIdCategory(categoryDTO.getIdCategory());
			category.setName(categoryDTO.getName());
		}
		return category;
	}

	public static List<CategoryDTO> toListDTO(List<Category> list) {
		List<CategoryDTO> listCategoryDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Category category : list) {
				listCategoryDTO.add(ConverterCategory.toDTO(category));
			}
		}
		return listCategoryDTO;
	}

	public static List<Category> toListEntity(List<CategoryDTO> listCategoryDTO) {
		List<Category> list = new ArrayList<>();
		if (!listCategoryDTO.isEmpty()) {
			for (CategoryDTO categoryDTO : listCategoryDTO) {
				list.add(ConverterCategory.toEntity(categoryDTO));
			}
		}
		return list;
	}

}
