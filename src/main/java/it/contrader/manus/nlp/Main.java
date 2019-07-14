package it.manus.nlp;

import java.awt.font.TextAttribute;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.simiacryptus.text.*;
import com.simiacryptus.text.gpt2.GPT2Util;
import com.simiacryptus.*;

import opennlp.tools.parser.Parse;
import opennlp.tools.util.Span;

public class Main {

	
	public static void main(String[] args) throws IOException {

//		Path p = Paths.get("src\\data.txt");
//		String data = new String(Files.readAllBytes(p), StandardCharsets.UTF_8);
//		Scanner scanner = new Scanner(System.in);
//		
//		SentenceDetector se = new SentenceDetector(data);
//		String[] sentences = se.getSentences();
//		for(String s : sentences) {
//			Tokenizer t = new Tokenizer(s);
//			PosTagger pos = new PosTagger(t.getTokens());
//			Chunker c = new Chunker(t.getTokens(),pos.getTags());
//			NameFinder n = new NameFinder(t.getTokens());
//			
//			for(Span span : n.getNames()) {
//				print(span.toString() + "\t" + t.getTokens()[span.getStart()]);
//			}
//			SentenceParser sp = new SentenceParser(s);
//			sp.getTopParse()[0].show();
//			print(sp.getTopParse()[0]);
//			for(Parse parse : sp.getTopParse()) {
//				print(parse.toString());
//				print("Type:\t" + parse.getType());
//				print("Children:\t" + parse.getChildCount());
//				print(parse);
//			}
//			print("Press a button to continue...");
//			scanner.nextLine();
//		}
		
//		generate();
	}
	
	
//	private static void print(String str) {
//		System.out.println(str);
//	}
//	
//	private static void print(Parse p) {
//		if(p != null) {
//			if(p.getProb()> .9 )
//				print(p.getSpan().toString() + "\t" + p.getType() + "\t" + p.getText().substring(p.getSpan().getStart(), p.getSpan().getEnd()));
//			for(Parse pp : p.getChildren()) {
//				print(pp);
//			}
//		}
//	}
//	
//	
//	public static void generate() {
//		
//		    try {
//		    	System.load("C:\\Users\\manus\\Downloads\\libtensorflow_jni-cpu-windows-x86_64-1.14.0\\tensorflow_jni.dll");
//		    } catch (UnsatisfiedLinkError e) {
//		      System.err.println("Native code library failed to load.\n" + e);
//		      System.exit(1);
//		    }
//		  
//		TextGenerator textGenerator = GPT2Util.getTextGenerator();
//		System.out.println(textGenerator.generateText(100));
//	}

}
