package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Story;

@Repository
@Transactional
public interface StoryRepository extends CrudRepository<Story, Long>{

	
}
