package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.CategoryRepository;
import it.contrader.dto.CategoryDTO;
import it.contrader.model.Category;

// ((CategoryRepository)repository)

@Service
public class CategoryService extends AbstractService<Category, CategoryDTO>{
	
	public List<CategoryDTO> findAll(){
		return converter.toDTOList(((CategoryRepository)repository).findAll());
	}

}
