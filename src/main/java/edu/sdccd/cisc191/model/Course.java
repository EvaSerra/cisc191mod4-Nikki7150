package edu.sdccd.cisc191.model;

public class Course {
    private int id;
    private String title;
    private int studentId;

    public Course(int id, String title, int studentId) {
        // TODO validate fields and assign them
        //Changed the error messages for easier debugging
        if (id<=0) {
            throw new IllegalArgumentException("Course ID must be between 0.0 and 4.0");
        }
        if (title==null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Course title can't be blank");
        }
        if (studentId<=0) {
            throw new IllegalArgumentException("Student ID must be a positive number");
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
