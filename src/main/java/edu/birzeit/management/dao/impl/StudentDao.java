package edu.birzeit.management.dao.impl;

import java.util.Map;

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
}
