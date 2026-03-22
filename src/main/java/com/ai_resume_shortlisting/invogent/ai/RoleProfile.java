package com.ai_resume_shortlisting.invogent.ai;

import java.util.Map;

public class RoleProfile {
	
	private Map<String, Integer> coreSkills;
	private Map<String, Integer> supportingSkills;
	private Map<String, Integer> tools;
	private Map<String, Integer> experience;
	private Map<String, Integer> project;
	
	public RoleProfile(Map<String , Integer> coreSkills,Map<String, Integer>  supportingSkills,Map<String, Integer>  tools, Map<String, Integer> experience, Map<String, Integer> project) {
		this.coreSkills = coreSkills;
		this.supportingSkills = supportingSkills;
		this.tools = tools;
		this.experience = experience;
		this.project = project;
	}
	
	public Map<String, Integer> getCoreSkills(){
		return coreSkills;
	}
	
	public Map<String, Integer> getSupportingSkills(){
		return supportingSkills;
	}
	
	public Map<String, Integer> getTools(){
		return tools;
	}
	
	public Map<String, Integer> exeperince(){
		return experience;
	}
	
	public Map<String, Integer> project(){
		return project;
	}
	
	
}
