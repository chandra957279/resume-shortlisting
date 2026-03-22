package com.ai_resume_shortlisting.invogent.ai;

import java.util.*;
import java.util.regex.*;


public class ResumeAnalyzer {

	public static Map<String, Object> analyze(String text, RoleType roleType) {

	    Set<String> keywords = NlpProcessor.extractKeyword(text);
	    RoleProfile profile = RoleProfileFactory.getProfile(roleType);

	    Map<String, Object> result = new HashMap<>();

	    
	    Set<String> allSkills = new HashSet<>();
	    allSkills.addAll(profile.getCoreSkills().keySet());
	    allSkills.addAll(profile.getSupportingSkills().keySet());
	    allSkills.addAll(profile.getTools().keySet());

	    Set<String> matched = new HashSet<>();
	    Set<String> missing = new HashSet<>();

	    for (String skill : allSkills) {
	        if (keywords.contains(skill.toLowerCase())) {
	            matched.add(skill);
	        } else {
	            missing.add(skill);
	        }
	    }

	    
	    int experience = extractExperience(text);

	    
	    int projectCount = extractProjects(text);

	    System.out.println("FINAL PROJECT COUNT = " + projectCount);
	    System.out.println("EXPERIENCE YEARS = " + experience);

	   
	    int score = ATSScorer.AtsCalculaterScore(keywords, profile);

	    
	    score += projectCount * 2;   
	    score += experience * 5;     

	    score = Math.min(score, 100);

	 
	    result.put("score", score);
	    result.put("matchedSkills", matched);
	    result.put("missingSkills", missing);
	    result.put("projectCount", projectCount);
	    result.put("experience", experience);

	    return result;
	}
	
	private static int extractExperience(String text) {
	    Pattern pattern = Pattern.compile("(\\d+)\\+?\\s*(year|years)");
	    Matcher matcher = pattern.matcher(text.toLowerCase());

	    if (matcher.find()) {
	        return Integer.parseInt(matcher.group(1));
	    }
	    return 0;
	}



	private static int extractProjects(String text) {

	    String lower = text.toLowerCase();

	    if (!lower.contains("projects")) {
	        return 0;
	    }

	    int start = lower.indexOf("projects");
	    int end = lower.indexOf("education");

	    if (end == -1) {
	        end = lower.length();
	    }

	    String section = text.substring(start, end);

	    System.out.println("PROJECT SECTION:\n" + section);

	   
	    String[] parts = section.split("•");

	    int count = 0;

	    for (String part : parts) {

	        part = part.trim();
	        if (part.isEmpty()) continue;

	        String lowerPart = part.toLowerCase();

	       
	        if (lowerPart.startsWith("built") ||
	            lowerPart.startsWith("developed") ||
	            lowerPart.startsWith("implemented") ||
	            lowerPart.startsWith("designed") ||
	            lowerPart.startsWith("created")) {
	            continue;
	        }

	     
	        if (part.length() > 120) continue;

	   
	        if (part.contains("–") || part.contains("-") || part.contains(".com")) {

	            count++;
	            System.out.println("PROJECT HEADING: " + part);
	        }
	    }

	    System.out.println("FINAL PROJECT COUNT = " + count);

	    return count;
	}
}