package it.contrader.model;

public class Category
{
	private int id;
	private String nomeCategoria;
	
	
	
	/**
	 * @param nomeCategoria
	 */
	public Category(String nomeCategoria) {
		super();
		this.nomeCategoria = nomeCategoria;
	}
	/**
	 * @param id
	 * @param nomeCategoria
	 */
	public Category(int id, String nomeCategoria) {
		super();
		this.id = id;
		this.nomeCategoria = nomeCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
