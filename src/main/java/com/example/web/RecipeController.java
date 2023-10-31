package com.example.web;

import com.example.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String listAllRecipes(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String viewRecipeById(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.findById(id);
        if(recipe != null) {
            model.addAttribute("recipe", recipe);
            return "recipe";
        } else {
            return "redirect:/recipes/error";  // Redirecting to a custom error page under /recipes
        }
    }

    @GetMapping("/about")
    public String displayAboutPage() {
        return "about";
    }

    @GetMapping("/error")
    public String displayErrorPage() {
        return "error";
    }
}
