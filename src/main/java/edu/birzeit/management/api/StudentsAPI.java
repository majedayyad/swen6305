package edu.birzeit.management.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.birzeit.management.bl.impl.StudentManager;
import edu.birzeit.management.bl.interfaces.IStudentManager;
import edu.birzeit.management.entities.Status;
import edu.birzeit.management.entities.Student;
import edu.birzeit.management.entities.Status.StatusCode;
import edu.birzeit.management.utils.JsonConverter;

public class StudentsAPI extends HttpServlet {

	private static final long serialVersionUID = 4232113164111956358L;

	/*
	 * TODO:// Team Smartees-1
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Call component to handle the student
		IStudentManager studentManager = new StudentManager();
		List<Student> students = studentManager.getStudents();

		// Print response message
		PrintWriter out = response.getWriter();
		out.println(JsonConverter.convertToJson(students));
		response.setContentType("application/json");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get student request body
		String body = RestUtil.getBody(request);
		Student student = JsonConverter.convertToObject(body, Student.class);
		System.out.println(student);

		// Call component to handle the student
		IStudentManager studentManager = new StudentManager();
		studentManager.createStudent(student);

		// Print response message
		PrintWriter out = response.getWriter();
		Status status = new Status();
		status.setStatus(StatusCode.SUCCESS);
		out.println(JsonConverter.convertToJson(status));
		response.setContentType("application/json");
	}

	public void destroy() {

	}

}