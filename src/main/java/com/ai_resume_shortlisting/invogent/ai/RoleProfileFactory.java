package com.ai_resume_shortlisting.invogent.ai;

import java.util.Map;

public class RoleProfileFactory {
	public static RoleProfile getProfile(RoleType role) {

        switch (role) {

            case JAVA_DEVELOPER:
                return new RoleProfile(

                        
                        Map.of(
                                "java", 30,
                                "spring", 25,
                                "spring boot", 20,
                                "sql", 15
                        ),

                        
                        Map.of(
                                "hibernate", 10,
                                "jpa", 10,
                                "rest", 10
                        ),

                        
                        Map.of(
                                "git", 5,
                                "postman", 5,
                                "docker", 5
                        ),

                        
                        Map.of(
                                "experience", 10
                        ),

                        
                        Map.of(
                                "project", 10
                        )
                );

            case PYTHON_DEVELOPER:
                return new RoleProfile(

                        Map.of(
                                "python", 30,
                                "django", 25,
                                "flask", 20
                        ),

                        Map.of(
                                "pandas", 15,
                                "numpy", 15
                        ),

                        Map.of(
                                "git", 5,
                                "docker", 5
                        ),

                        Map.of(
                                "experience", 10
                        ),

                        Map.of(
                                "project", 10
                        )
                );

            case DEVOPS_ENGINEER:
                return new RoleProfile(

                        Map.of(
                                "docker", 25,
                                "kubernetes", 25,
                                "aws", 20
                        ),

                        Map.of(
                                "jenkins", 15,
                                "ci", 10
                        ),

                        Map.of(
                                "linux", 10,
                                "git", 5
                        ),

                        Map.of(
                                "experience", 10
                        ),

                        Map.of(
                                "project", 10
                        )
                );

            default:
                throw new IllegalArgumentException("Unknown role");
        }
    }
}
