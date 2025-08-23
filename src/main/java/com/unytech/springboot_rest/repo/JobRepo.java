package com.unytech.springboot_rest.repo;

import com.unytech.springboot_rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class JobRepo {

        List<JobPost> jobs =new ArrayList<>();


        public JobRepo(){




                    jobs.add(new JobPost(1,"Java Developer","Good Experience",3,Stream.of("Java","Microsercices","H2").collect(Collectors.toList())));

                    // Frontend Developer Job Post
                    jobs.add(new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                            3, Stream.of("HTML", "CSS", "JavaScript", "React").collect(Collectors.toList())));

                    // Data Scientist Job Post
                    jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                            Stream.of("Python", "Machine Learning", "Data Analysis").collect(Collectors.toList())));
        }


    public List<JobPost> getAllJobs() {
            return jobs;
    }

    public JobPost getJob(int postId) {

        for(JobPost job : jobs){
            if(job.getPostId() == postId){
                return job;
            }
        }

        return null;
    }

    public void addJob(JobPost jobPost) {
        jobs.add(jobPost);
    }

    public void updateJob(JobPost jobPost) {

            for(JobPost jobPost1 : jobs){
                if(jobPost1.getPostId() == jobPost.getPostId()){
                    jobPost1.setPostProfile(jobPost.getPostProfile());
                    jobPost1.setPostDesc(jobPost.getPostDesc());
                    jobPost1.setReqExperience(jobPost.getReqExperience());
                    jobPost1.setPostTechStack(jobPost.getPostTechStack());
                }
            }


    }

    public void deleteJob(int postId) {

            for(JobPost jobPost : jobs){
                if(jobPost.getPostId() ==postId){
                    jobs.remove(jobPost);
                }
            }
    }
}
