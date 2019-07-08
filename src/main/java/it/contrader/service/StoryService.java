package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public void insert(String trama, int idCategoria) {
		StoryDTO storyDTO = new StoryDTO(trama, idCategoria);
		dao.insert(converter.toEntity(storyDTO));
	}
	
	public StoryDTO read(int id_storie) {
		
		return converter.toDTO(dao.read(id_storie));
	}
	
	public boolean update(StoryDTO story) {
		return dao.update(converter.toEntity(story));
	}

	public List<StoryDTO> getStoryByCategoryId(int categoryId)
	{
		
		List<StoryDTO> listDTO = new ArrayList<>();
		List<Story> list = dao.getAll();
		for(Story t : list)
		{
			
			if(categoryId == t.getId_Categoria())
			{
				listDTO.add(converter.toDTO(t));
			}
		}
		
		return listDTO;
		
	}
	
	public List<StoryDTO> getStoriesByCategoryId(int id){
		List<StoryDTO> lista = new ArrayList<>();
		List<Story> storyList = dao.getAll();
		for(Story s : storyList) {
			if(s.getId_Categoria() == id) {
				StoryDTO storia = converter.toDTO(s);
				lista.add(storia);
			}
		}
		
		return lista;
	}
	

}
