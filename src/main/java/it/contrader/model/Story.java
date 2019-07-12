package it.contrader.model;

public class Story {
	
	private int id_Storie ; 
	private String trama ; 
	private int id_Categoria;
	
	public Story() {
		
	}

	public Story(String trama, int id_Categoria) {
		this.trama = trama;
		this.id_Categoria = id_Categoria;
	}

	public int getId_Storie() {
		return id_Storie;
	}

	public void setId_Storie(int id_Storie) {
		this.id_Storie = id_Storie;
	}

	public String getTrama() {
		return trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public int getId_Categoria() {
		return id_Categoria;
	}

	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	}

	@Override
	public String toString() {
		return "Story [id_Storie=" + id_Storie + ", trama=" + trama + ", id_Categoria=" + id_Categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_Categoria;
		result = prime * result + id_Storie;
		result = prime * result + ((trama == null) ? 0 : trama.hashCode());
		return result;
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
		if (id_Categoria != other.id_Categoria)
			return false;
		if (id_Storie != other.id_Storie)
			return false;
		if (trama == null) {
			if (other.trama != null)
				return false;
		} else if (!trama.equals(other.trama))
			return false;
		return true;
	} 
    
	
	
	
	
}
