package com.playground.sandbox.core;


import java.time.LocalDate;

/**
 * This class it's implemented using the *record* keyword. It works similar to lombok data.
 * The record class already has a constructor created with all arguments, as all basic methods
 * (hash, equals, getters, setters)
 *
 * @param name      Name of the dog
 * @param color     Color it has
 * @param birthDate Date of birth
 */
public record Dog(String name, String color, LocalDate birthDate) implements Animal {
}
