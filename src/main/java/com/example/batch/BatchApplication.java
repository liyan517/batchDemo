package com.example.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {

	@Autowired
	private JobLauncher jobLauncher;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BatchApplication.class, args);
		//Job job = (Job) ctx.getBean(args[0]);

	}
}
