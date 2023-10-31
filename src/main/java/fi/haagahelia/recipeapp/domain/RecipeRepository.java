package fi.haagahelia.recipeapp.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    // You can define custom query methods here if needed
}
