package edu.birzeit.management.entities;

import java.util.List;

/**
 * @author arouri
 *
 */
public class Student {

	// UUID
	private String id;
	
	private String name;
	
	private List<Course> courses;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", courses=" + courses + "]";
	}
}
