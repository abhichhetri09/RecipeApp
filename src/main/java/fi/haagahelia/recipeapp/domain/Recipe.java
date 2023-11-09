package fi.haagahelia.recipeapp.domain;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	private String ingredients;
	private String instructions;
	private String category;

	@OneToMany(mappedBy = "recipe")
	private Set<RecipeLike> likes;
	// Field for image path

	private String imagePath;

	// Constructors, other getters and setters...

	public String getImagePath() {
		// If you're naming the image files by recipe ID, construct the path like this:
		return id != null ? "/img/recipes/" + id + ".jpeg" : null;
	}

	// Setter for the image path
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	// In your form-backing DTO


	// Getter for the likes
	public Set<RecipeLike> getLikes() {
		return likes;
	}

	// Setter for the likes
	public void setLikes(Set<RecipeLike> likes) {
		this.likes = likes;
	}

	// Constructors, getters, and setters

	public Recipe() {
	}

	public Recipe(String name, String description, String ingredients, String instructions, String category) {
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
