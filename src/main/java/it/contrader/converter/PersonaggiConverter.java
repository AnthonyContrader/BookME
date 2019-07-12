package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PersonaggiDTO;
import it.contrader.dto.StoryDTO;
import it.contrader.model.Personaggi;
import it.contrader.model.Story;

public class PersonaggiConverter implements Converter<Personaggi, PersonaggiDTO> {

	@Override
	public PersonaggiDTO toDTO(Personaggi personaggi) {
		PersonaggiDTO personaggiDTO = new PersonaggiDTO(personaggi.getId_Storie(), personaggi.getnome());
		return personaggiDTO;
	}

	@Override
	public Personaggi toEntity(PersonaggiDTO personaggiDTO) {
		// TODO Auto-generated method stub
		Personaggi personaggi = new Personaggi(0, personaggiDTO.getNome());
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
