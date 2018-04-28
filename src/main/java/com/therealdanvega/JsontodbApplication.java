package com.therealdanvega;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.therealdanvega.domain.News;
import com.therealdanvega.service.NewsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsontodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsontodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(NewsService userService){
	    return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<News>> typeReference = new TypeReference<List<News>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/news.json");
			try {
				List<News> users = mapper.readValue(inputStream,typeReference);
				userService.save(users);
				System.out.println("News Saved!");
			} catch (IOException e){
				System.out.println("Unable to save News: " + e.getMessage());
			}
	    };
	}
}
