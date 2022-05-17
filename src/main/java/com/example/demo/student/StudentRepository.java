// Everything here is for Data Access Layer for Spring framework
// We use the repository to handle the SQL stuff

package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository 
        extends JpaRepository<Student,Long> {
    // This query applies to the method it annotates
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
