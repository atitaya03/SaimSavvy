package siamsavvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import siamsavvy.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
