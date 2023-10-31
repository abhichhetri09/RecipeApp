package fi.haagahelia.recipeapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.recipeapp.domain.Recipe;
import fi.haagahelia.recipeapp.domain.RecipeRepository;

@SpringBootApplication
public class RecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(RecipeRepository repository) {
		return(args) ->{
			Recipe recipe = new Recipe("Chicken", "Simple chichken curry", "Chicken, Onion, Salt,oil,garlic","Instruction");
			Recipe recipe1 = new Recipe("Mushroom", "Simple mushroom curry", "Mushroom, Onion, Salt,oil,garlic","Instruction1");
			
			repository.save(recipe);
			repository.save(recipe1);
		};
	}

}
