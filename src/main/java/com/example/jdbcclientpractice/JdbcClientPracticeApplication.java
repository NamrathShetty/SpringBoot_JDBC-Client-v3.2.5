package com.example.jdbcclientpractice;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jdbcclientpractice.post.Post;
import com.example.jdbcclientpractice.post.PostService;

@SpringBootApplication
public class JdbcClientPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcClientPracticeApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(@Qualifier("clientPostService") PostService postService){
		return args ->{
			postService.create(new Post("1234", "Hello-world", "hello-world", LocalDate.now(), 1, "java, spring"));
		};
	}
}
