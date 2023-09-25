package com.playground.sandbox.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Set;

import static java.time.LocalDate.now;
import static java.time.Period.between;
import static java.util.Optional.ofNullable;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

public class AnimalService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * This method implements two new functionalities from Java 8.
     * The stream is a more efficient way for data processing of collections, allowing many interactions with it.
     * The :: are method references, simplifying code hen passing methods as arguments
     *
     * @param dogs List of dog
     * @return String with all types
     */
    public String joinTypes(Set<Dog> dogs) {
        return dogs.stream().map(Animal::type).collect(joining(", "));
    }

    /**
     * Java 8 introduced the Optional helper that avoids null pointer exceptions and secure the behavior of the code
     * Java 10 introduced the var type for local variables, making them implicit like javascript. Also, Java 11 made them usable in lambdas
     *
     * @param dog      Dog
     * @param limitAge Age
     */
    public boolean isOldEnough(Dog dog, Integer limitAge) {
        var dogsAge = between(dog.birthDate(), now()).getYears();
        return ofNullable(limitAge).orElse(6) < dogsAge;
    }

    /**
     * Java 8 introduced a more practical way to iterate through a list using forEach,
     * like it's done in other languages (Javascript, Python).
     * Also, one of the greatest introductions was the lambda functions. Here's a simple one for printing all dogs colors,
     * but it's a straightforward way of using anonymous functions.
     *
     * @param dogs List of dogs
     */
    public void listColors(Set<Dog> dogs) {
        dogs.forEach(dog -> logger.info(dog.color()));
    }

    /**
     * Java 17 improved the readability and reduced the complexity of switch cases using anonymous functions
     *
     * @param birthDate Date of birth
     * @return Stage of life
     */
    public String getAgeStage(LocalDate birthDate) {
        var dogsAge = between(birthDate, now()).getYears();
        return switch (dogsAge) {
            case 0, 1, 2 -> "Puppy";
            case 3, 4 -> "Young";
            case 5, 6, 7, 8 -> "Adult";
            default -> "Old";
        };
    }

    /**
     * Java 11 added the predicate "not" to be used as negation (!) inside streams and using method references.
     * Also in Java 11, it was added a few new methods for the String class, such as .isBlank .lines .strip
     *
     * @param dogs List of Dog
     */
    public void cleanNames(Set<Dog> dogs) {
        Set<String> cleanNames = dogs.stream().map(Dog::name).filter(not(String::isBlank)).collect(toSet());
        cleanNames.forEach(logger::info);
    }
}
