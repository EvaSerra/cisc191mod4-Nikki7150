package edu.sdccd.cisc191.model;

public class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        // TODO validate fields and assign them
        //Changed the error messages for easier debugging
        if (id<=0) {
            throw new IllegalArgumentException("ID must be higher than 0");
        }
        if (name==null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be blank");
        }
        if (gpa<0.0 || gpa>4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }

        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        // TODO
        return id;
    }

    public String getName() {
        // TODO
        return name;
    }

    public double getGpa() {
        // TODO
        return gpa;
    }

    public void setName(String name) {
        // TODO validate and assign
        //Changed the error message for easier debugging
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("New name can't be blank");
        }
        this.name = name;
    }

    public void setGpa(double gpa) {
        // TODO validate and assign
        //Changed the error message for easier debugging
        if (gpa<0.0 || gpa>4.0) {
            throw new IllegalArgumentException("New GPA must be between 0.0 and 4.0");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        // TODO
        return "Student{id=" + id + ", name=" + name + ", gpa=" + gpa + "}";
    }
}
