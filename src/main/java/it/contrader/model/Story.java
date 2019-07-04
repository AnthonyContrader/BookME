package it.contrader.model;

public class Story {
	
	private int id_story ; 
	private String trama ; 
	
	public Story() {
		
	}
	
	public Story(int id_story, String trama) {
		this.id_story = id_story ;
		this.trama = trama ; 
	}
	
	public Story(String trama) {
		this.trama = trama ; 
	}

	public int getId_story() {
		return id_story;
	}

	public void setId_story(int id_story) {
		this.id_story = id_story;
	}

	public String getTrama() {
		return trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	@Override
	public String toString() {
		return "Story [id_story=" + id_story + ", trama=" + trama + "]";
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
		if (id_story != other.id_story)
			return false;
		if (trama == null) {
			if (other.trama != null)
				return false;
		} else if (!trama.equals(other.trama))
			return false;
		return true;
	}
	
	
	

}
