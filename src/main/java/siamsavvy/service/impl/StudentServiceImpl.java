package siamsavvy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siamsavvy.model.Student;
import siamsavvy.repository.StudentRepository;
import siamsavvy.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> getAllStudent() {
        List<Student> listStudents = repository.findAll();
        return listStudents;
    }

}
