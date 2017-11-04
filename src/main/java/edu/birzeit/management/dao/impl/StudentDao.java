package edu.birzeit.management.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import edu.birzeit.management.dao.interfaces.IStudentDao;
import edu.birzeit.management.entities.Student;

/**
 * This is a data access layer class
 * Stands for M in MVC
 * @author arouri
 *
 */
public class StudentDao implements IStudentDao {

	private Map<String, Student> students;

	public StudentDao() {

		this.students = StudentRepository.getInstance().loadStudents();
	}

	@Override
	public boolean updateStudent(Student student) {

		Student currentStudent = this.students.get(student.getId());
		if (currentStudent == null) {
			System.out.println("Student: " + student.getId() + " was not found!!");
			return false;
		}

		students.put(student.getId(), student);
		StudentRepository.getInstance().saveStudents(students.values());

		return true;
	}

	@Override
	public void deleteStudent(Student student) {

		Student currentStudent = this.students.get(student.getId());
		if (currentStudent == null) {
			System.out.println("Student: " + student.getId() + " was not found!!");
			return;
		}

		students.remove(student.getId());
		StudentRepository.getInstance().saveStudents(students.values());
		
	}

	@Override
	public List<Student> getStudents() {
		return new ArrayList<Student>(this.students.values());
	}

	@Override
	public void createStudent(Student student) {

		String uniqueID = UUID.randomUUID().toString();
		student.setId(uniqueID);
		
		this.students.put(uniqueID, student);
		StudentRepository.getInstance().saveStudents(students.values());
	}
}
