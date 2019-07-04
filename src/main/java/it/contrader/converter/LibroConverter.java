package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.LibroDTO;
import it.contrader.model.Libro;


public class LibroConverter  implements Converter<Libro, LibroDTO> {
	
	
	@Override
	public LibroDTO toDTO(Libro libro) {
		LibroDTO libroDTO = new LibroDTO(libro.getId_Libro(), libro.getNome_Libro(), libro.getId_Categoria()); 
		return libroDTO;
	}

	
	@Override
	public Libro toEntity(LibroDTO libroDTO) {
		Libro libro = new Libro(libro.getId_Libro(), libro.getNome_Libro(), libro.getId_Categoria());
		return libro;
	}
	
	/**
	 * Metodo per convertire le liste di Libro.
	 */
	@Override
	public List<LibroDTO> toDTOList(List<Libro> liboList) {
		//Crea una lista vuota.
		List<LibroDTO> libroDTOList = new ArrayList<LibroDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Libro libro : libroList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			libroDTOList.add(toDTO(libro));
		}
		return libroDTOList;
	}

	
	
}
