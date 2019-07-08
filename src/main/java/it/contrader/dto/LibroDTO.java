package it.contrader.dto;

public class LibroDTO {

	private int id_Libro;

	private String nome_Libro;

	private int id_Categoria;
	
	private String storia = null;

	public LibroDTO() {
		
	}

	public LibroDTO(String nome_Libro) {
		this.nome_Libro = nome_Libro;

	}

	public LibroDTO(int id_Libro, String nome_Libro, int id_Categoria, String storia) {
		this.id_Libro = id_Libro;
		this.nome_Libro = nome_Libro;
		this.id_Categoria = id_Categoria;
		this.storia = storia;

	}
	
	

	public int getId_Libro() {
		return id_Libro;
	}

	public void setId_Libro(int id_Libro) {
		this.id_Libro = id_Libro;
	}

	public String getNome_Libro() {
		return nome_Libro;
	}

	public void setNome_Libro(String nome_Libro) {
		this.nome_Libro = nome_Libro;
	}
	
	public void setStoria(String storia) {
		this.storia = storia;
	}

	public int getId_Categoria() {
		return id_Categoria;
	}

	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	}

	@Override
	public String toString() {
		return "LibroDTO [id_Libro=" + id_Libro + ", nome_Libro=" + nome_Libro + ", id_Categoria=" + id_Categoria + "]";
	}

	public String getStoria() {
		
		 return storia;
	}

	public void addStoria(String trama) {
		if(storia != null) {
			storia += ("\n" + trama);
		} else {
			storia = trama;
		}
		
	}

}