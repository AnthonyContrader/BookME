package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Category;
import it.contrader.model.Story;
import it.contrader.model.User;

@Repository
@Transactional
public interface StoryRepository extends CrudRepository<Story, Long>{

	public List<Story> findByUser(User user);
	
	public List<Story> findAllByCategory(Category category);
	
}