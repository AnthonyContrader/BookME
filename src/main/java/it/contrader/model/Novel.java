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
public class Novel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idNovel;
	
	private String title;
	
	private String plot;
	
	@ManyToOne
	private Category category;
	

}
