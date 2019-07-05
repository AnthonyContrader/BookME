package it.contrader.service;

import it.contrader.converter.StoryConverter;
import it.contrader.dao.StoryDAO;
import it.contrader.dto.StoryDTO;
import it.contrader.model.Story;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditariet� mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class StoryService extends AbstractService<Story, StoryDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public StoryService(){
		this.dao = new StoryDAO();
		this.converter = new StoryConverter();
	}
	
	public void insert(String trama) {
		StoryDTO storyDTO = new StoryDTO(trama);
		dao.insert(converter.toEntity(storyDTO));
	}
	
	public StoryDTO read(int id_storie) {
		
		return converter.toDTO(dao.read(id_storie));
	}
	
	public boolean update(StoryDTO story) {
		return dao.update(converter.toEntity(story));
	}
	

}
