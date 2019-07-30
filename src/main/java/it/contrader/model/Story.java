package it.contrader.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private boolean published;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private Novel novel;
	

}

