package edu.birzeit.swen6305.devops;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/student")
class StudentService{

   @RequestMapping(value="/",method = RequestMethod.GET)
   public HashMap<Long,Student> getAllStudents(){
      return DevopsApplication.hmStudent;
   }
   
   
   @RequestMapping(value="/add",method = RequestMethod.POST)
   public Student addStudent(@RequestParam(value="name") String name
         ,@RequestParam(value="subject",defaultValue = "unknown") String subject){

      Student student=new Student(name,subject);
      DevopsApplication.hmStudent.put(new Long(student.getId()),student);
      return student;

   }
   
   
   @RequestMapping(value="/update",method = RequestMethod.PUT)
   public Student updateStudent(@RequestBody Student student) throws Exception {
    
      if(DevopsApplication.hmStudent.containsKey(new Long(student.getId()))){
    	  DevopsApplication.hmStudent.put(new Long(student.getId()),student);
      }else{
         throw new Exception("Student "+student.getId()+" does not exists");
      }
    
      return student;
   }
   
   @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
   public Student deleteStudent(@PathVariable long id) throws Exception {
    
      Student student;
    
      if(DevopsApplication.hmStudent.containsKey(new Long(id))){
         student=DevopsApplication.hmStudent.get(new Long(id));
         DevopsApplication.hmStudent.remove(new Long(id));
      }else{
         throw new Exception("Student "+id+" does not exists");
      }
      return student;
   }
   
   @RequestMapping(value="/{id}",method = RequestMethod.GET)
   public Student getStudent(@PathVariable long id){
      return DevopsApplication.hmStudent.get(new Long(id));
   }
}
