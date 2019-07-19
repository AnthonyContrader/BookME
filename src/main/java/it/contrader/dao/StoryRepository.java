package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Story;

import java.util.List;

public interface StoryRepository extends CrudRepository<Story, Integer>{
   
	public Story findStoryByIdStory(Integer idStory);
	public List<Story> findAllByTitle(String title);
	public List<Story> findAllByIdCategory(Integer idCategory);
}
