package it.contrader.model;


public class Personaggi {
	
	private int id_Personaggio;
	
	private String nome;

	private int id_Storie;

	public int getId_Personaggio() {
		return id_Personaggio;
	}

	public void setId_Personaggio(int i) {
		this.id_Personaggio = i;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public Personaggi(int id_Personaggi, String nome) {
		super();
		this.id_Personaggio = id_Personaggi;
		this.nome = nome;
	}

	public int getId_Storie() {
		return id_Storie;
	}

	public void setId_Storie(int id_Storie) {
		this.id_Storie = id_Storie;
	}

}
