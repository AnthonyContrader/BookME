package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.*;
import it.contrader.model.*;

public class CategorieConverter implements Converter<Categorie, CategorieDTO>{

	public CategorieConverter()
	{
	
	}

	@Override
	public CategorieDTO toDTO(Categorie entity) {
		CategorieDTO dto = new CategorieDTO(entity.getNome_Categorie(), entity.getId());
		return dto;
	}

	@Override
	public Categorie toEntity(CategorieDTO dto) {
		Categorie categorie = new Categorie(dto.getId(), dto.getNome_Categorie());
		return categorie;
	}

	@Override
	public List<CategorieDTO> toDTOList(List<Categorie> entityList) {
		List<CategorieDTO> CategorieDTOList = new ArrayList<CategorieDTO>();
		

			for(Categorie categorie : entityList) {
 
				CategorieDTOList.add(toDTO(categorie));
		}
		return CategorieDTOList;
	}
}
