package com.playground.sandbox.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AnimalServiceTest {

    private final Set<Dog> dogs = new HashSet<>();
    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        this.animalService = new AnimalService();
        dogs.add(new Dog("Titan", "Black", LocalDate.of(2022, 7, 14)));
        dogs.add(new Dog("Bimbo", "White", LocalDate.of(2018, 10, 2)));
        dogs.add(new Dog("Stormaggedom", "Grey", LocalDate.of(2019, 4, 25)));
        dogs.add(new Dog("Farofa", "Brown", LocalDate.of(2020, 12, 30)));
    }

    @Test
    void joinTypes() {
        assertEquals("Animal, Animal, Animal, Animal", animalService.joinTypes(dogs));
    }

    @Test
    void isOldEnough() {
        assertFalse(animalService.isOldEnough(dogs.stream().findFirst().get(), null));
    }

    @Test
    void listColors() {
        animalService.listColors(dogs);
    }

    @Test
    void getAgeStage() {
        assertEquals("Young", animalService.getAgeStage(dogs.stream().findFirst().get().birthDate()));
    }

    @Test
    void cleanNames() {
        animalService.cleanNames(dogs);
    }
}