package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PersonaggiDTO;
import it.contrader.dto.PersonaggiDTO;
import it.contrader.model.Personaggi;
import it.contrader.model.Personaggi;

public class PersonaggiConverter  implements Converter<Personaggi, PersonaggiDTO> {
	

	@Override
	public PersonaggiDTO toDTO(Personaggi Personaggi) {
		PersonaggiDTO PersonaggiDTO = new PersonaggiDTO(Personaggi.getId_Personaggio(), Personaggi.getNota());
		return PersonaggiDTO;
	}


	@Override
	public Personaggi toEntity(PersonaggiDTO PersonaggiDTO) {
		Personaggi Personaggi = new Personaggi(PersonaggiDTO.getId_Personaggio(), PersonaggiDTO.getNota());
		return Personaggi;
	}

	@Override
	public List<PersonaggiDTO> toDTOList(List<Personaggi> PersonaggiList) {

		List<PersonaggiDTO> PersonaggiDTOList = new ArrayList<PersonaggiDTO>();
		

		for(Personaggi Personaggi : PersonaggiList) {
 
			PersonaggiDTOList.add(toDTO(Personaggi));
		}
		return PersonaggiDTOList;
	}

	
	
}
