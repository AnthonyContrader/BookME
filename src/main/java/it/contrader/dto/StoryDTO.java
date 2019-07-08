package it.contrader.dto;

public class StoryDTO {
	
    private int id_story ; 
    private String trama ;
    private int id_Categoria;
    
	public StoryDTO(int id_story, String trama, int idCategoria) {
		this.id_story = id_story;
		this.trama = trama;
		this.id_Categoria = idCategoria;
	}
	
	public StoryDTO(String trama, int idCategoria) {
		this.trama = trama;
		this.id_Categoria = idCategoria;
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

	public int getId_Categoria() {
		return id_Categoria;
	}

	public void setId_Categoria(int id_Categoria) {
		this.id_Categoria = id_Categoria;
	} 
   
   

}
