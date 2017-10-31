package edu.birzeit.management.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
	 * The request has the shape of PUT /students/{id}
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get student id
		String pathInfo = request.getPathInfo();
		String[] pathParts = pathInfo.split("/");
		String id = pathParts[1];
		
		// Get student request body
		String body = this.getBody(request);
		Student student = JsonConverter.convertToObject(body, Student.class);
		student.setId(id);
		System.out.println(student);
		
		// Call component to handle the student
		IStudentManager studentManager = new StudentManager();
		studentManager.updateStudent(student);
		
		// Print success message
		PrintWriter out = response.getWriter();
		Status status = new Status();
		status.setStatus(StatusCode.SUCCESS);
		out.println(JsonConverter.convertToJson(status));
		response.setContentType("application/json");
	}

	public void destroy() {

	}

	/**
	 * Read request body
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String getBody(HttpServletRequest request) throws IOException {

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();
		return body;
	}

}
