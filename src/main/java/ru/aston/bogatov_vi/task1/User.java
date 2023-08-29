package ru.aston.bogatov_vi.task1;

public class User {
    int age;
    String sourName;
    String name;

    public User(int age, String sourName, String name) {
        this.age = age;
        this.sourName = sourName;
        this.name = name;
    }

    public String getSourName() {
        return sourName;
    }

    public void setSourName(String sourName) {
        this.sourName = sourName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}