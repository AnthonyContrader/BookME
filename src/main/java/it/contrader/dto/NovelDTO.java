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
public class NovelDTO {
	
	private long id;
	
	private String title;
	
	private String plot;
	
	private CategoryDTO category;
	
	private Set<UserDTO> like;
	
	private Set<UserDTO> bookmark;
	
	private Set<StoryDTO> madeBy;
}
