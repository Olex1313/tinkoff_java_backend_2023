package ru.edu.ycode.service;

import lombok.RequiredArgsConstructor;
import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.ycode.model.entity.Student;
import ru.edu.ycode.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findByIdIn(List<Long> ids) {
        return studentRepository.findAllById(ids);
    }

    @Transactional
    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getId()).orElseThrow(); // email = limonov@tinkoff.ru
        existingStudent.setEmail(student.getEmail()); //  anotherEmail@tinkoff.ru
        return studentRepository.saveAndFlush(existingStudent);
    }

}
