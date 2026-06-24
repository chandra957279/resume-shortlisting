package com.ai_resume_shortlisting.invogent.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
	
	 @GetMapping("/health")
	    public String health() {
	        return "AI Resume ATS Scanner Running";
	    }
}
