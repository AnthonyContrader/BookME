package it.contrader.model;

public class Libro {

	private int id_Libro;

	private String nome_Libro;

	private int id_Categoria;

	public Libro(int id_Libro, String nome_Libro, int id_Categoria) {
		this.id_Libro = id_Libro;
		this.nome_Libro = nome_Libro;
	//	this.id_Categoria = id_Categoria;
	}

	public Libro(String nome_Libro2, String id_Categoria2) {
		// TODO Auto-generated constructor stub
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

	public int getId_Categoria() {
		return id_Categoria;
	}

	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	}

	@Override
	public String toString() {
		return "Libro [id_Libro=" + id_Libro + ", nome_Libro=" + nome_Libro +  "]";
	}

}
