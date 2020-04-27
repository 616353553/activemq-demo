package com.cheer.activemqdemo.vo;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private Integer age;
    private Address address;

    public Student() {
        // default constructor
    }

    public Student(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class StudentBuilder {
        private String name = "unknown name";
        private Integer age = 0;
        private Address address = null;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public StudentBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(name, age, address);
        }
    }
}
