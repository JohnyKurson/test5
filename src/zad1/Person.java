package zad1;

public class Person {
    private String name,city;
    private int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person (" +
                "Name: " + name+
                ", City: " + city +
                ", Age: " + age + ')';
    }
}
