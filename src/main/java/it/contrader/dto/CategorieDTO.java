package it.contrader.dto;

public class CategorieDTO
{
	private String nome_Categorie;
	private int id;
	
	
	/**
	 * @param nome_Categorie
	 * @param id
	 */
	public CategorieDTO(String nome_Categorie, int id) {
		super();
		this.nome_Categorie = nome_Categorie;
		this.id = id;
	}
	
	public CategorieDTO(String newCategoryName) {
		this.nome_Categorie = newCategoryName;
	}
	public String getNome_Categorie() {
		return nome_Categorie;
	}
	public void setNome_Categorie(String nome_Categorie) {
		this.nome_Categorie = nome_Categorie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome_Categorie;
	}
}
