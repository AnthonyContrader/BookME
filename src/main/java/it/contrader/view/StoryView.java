/*
 * DEDOU AHUA MAXIMIN */

package it.contrader.view;

import it.contrader.controller.Request;

public class StoryView extends AbstractView{

	private int id_personaggio;  //id del personaggio che scrive la storia
	private String trama ;  // la trama della storia che viene scritta
	
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
	}
	

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		
		System.out.println("----- .:STORIA VIEW:. ------- ");
		
		

	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
		//StoryView sv = new StoryView() ; 
		//sv.showOptions(); 
	}


}
