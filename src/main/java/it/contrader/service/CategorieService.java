package it.contrader.service;


import it.contrader.model.Categorie;

import it.contrader.dto.*;

import java.util.List;

import it.contrader.converter.*;
import it.contrader.dao.CategorieDAO;

public class CategorieService extends AbstractService<Categorie, CategorieDTO>
{
	public CategorieService()
	{
		this.dao = new CategorieDAO(); 
		this.converter = new CategorieConverter();
	}
	
	public List<CategorieDTO> GetCategoryList()
	{
		List<Categorie> lista = dao.getAll(); // richiama la lista dal DAO
		List<CategorieDTO> listaDTO = converter.toDTOList(lista); // Converte in lista Categoriedto
		return listaDTO; // Ritorna la lista
	}
	
	public String getCategoryName(int id) {
		Categorie categoria = dao.read(id);
		CategorieDTO categoriaDTO = converter.toDTO(categoria);
		return categoriaDTO.getNome_Categorie();
	}
	
	public boolean insert(CategorieDTO newCategory) {
		return dao.insert(converter.toEntity(newCategory));
	}
	
	public boolean delete(int id) {
		return dao.delete(id);
	}
	
	public boolean update(CategorieDTO category) {
		return dao.update(converter.toEntity(category));
		
	}

}
