package it.contrader.service;

import it.contrader.converter.PersonaggiConverter;
import it.contrader.dao.PersonaggiDAO;
import it.contrader.dto.PersonaggiDTO;
import it.contrader.model.Personaggi;



	

	public class PersonaggiService extends AbstractService<Personaggi, PersonaggiDTO> {
		
		public PersonaggiService(){
			this.dao = new PersonaggiDAO();
			this.converter = new PersonaggiConverter();
		}
		

	}

	
	
	
	

