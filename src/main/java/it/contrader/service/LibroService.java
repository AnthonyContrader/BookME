package it.contrader.service;

import java.util.List;

import it.contrader.converter.LibroConverter;
import it.contrader.dao.LibroDAO;
import it.contrader.dto.LibroDTO;
import it.contrader.model.Libro;

public class LibroService extends AbstractService<Libro, LibroDTO>
{
	public LibroService()
	{
		this.converter = new LibroConverter();
		this.dao = new LibroDAO();
	}
	
	public List<LibroDTO> GetAll()
	{
		List<LibroDTO> list = converter.toDTOList(dao.getAll());
		return list;
	}
	
	public LibroDTO Read(int id)
	{
		Libro libro = dao.read(id);
		LibroDTO libroDTO = converter.toDTO(libro);
		return libroDTO;
	}
	
	
	
	
}
