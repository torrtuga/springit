package com.vega.springit;

import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
		return args -> {
			Link link = new Link("Getting started with spring boot 2", "https://www.danvega.dev/docs/spring-boot-2-docs/");
			linkRepository.save(link);

			Comment comment = new Comment("This springboot 2 is awesome", link);
			commentRepository.save(comment);
			link.addComment(comment);

			Link firstLink = linkRepository.findByTitle("Getting started with spring boot 2");
			System.out.println(firstLink.getTitle());
		};
	}

}
