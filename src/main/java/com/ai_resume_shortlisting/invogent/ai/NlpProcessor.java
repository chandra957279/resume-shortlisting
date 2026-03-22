package com.ai_resume_shortlisting.invogent.ai;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NlpProcessor {
	
	
	private static final Set<String> STOP_WORDS = Set.of(
		    "a", "an", "the", "is", "are", "in", "on", "at",
		    "for", "to", "with", "and", "or", "of"
		);
	
	private static final Set<String> SKILL_DICTIONARY_SET = Set.of(
			  "java", "spring", "spring boot", "hibernate",
	            "sql", "mysql", "postgresql",
	            "javascript", "react", "angular",
	            "node", "nodejs",
	            "docker", "kubernetes",
	            "aws", "azure",
	            "html", "css",
	            "eclipse", "vscode",

	            "experience", "project"
			);
	
	
	
	
	public static Set<String> extractKeyword(String text){

	    Set<String> keywords = new HashSet<>();

	    text = text.toLowerCase().replaceAll("[^a-zA-Z ]", " ");

	    // 🔥 ADD MULTI-WORD SKILLS SUPPORT
	    if (text.contains("spring boot")) keywords.add("spring boot");

	    String[] words = text.split("\\s+");

	    for(String word : words){
	        if(word.length() > 2 && !STOP_WORDS.contains(word)){
	            keywords.add(word);
	        }
	    }

	    return keywords;
	}
	
	public static Map<String, Integer> extractKeywordFrequency(String text){

	    Map<String, Integer> freqMap = new HashMap<>();

	    text = text.toLowerCase().replaceAll("[^a-zA-Z ]", " ");
	    text = text.replaceAll("\\s+", " ");

	    String[] words = text.split(" ");

	    for(String word : words){

	        if(word.length() > 2 && !STOP_WORDS.contains(word)){

	            if(word.endsWith("s")){
	                word = word.substring(0, word.length()-1);
	            }

	            if(SKILL_DICTIONARY_SET.contains(word)){
	                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
	            }
	        }
	    }

	    return freqMap;
	}
}		
