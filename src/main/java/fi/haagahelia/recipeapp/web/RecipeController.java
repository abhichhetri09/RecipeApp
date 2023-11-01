package fi.haagahelia.recipeapp.web;

import fi.haagahelia.recipeapp.domain.Recipe;
import fi.haagahelia.recipeapp.domain.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;

	@GetMapping("/recipes")
	public String getAllRecipes(Model model) {
		List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();
		model.addAttribute("recipes", recipes);
		return "index"; // This should be the name of your Thymeleaf template
	}

	@GetMapping("/recipes/{id}")
	public String getRecipeById(@PathVariable Long id, Model model) {
		Recipe recipe = recipeRepository.findById(id).orElse(null);
		if (recipe != null) {
			model.addAttribute("recipe", recipe);
			return "recipeDetail"; // This should be the name of your Thymeleaf template for displaying a single
									// recipe's details
		} else {
			return "redirect:/recipes/error"; // Redirecting to a custom error page under /recipes
		}
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
		return "redirect:/recipes";
	}

	@PostMapping("/recipes/delete/{id}")
	public String deleteRecipe(@PathVariable Long id) {
		recipeRepository.deleteById(id);
		return "redirect:/recipes";
	}
	@GetMapping("/recipes/category/{category}")
	public String getRecipesByCategory(@PathVariable String category, Model model) {
	    model.addAttribute("recipes", recipeRepository.findByCategory(category));
	    return "index"; // Assuming "index" is the template that lists recipes
	}

}
