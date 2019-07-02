package it.contrader.model;

public class Personaggi {
	
	private int id_Personaggio;
	
	private String nota;

	public int getId_Personaggio() {
		return id_Personaggio;
	}

	public void setId_Personaggio(int i) {
		this.id_Personaggio = i;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Personaggi(int id_Personaggi, String nota) {
		super();
		this.id_Personaggio = id_Personaggi;
		this.nota = nota;
	}

}
