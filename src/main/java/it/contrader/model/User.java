package it.contrader.model;

import javax.persistence.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati come interi
 * a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	public enum Usertype {
		ADMIN,
		USER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String username;
	
	@NotNull
	private String password;

	@NotNull
	private Usertype usertype;
	
	@OneToMany(mappedBy = "user")
	private Set<Story> stories;
	
	@ManyToMany
	@JoinTable(
			  name = "story_like", 
			  joinColumns = @JoinColumn(name = "user_id"), 
			  inverseJoinColumns = @JoinColumn(name = "story_id")
			  )
	private Set<Story> likedStories;
	
	@ManyToMany
	@JoinTable(
			  name = "story_bookmark", 
			  joinColumns = @JoinColumn(name = "user_id"), 
			  inverseJoinColumns = @JoinColumn(name = "story_id")
			  )
	private Set<Story> bookmarkedStories;
	
	
	private Set<Novel> likedNovels;
	
	private Set<Novel> bookmarkedNovels;
	
}
