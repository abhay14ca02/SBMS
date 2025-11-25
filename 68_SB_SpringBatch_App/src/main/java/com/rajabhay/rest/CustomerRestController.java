package com.rajabhay.rest;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {

	@SuppressWarnings("removal")
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	@SuppressWarnings("deprecation")
	@GetMapping("/import")
	public void loadDataToDB() throws Exception {

		JobParameters jobParams = new JobParametersBuilder().addLong("startAt", System.currentTimeMillis())
				.toJobParameters();

		jobLauncher.run(job, jobParams);
	}

}
