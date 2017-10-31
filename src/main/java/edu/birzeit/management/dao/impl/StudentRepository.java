package edu.birzeit.management.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import edu.birzeit.management.entities.Student;
import edu.birzeit.management.utils.JsonConverter;

/**
 * @author arouri
 *
 */
public class StudentRepository {

	private static final String FILE_NAME = "student.txt";

	private StudentRepository() {

	}

	/**
	 * 
	 */
	private static StudentRepository instance = null;

	/**
	 * @return
	 */
	public static StudentRepository getInstance() {
		if (instance == null) {
			instance = new StudentRepository();
		}
		return instance;
	}

	/**
	 * load student list from a file
	 * @return
	 */
	public Map<String, Student> loadStudents() {

		Map<String, Student> students = new HashMap<>();

		try {

			BufferedReader bufferedReader = null;
			FileReader fileReader = null;

			try {
				fileReader = new FileReader(FILE_NAME);
				bufferedReader = new BufferedReader(fileReader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println("Loaded record: " + line);
					Student student = JsonConverter.convertToObject(line, Student.class);
					students.put(student.getId(), student);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bufferedReader != null)
						bufferedReader.close();
					if (fileReader != null)
						fileReader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return students;
	}

	/**
	 * Save student list to a file
	 * @param students
	 */
	public void saveStudents(Collection<Student> students) {

		try {
			List<String> lines = students.stream().map(s -> JsonConverter.convertToJson(s))
					.collect(Collectors.toList());

			File file = new File(FILE_NAME);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			String resultLine = lines.stream().map(e -> e.toString() + " \n").reduce("", String::concat);
			byte[] contentInBytes = resultLine.getBytes();

			fileOutputStream.write(contentInBytes);
			fileOutputStream.flush();
			fileOutputStream.close();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
