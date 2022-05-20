package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This is to keep things at the service layer
@Service
public class StudentService {
    
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	// For GET request
    public List<Student> getStudents() {
		return studentRepository.findAll();
    }

	// For POST request
    public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository
				.findStudentByEmail(student.getEmail());
		// if student's email is already used, exception throw
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
    }

	// For DELETE request
	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException(
				"student with id " + studentId + " does not exist");
		}
		studentRepository.deleteById(studentId);
	}

	// For PUT request
	// Transactional handles the transaction without us needing
	// to use a query
	@Transactional
	public void updateStudent(Long studentId, String name, String email, LocalDate dob)
	{
		Student student = studentRepository.findById(studentId)
			.orElseThrow(() -> new IllegalStateException(
				"student with id " + studentId + " does not exist"));

		if (email != null &&
			email.length() > 0 &&
			!Objects.equals(student.getEmail(),email)) {
				Optional<Student> studentOptional = studentRepository
					.findStudentByEmail(email);
		// if student's email is already used, exception throw
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
		
		if (name != null &&
				name.length() > 0 &&
				!Objects.equals(student.getName(),name)) {
					student.setName(name);
				}
		
				System.out.println(dob);
		if (dob != null)
		{
			student.setDob(dob);
		}
	}

}