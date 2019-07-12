package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PersonaggiDTO;
import it.contrader.model.Personaggi;


public class PersonaggiConverter implements Converter<Story, StoryDTO> {

	@Override
	public PersonaggiDTO toDTO(Personaggi personaggi) {
		PersonaggiDTO personaggiDTO = new PersonaggiDTO(personaggi.getId_Personaggio(), personaggi.getnome(),personaggi.getId_Storie());
		return personaggiDTO;
	}

	@Override
	public Personaggi toEntityPersonaggiDTO personaggiDTO) {

		Personaggi personaggi = new Personaggi(personaggiDTO.getnome());
		return personaggi;
	}

	@Override
	public List<PersonaggiDTO> toDTOList(List<Personaggi> personaggiList) {
		// TODO Auto-generated method stub
		List<PersonaggiDTO> personaggiDTOList = new ArrayList<PersonaggiDTO>();
		for (Personaggi personaggi : personaggiList) {
			personaggiDTOList.add(toDTO(personaggi));
		}
		return personaggiDTOList;
	}

}
