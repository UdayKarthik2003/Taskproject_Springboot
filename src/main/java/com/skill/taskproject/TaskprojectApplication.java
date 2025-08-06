package com.skill.taskproject;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication(scanBasePackages = {"com.skill.taskproject", "com.Security"})
public class TaskprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskprojectApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
