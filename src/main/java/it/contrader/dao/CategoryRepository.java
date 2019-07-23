package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Category;

@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category,Long>{
	Category findCategoryById(long id);
	Category findCategoryByName(String name);
	List<Category> findAll();
}
