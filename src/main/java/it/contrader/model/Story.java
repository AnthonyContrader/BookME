package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Story {
	
	@Id
	@Column(name = "idStory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStory;
	
	@Column(name = "title")
	@NotNull
	private String title; 
	
	@Column(name = "plot")
	@NotNull
	private String plot;
	
	@Column(name = "idCategory")
	@NotNull
	private Integer idCategory;

}
