package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
	public Iterable<Category> findAll();
	public Category findCategoryByName(String name);
	public Category findCategoryByIdCategory(Integer idCategory);
	public void delete(Category category);
	public void deleteByIdCategory(Integer idCategory);
	public boolean existsByIdCategory(Integer idCategory);
	
}
