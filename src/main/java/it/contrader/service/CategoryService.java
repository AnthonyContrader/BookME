package it.contrader.service;

import java.util.List;

import it.contrader.converter.CategoryConverter;
import it.contrader.dao.CategoryDAO;

import it.contrader.dto.CategoryDTO;

import it.contrader.model.Category;

public class CategoryService extends AbstractService<Category, CategoryDTO>
{
	public CategoryService()
	{
		this.dao = new CategoryDAO();
		this.converter = new CategoryConverter();
		
		
	}
	
	public List<CategoryDTO> GetAll()
	{
		List<CategoryDTO> list = converter.toDTOList(dao.getAll());
		return list;
		
	}
	
	public CategoryDTO Read(int id)
	{
		Category categoria = dao.read(id);
		CategoryDTO categoriaDTO = converter.toDTO(categoria);
		return categoriaDTO;
	}
	
}
