package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	public Category findCategoryByName(String name);
	public Category findCategoryByIdCategory(Integer idCategory);
	
}
