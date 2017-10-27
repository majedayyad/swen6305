package edu.birzeit.swen6305.devops;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevopsApplication {
	public static HashMap<Long,Student> hmStudent;
	public static void main(String[] args) {
		hmStudent=new HashMap<Long,Student>();
		 
	      Student one=new Student("Sami","math");
	      hmStudent.put(new Long(one.getId()),one);
	     
		SpringApplication.run(DevopsApplication.class, args);
		 Student two=new Student("Ibrahim","history");
	      hmStudent.put(new Long(two.getId()),two);
	}
}
