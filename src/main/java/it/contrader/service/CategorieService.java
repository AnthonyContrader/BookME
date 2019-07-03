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
		List<Categorie> lista = dao.getAll();
		List<CategorieDTO> listaDTO = converter.toDTOList(lista);
		return listaDTO;
	}
}
