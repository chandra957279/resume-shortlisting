package com.ai_resume_shortlisting.invogent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai_resume_shortlisting.invogent.model.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
