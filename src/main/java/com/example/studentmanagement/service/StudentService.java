package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    // Add a new student
    public void addStudent(Student student) {
        student.setId(idCounter.incrementAndGet());
        students.add(student);
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Delete student by ID
    public boolean deleteStudentById(int id) {
        return students.removeIf(student -> student.getId() == id);
    }
}
