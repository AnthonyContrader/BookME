package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PersonaggiDTO;
import it.contrader.model.Personaggi;

public class PersonaggiConverter implements Converter<Personaggi, PersonaggiDTO> {

	
	public PersonaggiDTO toDTO(Personaggi personaggi) {
		PersonaggiDTO personaggiDTO = new PersonaggiDTO(personaggi.getId_Storie(), personaggi.getnome());
		return personaggiDTO;
	}


	public Personaggi toEntity(PersonaggiDTO personaggiDTO) {
		// TODO Auto-generated method stub
		Personaggi personaggi = new Personaggi(0, personaggiDTO.getNome());
		return personaggi;
	}


	public List<PersonaggiDTO> toDTOList(List<Personaggi> personaggiList) {
		// TODO Auto-generated method stub
		List<PersonaggiDTO> personaggiDTOList = new ArrayList<PersonaggiDTO>();
		for (Personaggi personaggi : personaggiList) {
			personaggiDTOList.add(toDTO(personaggi));
		}
		return personaggiDTOList;
	}

}
