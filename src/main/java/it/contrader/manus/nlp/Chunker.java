package it.manus.nlp;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.util.InvalidFormatException;

public class Chunker {
	
	private ChunkerME chunker;
	private ChunkerModel model;
	
	private String[] chunks;
	private double[] probs;
	
	public Chunker(String[] tokens, String[] tags) throws InvalidFormatException, IOException {
		
		InputStream is = getClass().getResourceAsStream("en-chunker.bin");
		model = new ChunkerModel(is);
		chunker = new ChunkerME(model);
		
		chunks = chunker.chunk(tokens, tags);
		probs = chunker.probs();
		
		is.close();
	}

	public String[] getChunks() {
		return chunks;
	}

	public double[] getProbs() {
		return probs;
	}
	
	
}
