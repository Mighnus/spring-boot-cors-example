package com.kochbibel.init;

import com.kochbibel.ingredients.Ingredient;
import com.kochbibel.ingredients.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Component
public class H2DataInitRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(H2DataInitRunner.class);
    private IngredientRepository ingredientRepository;

    @Autowired
    public H2DataInitRunner(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Initialisation of ingredients in the H2 DB.");

        this.ingredientRepository.saveAll(
            Arrays.asList(
                new Ingredient(UUID.randomUUID(), "Apfel"),
                new Ingredient(UUID.randomUUID(), "Banane"),
                new Ingredient(UUID.randomUUID(), "Kiwi"),
                new Ingredient(UUID.randomUUID(), "Melone"),
                new Ingredient(UUID.randomUUID(), "Orange"),
                new Ingredient(UUID.randomUUID(), "Zitrone")
            )
        );
    }
}
