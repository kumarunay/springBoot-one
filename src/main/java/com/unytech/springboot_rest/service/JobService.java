package com.unytech.springboot_rest.service;

import com.unytech.springboot_rest.model.JobPost;
import com.unytech.springboot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {
    @Autowired
    public JobRepo jobRepo;
    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public JobPost getJob(int postId) {
        return jobRepo.getJob(postId);
    }

    public void addJob(JobPost jobPost) {
            jobRepo.addJob(jobPost);
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepo.deleteJob(postId);
    }
}
