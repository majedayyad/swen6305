package edu.birzeit.management.bl.impl;

import java.util.List;

import edu.birzeit.management.bl.interfaces.IStudentManager;
import edu.birzeit.management.dao.impl.StudentDao;
import edu.birzeit.management.dao.interfaces.IStudentDao;
import edu.birzeit.management.entities.Student;

/**
 * This is a business logic class
 * Stands for C in MVC
 * @author arouri
 *
 */
public class StudentManager implements IStudentManager {

	@Override
	public boolean updateStudent(Student student) {

		IStudentDao studentDao = new StudentDao();
		return studentDao.updateStudent(student);
	}

	@Override
	public void deleteStudent(Student student) {

		IStudentDao studentDao = new StudentDao();
		studentDao.deleteStudent(student);
	}

	@Override
	public List<Student> getStudents() {
		IStudentDao studentDao = new StudentDao();
		return studentDao.getStudents();
	}

	@Override
	public void createStudent(Student student) {
		
		IStudentDao studentDao = new StudentDao();
		studentDao.createStudent(student);
	}

}
