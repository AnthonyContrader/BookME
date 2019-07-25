package it.contrader.model;

import java.util.Set;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Novel {
	
	private long id;			// PK NN AI
	
	private String title;		// NN
	
	private String plot;		// NN

	private Category category;	// MAny to One
	
	private Set<User> like;
	
	private Set<User> bookmark;
}
