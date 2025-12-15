package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Entity.StudentEntity;
import com.tka.repository.StudentRepository;
import com.tka.service.StudentService;

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
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public StudentEntity addStudent(StudentEntity student) {
		return studentRepository.save(student);
	}

	@Override
	public StudentEntity updateStudent(Long id, StudentEntity student) {

		StudentEntity existing = studentRepository.findById(id).orElse(null);

		if (existing != null) {
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
		studentRepository.deleteById(id);
	}
}
