package it.manus.nlp;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.*;
import opennlp.tools.util.Span;

public class SentenceDetector {

	private SentenceDetectorME sDetector;
	private SentenceModel sModel;
	
	private String[] sentences;
	private Span[] spans;
	private double[] probs;
	
	public SentenceDetector(String str) throws IOException {
		
		InputStream is = getClass().getResourceAsStream("en-sent.bin");
		sModel = new SentenceModel(is);
		
		sDetector = new SentenceDetectorME(sModel);
		
		sentences = sDetector.sentDetect(str);
		spans = sDetector.sentPosDetect(str);
		probs = sDetector.getSentenceProbabilities();
		
		is.close();
	}

	public String[] getSentences() {
		return sentences;
	}

	public Span[] getSpans() {
		return spans;
	}

	public double[] getProbs() {
		return probs;
	}
	
	public int getSentencesCount() {
		return sentences.length;
	}
	
	
}

