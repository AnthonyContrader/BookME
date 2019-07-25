package it.contrader.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Novel {
	
	@Id
	@GeneratedValue
	private long id;			// PK NN AI
	
	@NotNull
	private String title;		// NN
	
	@NotNull
	private String plot;		// NN

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;	// MAny to One
	
	@ManyToMany( mappedBy = "likedNovels" )
	private Set<User> like;
	
	@ManyToMany( mappedBy = "bookmarkedStories" )
	private Set<User> bookmark;
	
	@OneToMany(mappedBy = "novel")
	private Set<Story> madeBy;
}
