package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    // The reason we have a studentService instead of 
    // doing all logic here is for Service Layer in Spring
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    // Our GET request, uses studentService to keep things at
    // the service layer
    @GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

    // Our POST request is used to add new resources from client,
    // in this case a new student
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    // Our DELETE request is used to delete students from client
    // Goes by ID
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    // Our PUT request is used to update students from client
    // Goes by ID
    @PutMapping(path = "{studentId}")
    public void updateStudent(
        @PathVariable("studentId") Long id,
        @RequestBody Student student) {
        studentService.updateStudent(id,student.getName(), student.getEmail(),student.getDob());
    }
}
