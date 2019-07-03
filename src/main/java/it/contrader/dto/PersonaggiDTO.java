package it.contrader.dto;

public class PersonaggiDTO {
	
	
	private int id_Personaggio;
	
	private String nota;

	public PersonaggiDTO(int id_Personaggio2, String nota2) {
		// TODO Auto-generated constructor stub
	}

	public int getId_Personaggio() {
		return id_Personaggio;
	}

	public void setId_Personaggio(int id_Personaggio) {
		this.id_Personaggio = id_Personaggio;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "PersonaggiDTO [id_Personaggio=" + id_Personaggio + ", nota=" + nota + "]";
	}

}
