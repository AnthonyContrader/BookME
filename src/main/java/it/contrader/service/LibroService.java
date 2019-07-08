package it.contrader.service;

import java.util.List;

import it.contrader.converter.LibroConverter;
import it.contrader.dao.LibroDAO;
import it.contrader.dto.LibroDTO;
import it.contrader.model.Libro;

public class LibroService extends AbstractService<Libro, LibroDTO>{
	public LibroService() {
		this.dao = new LibroDAO(); 
		this.converter = new LibroConverter();
	}
	
	public LibroDTO read(int id) {
		return converter.toDTO(dao.read(id));
	}
	
	public List<LibroDTO> getAll(){
		return converter.toDTOList(dao.getAll());
	}
	
	public boolean insert(LibroDTO libro) {
		return dao.insert(converter.toEntity(libro));
	}
	
	public boolean update(LibroDTO libro) {
		return dao.update(converter.toEntity(libro));
	}
	
	public boolean delete(int id) {
		return dao.delete(id);
	}

	public LibroDTO getLibroByName(String nome_Libro) {
		List<Libro> lista = dao.getAll();
		for(Libro l : lista) {
			
			if(l.getNome_Libro().contains(nome_Libro)) {
				return converter.toDTO(l);
			}
		}
		return null;
	}
}
