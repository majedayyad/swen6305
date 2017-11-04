package edu.birzeit.management.dao.interfaces;

import java.util.List;

import edu.birzeit.management.entities.Student;

/**
 * @author arouri
 *
 */
public interface IStudentDao {

	/**
	 * Update student
	 * 
	 * @param student
	 * @return
	 */
	public boolean updateStudent(Student student);

	/**
	 * @param student
	 */
	public void deleteStudent(Student student);

	/**
	 * @return 
	 * 
	 */
	public List<Student> getStudents();

	/**
	 * @param student
	 * @return
	 */
	public void createStudent(Student student);
}
