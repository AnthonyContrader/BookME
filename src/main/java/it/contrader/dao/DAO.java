package it.contrader.dao;

import java.util.List;

import it.contrader.dto.StoryDTO;

public interface DAO<DTO> {

	public List<DTO> getAll();
	
	public DTO read(int id);
	
	public boolean insert(DTO dto);
	
	public boolean update(DTO storyDTO);
	
	public boolean delete(int id);
}
