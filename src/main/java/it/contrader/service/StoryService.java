package it.contrader.service;

import it.contrader.converter.StoryConverter;
import it.contrader.dao.StoryDAO;
import it.contrader.dto.StoryDTO;
import it.contrader.model.Story;

public class StoryService extends AbstractService<Story,StoryDTO>{

	//Istanzio DAO  e Converter specifici.
		public StoryService(){
			this.dao = new StoryDAO();
			this.converter = new StoryConverter();
		}
}
