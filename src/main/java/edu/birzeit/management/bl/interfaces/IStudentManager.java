package edu.birzeit.management.bl.interfaces;

import java.util.List;

import edu.birzeit.management.entities.Student;

/**
 * @author arouri
 *
 */
public interface IStudentManager {

	/**
	 * Update student
	 * @param student
	 * @return
	 */
	public boolean updateStudent(Student student);

	/**
	 * 
	 * @param student
	 */
	public void deleteStudent(Student student);

	/**
	 * @return
	 */
	public List<Student> getStudents();

	/**
	 * @param student
	 */
	public void createStudent(Student student);
}
