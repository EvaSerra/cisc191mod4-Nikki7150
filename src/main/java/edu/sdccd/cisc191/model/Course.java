package edu.sdccd.cisc191.model;

public class Course {
    private int id;
    private String title;
    private int studentId;

    public Course(int id, String title, int studentId) {
        // TODO validate fields and assign them
        if (id<=0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        if (title==null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid title");
        }
        if (studentId<=0) {
            throw new IllegalArgumentException("Invalid Student ID");
        }

        this.id = id;
        this.title = title;
        this.studentId = studentId;
    }

    public int getId() {
        // TODO
        return id;
    }

    public String getTitle() {
        // TODO
        return title;
    }

    public int getStudentId() {
        // TODO
        return studentId;
    }

    @Override
    public String toString() {
        // TODO
        return "Course{id=" + id + ", title=" + title + ", studentId=" + studentId + "}";
    }
}
