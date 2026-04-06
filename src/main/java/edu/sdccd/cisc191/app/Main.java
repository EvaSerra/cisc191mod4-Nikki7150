package edu.sdccd.cisc191.app;

import edu.sdccd.cisc191.model.Course;
import edu.sdccd.cisc191.model.Student;
import edu.sdccd.cisc191.repository.CourseRepository;
import edu.sdccd.cisc191.repository.JdbcCourseRepository;
import edu.sdccd.cisc191.repository.JdbcStudentRepository;
import edu.sdccd.cisc191.repository.StudentRepository;
import edu.sdccd.cisc191.service.StudentService;
import edu.sdccd.cisc191.util.DatabaseInitializer;

public class Main {
    public static void main(String[] args) {
        // TODO initialize database
        DatabaseInitializer.initialize();

        // TODO create student service and repositories
        StudentRepository studentRepo = new JdbcStudentRepository(); //Not needed
        CourseRepository  courseRepo = new JdbcCourseRepository();
        StudentService studentService = new StudentService(studentRepo);

        // TODO add at least 3 students
        studentService.addStudent(new Student(1, "Eva", 4.0));
        studentService.addStudent(new Student(2, "Danny", 2.2));
        studentService.addStudent(new Student(3, "Savine", 3.7));

        // TODO add at least 3 courses linked to students
        courseRepo.save(new Course(1, "Math", 1));
        courseRepo.save(new Course(2, "Science", 2));
        courseRepo.save(new Course(3, "History", 1));

        // TODO print all students
        System.out.println("All Students: ");
        studentService.getAllStudents().forEach(System.out::println);

        //Printed all courses here to make it more clear that deleting students deleted courses:
        System.out.println("All Courses: ");
        courseRepo.findAll().forEach(System.out::println);

        // TODO find one student by ID
        System.out.println("\nFind student by ID: ");
        System.out.println(studentService.getStudent(1));

        // TODO print courses for a student
        System.out.println("\nCourses for Student ID 1: ");
        courseRepo.findByStudentId(1).forEach(System.out::println);

        // TODO update one GPA
        studentService.changeGpa(1, 3.75);

        // TODO delete one student
        //Made unnecessary after adding ON DELETE CASCADE to DatabaseInitializer
        //courseRepo.deleteByStudentId(2);
        studentService.removeStudent(2);

        // TODO print remaining students and courses
        System.out.println("\nAfter updates: ");
        studentService.getAllStudents().forEach(System.out::println);

        System.out.println("\nAll Courses: ");
        courseRepo.findAll().forEach(System.out::println);

    }
}
