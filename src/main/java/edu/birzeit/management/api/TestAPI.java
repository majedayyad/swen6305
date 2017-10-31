package edu.birzeit.management.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAPI extends HttpServlet {

	private static final long serialVersionUID = 2517450610246182871L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("{\"status\" : \"Success\"}");

		// Set response content type
		response.setContentType("text/html;charset=UTF-8");
	}

	public void destroy() {

	}
}
