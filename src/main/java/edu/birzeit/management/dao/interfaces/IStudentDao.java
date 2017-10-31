package edu.birzeit.management.dao.interfaces;

import edu.birzeit.management.entities.Student;

/**
 * @author arouri
 *
 */
public interface IStudentDao {

	/**
	 * Update student
	 * @param student
	 * @return
	 */
	public boolean updateStudent(Student student);
}
