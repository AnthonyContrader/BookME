package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Category;
import it.contrader.model.Novel;

@Repository
@Transactional
public interface NovelRepository extends CrudRepository<Novel,Long>{
		
	public List<Novel> findAllByCategory(Category category);
	
}
