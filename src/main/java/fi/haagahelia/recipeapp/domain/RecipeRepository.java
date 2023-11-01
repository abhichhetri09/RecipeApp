package fi.haagahelia.recipeapp.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	List<Recipe> findByCategory(String category);}
