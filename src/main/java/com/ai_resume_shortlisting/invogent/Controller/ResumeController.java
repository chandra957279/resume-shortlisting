package com.ai_resume_shortlisting.invogent.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.ai_resume_shortlisting.invogent.ai.RoleType;

import com.ai_resume_shortlisting.invogent.service.ResumeService;


@RestController   // ✅ important
@RequestMapping("/resume")
public class ResumeController {

    @Autowired 
    private ResumeService resumeService;

    @PostMapping("/upload")
    public Map<String, Object> uploadResume(
            @RequestParam("file") MultipartFile file,
            @RequestParam("role") RoleType role) {

        return resumeService.processUploadResume(file, role);
    }
}