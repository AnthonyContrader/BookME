package it.contrader.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class StoryDTO {

	private long id;
	
	private String title;
	
	private String plot;
	
	private boolean published;
	
	private CategoryDTO category;
	
	private UserDTO user;
	
	private Set<UserDTO> like;
	
	private Set<UserDTO> bookmark;
	
	private NovelDTO novel;
	
}
