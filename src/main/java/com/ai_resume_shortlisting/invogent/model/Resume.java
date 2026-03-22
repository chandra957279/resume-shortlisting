package com.ai_resume_shortlisting.invogent.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String skills; // full resume text

    private int score;

    

    @Lob
    @Column(columnDefinition = "TEXT")
    private String matchedSkills;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String missingSkills;

    private int experience;   
    private int projectCount; 
    private int keywordDensity; 
}