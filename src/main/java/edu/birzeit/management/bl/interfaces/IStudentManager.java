package edu.birzeit.management.bl.interfaces;

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
}
