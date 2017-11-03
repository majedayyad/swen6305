package edu.birzeit.management.api;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StudentInitializer implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {

		try {

			File file = new File("student.txt");
			if (!file.exists()) {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				file.createNewFile();
				// get the content in bytes
				List<String> lines = new ArrayList<>();
				lines.add(
						"{\"id\":\"c05e932c-bdcf-11e7-abc4-cec278b6b50a\",\"name\":\"Ahmad Mahmoud\",\"courses\":[{\"id\":\"SWEN6305\",\"name\":\"Project Managment\"}]}");
				lines.add(
						"{\"id\":\"c05e9660-bdcf-11e7-abc4-cec278b6b50a\",\"name\":\"Hamada Abu Hamde\",\"courses\":[{\"id\":\"SWEN6305\",\"name\":\"Project Managment\"}]}");
				lines.add(
						"{\"id\":\"c05e978c-bdcf-11e7-abc4-cec278b6b50a\",\"name\":\"Hamoodeh Abu Hamdan\",\"courses\" :[{\"id\":\"SWEN6305\",\"name\":\"Project Managment\"}]}");

				String resultLine = lines.stream().map(e -> e.toString() + " \n").reduce("", String::concat);
				byte[] contentInBytes = resultLine.getBytes();

				fileOutputStream.write(contentInBytes);
				fileOutputStream.flush();
				fileOutputStream.close();
			}
			System.out.println("PATH: " + file.getAbsolutePath());

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}