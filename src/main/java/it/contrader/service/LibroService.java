package it.contrader.service;

import it.contrader.converter.CategorieConverter;
import it.contrader.dao.LibroDAO;
import it.contrader.dto.LibroDTO;
import it.contrader.model.Libro;

public class LibroService extends AbstractService<Libro, LibroDTO>{
	public LibroService() {
		this.dao = new LibroDAO(); 
		this.converter = new LibroConverter();
	}
	
}
