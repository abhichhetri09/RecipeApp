package com.example.web;




import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.domain.Recipe;

@Service
public class RecipeService {

    @PersistenceContext
    private EntityManager em;

    public List<Recipe> findAll() {
        return em.createQuery("SELECT r FROM Recipe r", Recipe.class).getResultList();
    }

    public Recipe findById(Long id) {
        return em.find(Recipe.class, id);
    }

    // Other necessary methods like save, delete, etc.
}
