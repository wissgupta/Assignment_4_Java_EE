package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Redirect root to /students
    @GetMapping("/")
    public String redirectToStudents() {
        return "redirect:/students";
    }

    // Show all students
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    // Show form to add a student
    @GetMapping("/new")
    public String showForm(Student student) {
        return "new-student";
    }

    // Save new student with validation
    @PostMapping("/save")
    public String saveStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-student";
        }
        studentService.addStudent(student);
        return "redirect:/students";
    }

    // Delete a student by ID
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    // Export students as JSON
    @GetMapping("/json")
    @ResponseBody
    public List<Student> exportStudents() {
        return studentService.getAllStudents();
    }
}
