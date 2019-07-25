package it.contrader.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Story {

	@Id
	@GeneratedValue
	private long id;			// PK NN AI
	
	@NotNull
	private String title;		// NN
	
	@NotNull
	private String plot;		// NN
	
	@NotNull
	private boolean published;	// NN
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;	// FK NN

	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull
	private User user;		// FK NN
	
	@ManyToMany( mappedBy = "likedStories" )
	private Set<User> like;
	
	@ManyToMany( mappedBy = "bookmarkedStories" )
	private Set<User> bookmark;
	
	@ManyToOne
	@JoinColumn(name = "novel_id")
	private Novel novel;
	
	
}
