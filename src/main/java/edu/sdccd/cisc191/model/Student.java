package edu.sdccd.cisc191.model;

public class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        // TODO validate fields and assign them
        if (id<=0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (name==null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid title");
        }
        if (gpa<0.0 || gpa>4.0) {
            throw new IllegalArgumentException("Invalid GPA");
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
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public void setGpa(double gpa) {
        // TODO validate and assign
        if (gpa<0.0 || gpa>4.0) {
            throw new IllegalArgumentException("Invalid GPA");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        // TODO
        return "Student{id=" + id + ", name=" + name + ", gpa=" + gpa + "}";
    }
}
