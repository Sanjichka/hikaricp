package h4h.springboot.postgresexample.controller;

import h4h.springboot.postgresexample.model.Student;
import h4h.springboot.postgresexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

//    @GetMapping("/students")
//    public List<Student> getStudents() {
//        return studentService.getStudents();
//    }

    @PostMapping("/postStudent")
    public void postStudent(@RequestParam long id, @RequestParam String name){
        Student student = new Student(id, name);
        studentService.postStudent(student);}

    @GetMapping("/students/test")
    public List<Student> getStudents() throws SQLException {
        return studentService.getStudents();
    }

    @GetMapping("/students")
    public void getTest(){
        studentService.getTest();
    }

    @GetMapping("/students1")
    public void getTest1(){
        studentService.getTest1();
    }


}
