package it.contrader.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStory;
	
	private String title;
	
	private String plot;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Category category;
	

}

