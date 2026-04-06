package edu.sdccd.cisc191.util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {
        // TODO create students table if it does not exist
        // students: id INT PRIMARY KEY, name VARCHAR(100) NOT NULL, gpa DOUBLE NOT NULL

        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement()){
            String studentsTable = """
                      CREATE TABLE IF NOT EXISTS students(
                      id INT PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      gpa DOUBLE NOT NULL
                      );
                    """;

            // TODO create courses table if it does not exist
            // courses: id INT PRIMARY KEY, title VARCHAR(100) NOT NULL, student_id INT,
            // FOREIGN KEY (student_id) REFERENCES students(id)

            String coursesTable = """
                    CREATE TABLE IF NOT EXISTS courses (
                    id INT PRIMARY KEY,
                    title VARCHAR(100) NOT NULL,
                    student_id INT,
                    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
                    );
                    """;
            /* Could add ON DELETE CASCADE to avoid having to use deleteByStudentId
             */

            //Deletes existing data when run avoids mistakes of repeated data
            stmt.execute("DROP TABLE IF EXISTS courses");
            stmt.execute("DROP TABLE IF EXISTS students");

            stmt.execute(studentsTable);
            stmt.execute(coursesTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
