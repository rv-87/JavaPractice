package org.vrai.StreamApi.helper;

public class Person2 {

    String name;
    String city;

    public Person2(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity(){
        return city;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
