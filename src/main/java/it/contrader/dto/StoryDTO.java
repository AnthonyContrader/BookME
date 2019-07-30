package it.contrader.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idStory", scope= StoryDTO.class)
public class StoryDTO {
	
	private long idStory;
	
	private String title;
	
	private String plot;
	
	private boolean published;
	
	private UserDTO user;
	
	private CategoryDTO category;
	
	private NovelDTO novel;
	
//	private List<UserDTO> like;
	
	
}
