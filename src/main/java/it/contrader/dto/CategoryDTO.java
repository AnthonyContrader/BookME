package it.contrader.dto;

public class CategoryDTO
{
	private int id;
	private String nomeCategoria;
	
	
	
	/**
	 * @param nomeCategoria
	 */
	public CategoryDTO(String nomeCategoria) {
		super();
		this.nomeCategoria = nomeCategoria;
	}
	/**
	 * @param id
	 * @param nomeCategoria
	 */
	public CategoryDTO(int id, String nomeCategoria) {
		super();
		this.id = id;
		this.nomeCategoria = nomeCategoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	
}
