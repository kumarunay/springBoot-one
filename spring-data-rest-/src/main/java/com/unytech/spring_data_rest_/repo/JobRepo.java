package com.unytech.spring_data_rest_.repo;

import com.unytech.spring_data_rest_.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {


}
