package it.contrader.dto;

public class PersonaggiDTO {
	
	
	private int id_Personaggio;
	
	private String nome;
	
	private int id_Storia;

	public PersonaggiDTO(int id_Personaggio2, String nota2) {
		// TODO Auto-generated constructor stub
	}

	public int getId_Personaggio() {
		return id_Personaggio;
	}

	public void setId_Personaggio(int id_Personaggio) {
		this.id_Personaggio = id_Personaggio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nota) {
		this.nome = nota;
	}

	@Override
	public String toString() {
		return "PersonaggiDTO [id_Personaggio=" + id_Personaggio + ", nome=" + nome + "]";
	}

	public int getId_Storia() {
		return id_Storia;
	}

	public void setId_Storia(int id_Storia) {
		this.id_Storia = id_Storia;
	}

}
