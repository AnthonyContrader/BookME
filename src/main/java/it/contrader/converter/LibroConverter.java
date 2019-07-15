package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.LibroDTO;
import it.contrader.model.Libro;

public class LibroConverter implements Converter<Libro, LibroDTO>
{

	@Override
	public LibroDTO toDTO(Libro entity) {
		LibroDTO libro = new LibroDTO(entity.getNomeLibro(),entity.getId_Categoria(), entity.getId_Libro());
		return libro;
	}

	@Override
	public Libro toEntity(LibroDTO dto) {
		Libro libro = new Libro(dto.getNomeLibro(),dto.getId_Categoria(),dto.getId_Libro());
		return libro;
	}

	@Override
	public List<LibroDTO> toDTOList(List<Libro> entityList) {
		List<LibroDTO> libroDTO = new ArrayList<LibroDTO>();
		for(Libro libro : entityList)
		{
			libroDTO.add(toDTO(libro));
		}
		return libroDTO;
	}

	
	

}
