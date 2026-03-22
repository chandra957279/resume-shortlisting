package com.ai_resume_shortlisting.invogent.service;




import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.ai_resume_shortlisting.invogent.ai.ResumeAnalyzer;

import com.ai_resume_shortlisting.invogent.ai.RoleType;
import com.ai_resume_shortlisting.invogent.dao.ResumeRepository;

import com.ai_resume_shortlisting.invogent.utils.PdfReaderUtil;





@Service
public class ResumeService {
	@Autowired
	private ResumeRepository resumeRepository;
	public Map<String, Object> processUploadResume(MultipartFile file, RoleType roleType) {

	    String text = PdfReaderUtil.extractTextFromPdf(file);

	    Map<String, Object> result = ResumeAnalyzer.analyze(text, roleType);

	    return result;
	}
}
