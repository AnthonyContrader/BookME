package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterCategory;
import it.contrader.dao.CategoryRepository;
import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<CategoryDTO> getListaCategoryDTO() {
		return ConverterCategory.toListDTO((List<Category>) categoryRepository.findAll());
	}

	public CategoryDTO getCategoryDTOByIdCategory(Integer id) {
		return ConverterCategory.toDTO(categoryRepository.findCategoryByIdCategory(id));//.findById(id).get());
	}


	public boolean insertCategory(CategoryDTO categoryDTO) {
		return categoryRepository.save(ConverterCategory.toEntity(categoryDTO)) != null;
	}

	public boolean updateCategory(CategoryDTO categoryDTO) {
		return categoryRepository.save(ConverterCategory.toEntity(categoryDTO)) != null;
	}
	
	public void deleteCategoryById(Integer id) {
		categoryRepository.deleteById(id);
	}
	
}
