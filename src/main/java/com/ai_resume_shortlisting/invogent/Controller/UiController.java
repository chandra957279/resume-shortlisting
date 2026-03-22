package com.ai_resume_shortlisting.invogent.Controller;


import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;


import com.ai_resume_shortlisting.invogent.ai.RoleType;

import com.ai_resume_shortlisting.invogent.service.ResumeService;

import org.springframework.ui.Model; 

@Controller
public class UiController {
	
	@Autowired
	private ResumeService resumeService;
	
	@GetMapping("/")
	public String uploadPage() {
		return "upload";
	}
	
	@PostMapping("/uploadResume")
	public String handleUpload(@RequestParam("file") MultipartFile file,
	                           @RequestParam("role") RoleType roleType,
	                           Model model) {

	    Map<String, Object> result = resumeService.processUploadResume(file, roleType);

	   
	    model.addAttribute("score", result.get("score"));
	    model.addAttribute("matchedSkills", result.get("matchedSkills"));
	    model.addAttribute("missingSkills", result.get("missingSkills"));
	    model.addAttribute("experience", result.get("experience"));
	    model.addAttribute("projectCount", result.get("projectCount"));

	    return "result";
	}
}
