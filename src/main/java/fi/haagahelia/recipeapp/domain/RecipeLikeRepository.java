package fi.haagahelia.recipeapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeLikeRepository extends CrudRepository<RecipeLike, Long> {
    // Find likes by recipe
    List<RecipeLike> findByRecipeId(Long recipeId);
    
    // Find likes by user
    List<RecipeLike> findByUserId(Long userId);
    
    @Query("SELECT COUNT(rl) FROM RecipeLike rl WHERE rl.recipe.id = :recipeId")

    int countByRecipeId(Long recipeId);
}
