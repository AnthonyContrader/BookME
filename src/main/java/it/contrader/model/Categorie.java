package it.contrader.model;

public class Categorie
{
	private int id;
	private String nome_Categorie;
	
	
	/**
	 * @param id
	 * @param nome_Categorie
	 */
	public Categorie(int id, String nome_Categorie) {
		super();
		this.id = id;
		this.nome_Categorie = nome_Categorie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_Categorie() {
		return nome_Categorie;
	}
	public void setNome_Categorie(String nome_Categorie) {
		this.nome_Categorie = nome_Categorie;
	}
	

}
