package it.contrader.dto;

public class StoryDTO {
	
    private int id_story ; 
    private String trama ;
    
	public StoryDTO(int id_story, String trama) {
		this.id_story = id_story;
		this.trama = trama;
	}
	
	public StoryDTO(String trama) {
		this.trama = trama;
	}
	
	public StoryDTO() {
		
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
