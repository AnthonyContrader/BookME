package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoryDTO {
	
	private Integer idStory;
	
	private String title;

	private String plot;
	
	private Integer idCategory;

}
