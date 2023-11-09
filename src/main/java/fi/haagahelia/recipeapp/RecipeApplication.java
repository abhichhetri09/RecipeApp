package fi.haagahelia.recipeapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.recipeapp.domain.Recipe;
import fi.haagahelia.recipeapp.domain.RecipeRepository;
import fi.haagahelia.recipeapp.domain.User;
import fi.haagahelia.recipeapp.domain.UserRepository;



@SpringBootApplication
public class RecipeApplication {
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(RecipeRepository repository, UserRepository urepository) {
		return(args) ->{
			    
			     // Username: user, password: user

			      //  userRepository.save(new User("user","$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));

			        

			        // Username: admin, password: admin

			       // userRepository.save(new User("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
		};
	}

}
