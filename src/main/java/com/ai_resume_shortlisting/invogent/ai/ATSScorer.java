package com.ai_resume_shortlisting.invogent.ai;

import java.util.Map;
import java.util.Set;

public class ATSScorer {
		public static int AtsCalculaterScore(Set<String> keywords, RoleProfile roleProfile) {
			
			  Set<String> normalizedKeywords = keywords.stream()
		                .map(String::toLowerCase)
		                .collect(java.util.stream.Collectors.toSet());
			
			
			int score = 0;
			score += calculateSectionScore("CORE",normalizedKeywords, roleProfile.getCoreSkills());
			score += calculateSectionScore("SUPPORTING",normalizedKeywords, roleProfile.getSupportingSkills());
			score += calculateSectionScore("TOOLS",normalizedKeywords, roleProfile.getTools());
			score += calculateSectionScore("EXEPERINCE", normalizedKeywords, roleProfile.exeperince());
			score += calculateSectionScore("PROJECT", normalizedKeywords, roleProfile.project());
			
			int maxScore = 155 + 30;

			int finalScore = (score * 100) / maxScore;

			if(finalScore > 95){
			    finalScore = 95;
			}

			return finalScore;
		}
		
		private static int calculateSectionScore(String section,Set<String> keywords, Map<String, Integer> skillsMap) {
			
			int sectionScore = 0;
			
			for(Map.Entry<String,Integer> entry : skillsMap.entrySet()) {
				String skill = entry.getKey().toLowerCase();
				
				boolean matched = keywords.stream().anyMatch(k -> k.contains(skill) || skill.contains(k));
				
				if(matched) {
					sectionScore += entry.getValue();
					System.out.println("MATCH [" + section + "] : " + skill + " +" + entry.getValue());
				}
			}
			return sectionScore;
		}	
}
