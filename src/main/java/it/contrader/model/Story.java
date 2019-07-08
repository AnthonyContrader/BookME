package it.contrader.model;

public class Story{
	
	private int id_storie ; 
	private String trama ;
	private int id_Categoria;
	
	public Story() {
		
	}
	
	public Story(int id_storie, String trama, int idCategoria) {
		this.id_storie = id_storie ;
		this.trama = trama ; 
		this.id_Categoria = idCategoria;
	}
	
	public Story(String trama, int idCategoria) {
		this.trama = trama ;
		this.id_Categoria = idCategoria;
	}


	public int getId_storie() {
		return id_storie;
	}

	public void setId_storie(int id_storie) {
		this.id_storie = id_storie;
	}

	public String getTrama() {
		return trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	@Override
	public String toString() {
		return "storie [id_storie=" + id_storie + ", trama=" + trama + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Story other = (Story) obj;
		if (id_storie != other.id_storie)
			return false;
		if (trama == null) {
			if (other.trama != null)
				return false;
		} else if (!trama.equals(other.trama))
			return false;
		return true;
	}


	public int getId_Categoria() {
		return id_Categoria;
	}

	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	}



	
	
	

}
