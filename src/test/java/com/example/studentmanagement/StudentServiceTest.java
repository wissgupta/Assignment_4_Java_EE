package com.example.studentmanagement;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void testAddStudent() {
        int initialSize = studentService.getAllStudents().size();
        Student student = new Student();
        student.setName("John");
        student.setEmail("john@example.com");
        student.setAge(20);
        studentService.addStudent(student);
        assertEquals(initialSize + 1, studentService.getAllStudents().size());
    }
}
