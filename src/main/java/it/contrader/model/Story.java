package it.contrader.model;

public class Story{
	
	private int id_storie ; 
	private String trama ; 
	private int id_categoria;
	
	public Story() {
		
	}
	
	public Story(int id_storie, String trama) {
		this.id_storie = id_storie ;
		this.trama = trama ; 
	}
	
	public Story(String trama) {
		this.trama = trama ; 
	}

	public Story(int id_story, String trama, int id_category) {
		this.id_storie = id_story ;
		this.trama = trama ; 
		this.id_categoria = id_category;
		
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

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}



	
	
	

}
