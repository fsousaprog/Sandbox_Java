package com.playground.sandbox.core;

/**
 * Sealed keyword was introduced in Java 15, as a way of securing a class to only be implemented
 * or extended by its expected children and it was upgraded to classes also in Java 17
 */
public sealed interface Animal permits Dog {

    static boolean isAnimal(Object object) {
        return object instanceof Animal;
    }

    /**
     * Java 8 added the default method in interfaces, allowing to have an inherited
     * behavior in case extending classes don't implement it
     *
     * @return Type of animal
     */
    default String type() {
        return "Animal";
    }

}
