package models;

public class Person {
    private String name;
    private int age;
    private String contactNumber;

    public Person(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Contact Number: " + contactNumber;
    }
}
