package domain;

import org.jetbrains.annotations.NotNull;

public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
