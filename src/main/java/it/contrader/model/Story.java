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
	
	

}
