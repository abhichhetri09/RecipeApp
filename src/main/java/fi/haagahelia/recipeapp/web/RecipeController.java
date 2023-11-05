package fi.haagahelia.recipeapp.web;

import fi.haagahelia.recipeapp.domain.Recipe;
import fi.haagahelia.recipeapp.domain.RecipeRepository;
import fi.haagahelia.recipeapp.domain.User;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.classic.Logger;

import java.security.Principal;
import java.util.List;

@Controller
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(RecipeController.class);

	@GetMapping("/")
	public String getAllRecipes(Model model, Authentication authentication) {

		List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
		model.addAttribute("recipes", recipes);
		model.addAttribute("username", authentication.getName());
		logger.info("Number of recipes found: " + recipes.size());
		boolean isAdmin = authentication.getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
		model.addAttribute("isAdmin", isAdmin);
		return "index"; // This should be the name of your Thymeleaf template
	}
	@GetMapping("/recipes/{id}")
	public String viewRecipe(@PathVariable Long id, Model model) {
	    Recipe recipe = recipeRepository.findById(id).orElse(null);
	    model.addAttribute("recipe", recipe);
	    return "recipeDetail"; // The name of your Thymeleaf template for recipe details
	}


	@GetMapping("/recipes/error")
	public String errorPage() {
		return "error"; // This should be the name of your Thymeleaf error template
	}

	@GetMapping("/recipes/add")
	public String addRecipeForm(Model model) {
		model.addAttribute("recipe", new Recipe());
		return "addRecipe";
	}

	@PostMapping("/recipes")
	public String saveRecipe(@ModelAttribute Recipe recipe) {
		recipeRepository.save(recipe);
		return "redirect:/recipes";
	}

	@GetMapping("/recipes/edit/{id}")
	public String editRecipeForm(@PathVariable Long id, Model model) {
		model.addAttribute("recipe", recipeRepository.findById(id));
		return "editRecipe";
	}

	@PostMapping("/recipes/edit")
	public String updateRecipe(@ModelAttribute Recipe recipe) {
		recipeRepository.save(recipe);
		return "redirect:/recipeDetail";
	}

	@PostMapping("/recipes/delete/{id}")
	public String deleteRecipe(@PathVariable Long id) {
		recipeRepository.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/recipes/category/{category}")
	public String getRecipesByCategory(@PathVariable String category, Model model) {
		model.addAttribute("recipes", recipeRepository.findByCategory(category));
		return "index"; // Assuming "index" is the template that lists recipes
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

}
