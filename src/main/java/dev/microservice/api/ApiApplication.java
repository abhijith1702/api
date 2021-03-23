package dev.microservice.api;

import dev.microservice.api.model.Palindrome;
import dev.microservice.api.repository.PalindromeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(PalindromeRepository repository){

        return args -> {
            repository.save(new Palindrome("eve"));
        };

    }

}
