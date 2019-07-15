package it.contrader.dto;

public class LibroDTO
{
	private String nomeLibro;
	private int id_Libro;
	private int id_Categoria;
	
	
	
	
	
	/**
	 * @param nomeLibro
	 */
	public LibroDTO(String nomeLibro) {
		super();
		this.nomeLibro = nomeLibro;
	}
	/**
	 * 
	 */
	public LibroDTO() {
		super();
	}
	/**
	 * @param nomeLibro
	 * @param id_Libro
	 * @param id_Categoria
	 */
	public LibroDTO(String nomeLibro, int id_Categoria) {
		super();
		this.nomeLibro = nomeLibro;

		this.id_Categoria = id_Categoria;
	}
	public String getNomeLibro() {
		return nomeLibro;
	}
	public void setNomeLibro(String nomeLibro) {
		this.nomeLibro = nomeLibro;
	}
	public int getId_Libro() {
		return id_Libro;
	}
	public void setId_Libro(int id_Libro) {
		this.id_Libro = id_Libro;
	}
	public int getId_Categoria() {
		return id_Categoria;
	}
	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	}
}
