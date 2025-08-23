package com.unytech.springboot_rest.controller;

import com.unytech.springboot_rest.model.JobPost;
import com.unytech.springboot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class JobRestController {
        @Autowired
        public JobService jobService;

        @GetMapping("jobPosts")
        public List<JobPost> getAllJobs(){
            return jobService.getAllJobs();
        }

        @GetMapping("/jobPost/{postId}")
        public JobPost getJobPost(@PathVariable int postId){
                return jobService.getJob(postId);
        }

        @PostMapping("jobPost")
        public JobPost addJob(@RequestBody JobPost jobPost){
                jobService.addJob(jobPost);
                return jobService.getJob(jobPost.getPostId());
        }


        @PutMapping("jobPost")
        public JobPost updateJob(@RequestBody JobPost jobPost ){
                jobService.updateJob(jobPost);
                return jobService.getJob(jobPost.getPostId());
        }

        @DeleteMapping("jobPost/{postId}")
        public String deleteJob(@PathVariable int postId){
               jobService.deleteJob(postId);
               return "deleted";
        }
}
