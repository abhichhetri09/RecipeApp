package fi.haagahelia.recipeapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Find comments by recipe
    List<Comment> findByRecipeIdOrderByPostedAtDesc(Long recipeId);
    List<Comment> findByRecipeId(Long recipeId);
   
}