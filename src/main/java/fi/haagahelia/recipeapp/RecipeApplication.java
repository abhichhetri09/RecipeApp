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
			 Recipe chickenCurry = new Recipe("Chicken Curry", "Aromatic and richly flavored chicken curry made with a blend of spices.", 
			            "Chicken thighs, coconut milk, curry powder, tomatoes, onions, garlic, ginger, cilantro, vegetable oil, salt, pepper", 
			            "1. Marinate chicken with curry powder, salt, and pepper. 2. Sauté onions, garlic, and ginger. 3. Add tomatoes and coconut milk. 4. Add chicken, simmer until cooked. 5. Garnish with cilantro.","Main Course");

			        Recipe mushroomStroganoff = new Recipe("Mushroom Stroganoff", "Creamy and savory mushroom stroganoff, perfect for a comforting meal.", 
			            "Mushrooms, onions, garlic, sour cream, mustard, vegetable broth, olive oil, flour, parsley, salt, pepper", 
			            "1. Sauté mushrooms and onions. 2. Add garlic and flour, cook for a minute. 3. Pour in broth, add mustard. 4. Stir in sour cream, simmer. 5. Season and garnish with parsley.","Main Course");

			        Recipe beefTacos = new Recipe("Beef Tacos", "Tasty and zesty beef tacos with a homemade spice mix.", 
			            "Ground beef, taco seasoning, corn tortillas, lettuce, tomato, cheese, sour cream, avocado, lime, cilantro, oil, salt", 
			            "1. Cook beef with taco seasoning. 2. Warm tortillas. 3. Assemble tacos with beef, lettuce, tomato, cheese. 4. Top with sour cream and avocado. 5. Serve with lime and cilantro.","Main Course");

			        Recipe pastaCarbonara = new Recipe("Pasta Carbonara", "Classic Italian pasta with a creamy egg sauce and crispy pancetta.", 
			            "Spaghetti, pancetta, eggs, Parmesan cheese, garlic, olive oil, black pepper, salt", 
			            "1. Cook pasta. 2. Sauté pancetta and garlic. 3. Beat eggs with cheese and pepper. 4. Combine pasta with pancetta, off heat mix in egg mixture. 5. Serve immediately.","Main Course");

			        Recipe quinoaSalad = new Recipe("Quinoa Salad", "Refreshing and healthy quinoa salad with a lemon vinaigrette.",
			                "Quinoa, cherry tomatoes, cucumber, red onion, feta cheese, olives, lemon juice, olive oil, parsley, mint, salt, pepper",
			                "1. Cook quinoa. 2. Chop vegetables and herbs. 3. Whisk together lemon juice, olive oil, salt, and pepper for dressing. 4. Combine all ingredients and toss with dressing. 5. Chill before serving.", "Apetizer");
			        Recipe bruschetta = new Recipe("Bruschetta with Tomato and Basil", 
			                "A delightful appetizer featuring toasted bread topped with a mixture of juicy tomatoes and fresh basil.", 
			                "Crusty bread, ripe tomatoes, fresh basil, garlic, balsamic vinegar, extra virgin olive oil, salt, pepper, Parmesan cheese", 
			                "1. Toast sliced bread drizzled with olive oil. 2. Mix diced tomatoes with chopped basil, minced garlic, vinegar, and oil. 3. Top bread with tomato mixture, sprinkle with cheese. Serve immediately.", 
			                "Appetizer");

			        // Dessert: Classic Chocolate Mousse
			        Recipe chocolateMousse = new Recipe("Classic Chocolate Mousse", 
			                "A rich and airy dessert made with silky chocolate and whipped cream, served chilled.", 
			                "Dark chocolate, eggs, granulated sugar, heavy cream, vanilla extract, salt, whipped cream, chocolate shavings", 
			                "1. Melt chocolate; cool slightly. 2. Mix in egg yolks. 3. Whip egg whites with salt, fold into chocolate. 4. Whip cream, fold in. 5. Chill. Garnish with whipped cream and shavings.", 
			                "Dessert");

			        // Another Appetizer: Garlic Herb Cheese Stuffed Mushrooms
			        Recipe stuffedMushrooms = new Recipe("Garlic Herb Cheese Stuffed Mushrooms", 
			                "Savory mushrooms stuffed with a delicious blend of garlic herb cheese and breadcrumbs.", 
			                "Mushrooms, garlic herb cheese, breadcrumbs, parsley, olive oil, salt, pepper", 
			                "1. Remove mushroom stems and stuff with cheese mix. 2. Top with breadcrumbs and drizzle with oil. 3. Bake until golden. Garnish with parsley.", 
			                "Appetizer");

			        Recipe lemonCheesecakeBars = new Recipe("Lemon Cheesecake Bars", 
			                "Creamy cheesecake bars with a tangy lemon flavor and a buttery graham cracker crust.", 
			                "Cream cheese, sugar, eggs, lemons, vanilla extract, graham crackers, butter, salt", 
			                "1. Mix crushed graham crackers with butter, press into pan. 2. Beat cream cheese with sugar, eggs, lemon zest, and juice. 3. Pour over crust, bake. Chill before slicing.", 
			                "Dessert");
			        
			        // Save all recipes to the repository
			        repository.save(chickenCurry);
			        repository.save(mushroomStroganoff);
			        repository.save(beefTacos);
			        repository.save(pastaCarbonara);
			        repository.save(quinoaSalad);
			        repository.save(bruschetta);
			        repository.save(chocolateMousse);
			        repository.save(stuffedMushrooms);
			        repository.save(lemonCheesecakeBars);
			        
			        User user1 = new User("user1", "$2a$12$VVcWP9kZGpWHYtCnEr1pV.VQ.brIbtiukxYPNBtvUUVPmU695MCBC", "USER");
					User user2 = new User("admin", "$2a$12$IDtzSjOcQLWNdAvV21W3Peu92F1xLulZvdmWCAVFYr9EnQ2.0jhkG", "ADMIN");
					User user3 = new User("kiran", "$2a$12$Rk4iqVNSjEumeJ.zwmKiQe4fI2u2FXP9wjl07prsGPDdbp.vp7EsG"+ "", "USER");

					urepository.save(user1);
			        urepository.save(user2);
			        urepository.save(user3);

			     // Username: user, password: user

			      //  userRepository.save(new User("user","$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));

			        

			        // Username: admin, password: admin

			       // userRepository.save(new User("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
		};
	}

}
