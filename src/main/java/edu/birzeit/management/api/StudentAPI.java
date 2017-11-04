package edu.birzeit.management.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.birzeit.management.bl.impl.StudentManager;
import edu.birzeit.management.bl.interfaces.IStudentManager;
import edu.birzeit.management.entities.Status;
import edu.birzeit.management.entities.Status.StatusCode;
import edu.birzeit.management.entities.Student;
import edu.birzeit.management.utils.JsonConverter;

public class StudentAPI extends HttpServlet {

	private static final long serialVersionUID = 4976855131174170973L;

	/*
	 * TODO:// Team Exterminators Delete existing Student
	 */
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get student id
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		String id = pathParts[1];
		Student student = new Student();
		student.setId(id);

		// Call component to handle the student
		IStudentManager studentManager = new StudentManager();
		studentManager.deleteStudent(student);

		// Print response message
		PrintWriter out = response.getWriter();
		Status status = new Status();
		status.setStatus(StatusCode.SUCCESS);
		out.println(JsonConverter.convertToJson(status));
		response.setContentType("application/json");

	}

	/*
	 * TODO:// Team Infinity Create new Student
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	/*
	 * The request has the shape of PUT /students/{id} This is for aplpha team
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get student id
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		String id = pathParts[1];

		// Get student request body
		String body = RestUtil.getBody(request);
		Student student = JsonConverter.convertToObject(body, Student.class);
		student.setId(id);
		System.out.println(student);

		// Call component to handle the student
		IStudentManager studentManager = new StudentManager();
		boolean isSuccess = studentManager.updateStudent(student);

		// Print response message
		PrintWriter out = response.getWriter();
		Status status = new Status();
		status.setStatus(isSuccess ? StatusCode.SUCCESS : StatusCode.FAILURE);
		out.println(JsonConverter.convertToJson(status));
		response.setContentType("application/json");
	}

	public void destroy() {

	}

}
