package ru.aston.bogatov_vi.task4;

public class Person {
    private String name;
    private String surName;
    private int age;
    private City city;

    public Person(String name, String surName, int age, City city) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString(){
        return "name: " + name + " surname: " + surName + " age: " + age + " city: " + city;
    }
}