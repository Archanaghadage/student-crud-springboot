package com.tka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Entity.StudentEntity;
import com.tka.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<StudentEntity> getAllStudents() {
		return studentRepository.findAll();
	}

	 @Override
	    public StudentEntity getStudentById(Long id) {
	        Optional<StudentEntity> student = studentRepository.findById(id);
	        return student.orElse(null);   
	    }

	@Override
	public StudentEntity addStudent(StudentEntity student) {
		return studentRepository.save(student);
	}

	@Override
	public StudentEntity updateStudent(Long id, StudentEntity student) {

        Optional<StudentEntity> existingOpt = studentRepository.findById(id);

        if (existingOpt.isPresent()) {
            StudentEntity existing = existingOpt.get();
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setCourse(student.getCourse());
            existing.setAge(student.getAge());

            return studentRepository.save(existing);
        }

        return null;
    }

	  @Override
	    public void deleteStudent(Long id) {
	        if (studentRepository.existsById(id)) {
	            studentRepository.deleteById(id);
	        }
	    }
}
