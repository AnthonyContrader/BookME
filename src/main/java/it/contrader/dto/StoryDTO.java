package it.contrader.dto;

public class StoryDTO {
	
    private int id_story ; 
    private String trama ;
    private int id_category;
    
	public StoryDTO(int id_story, String trama) {
		this.id_story = id_story;
		this.trama = trama;
	}
	
	public StoryDTO(int storyId,String trama,int categoryId) {
		id_story = storyId;
		this.trama = trama;
		id_category = categoryId;
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

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	} 
   
   

}
