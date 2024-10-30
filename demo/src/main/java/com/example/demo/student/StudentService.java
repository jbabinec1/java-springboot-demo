package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
        //return List.of(new Student(1L, "Jared", "Jared@email.com", 31, LocalDate.of(1993, Month.JULY, 19)  ));
    }

    public void addNewStudent(Student student) {
      Optional<Student> studentOptional =  studentRepository.findStudentByEmail(student.getEmail());

      if(studentOptional.isPresent()) {
          throw new IllegalStateException("Email taken");
      }
        studentRepository.save(student);
    }
}
