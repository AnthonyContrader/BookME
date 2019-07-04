package it.contrader.service;

import java.util.List;

import it.contrader.converter.PersonaggiConverter;
import it.contrader.dao.PersonaggiDAO;
import it.contrader.dto.PersonaggiDTO;
import it.contrader.model.Personaggi;

	public class PersonaggiService extends AbstractService<Personaggi, PersonaggiDTO> {
		
		public PersonaggiService(){
			this.dao = new PersonaggiDAO();
			this.converter = new PersonaggiConverter();
		}
		
		public PersonaggiDTO readPersonaggio(int id) {
			return converter.toDTO(dao.read(id));
		}
		
		public List<PersonaggiDTO> getAllPersonaggi(){
			return converter.toDTOList(dao.getAll());
		}
		
		public boolean insertPersonaggio(PersonaggiDTO personaggio) { 
			return dao.insert(converter.toEntity(personaggio));
		}
		
		public boolean deletePersonaggio(PersonaggiDTO personaggio) { 
			return dao.delete(converter.toEntity(personaggio).getId_Personaggio()); 
		}
		
		public boolean deletePersonaggio(int id) { 
			return dao.delete(id); 
		}
		
		public boolean updatePersonaggio(PersonaggiDTO personaggio) {
			return dao.update(converter.toEntity(personaggio));
		}
		
		
	}