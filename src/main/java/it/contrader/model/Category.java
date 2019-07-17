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
public class Category {
	
	@Id
	@Column(name = "idCategory")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategory;

	@Column(name = "name")
	@NotNull
	private String name;

}
