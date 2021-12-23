package h4h.springboot.postgresexample.service;

import ch.qos.logback.classic.Logger;
import h4h.springboot.postgresexample.CustomExc;
import h4h.springboot.postgresexample.model.Student;
import h4h.springboot.postgresexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.sql.DataSource;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    DataSource dataSource;

//    public List<Student> getStudents() {
//        return studentRepository.findAll();
//    }

    int i=0;
    public void postStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents() throws SQLException{
        String SQL_QUERY = "select * from student";
        List<Student> students = null;

        try{
            if(i==4) {
                throw new CustomExc("Max!!!");
            }

        } catch (CustomExc e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try  (
                Connection con = dataSource.getConnection();
                PreparedStatement pst = con.prepareStatement( SQL_QUERY );
                ResultSet rs = pst.executeQuery();
                ){
                    i++;
                    students = new ArrayList<>();
                    Student student;
                    while ( rs.next() ) {
                        student = new Student();
                        student.setId( rs.getLong( "id" ) );
                        student.setName( rs.getString( "name" ) );
                        students.add( student );
                    }
                    TimeUnit.SECONDS.sleep(30);
                    i--;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void func() {

        try(
            Connection conn = dataSource.getConnection();
        ){
            func();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void getTest() {
        func();
    }

    public void getTest1() {

        try (
                Connection con = dataSource.getConnection();
        ) {

            try (Connection con1 = dataSource.getConnection();
            ) {
                try (Connection con2 = dataSource.getConnection();
                ) {
                    try (Connection con3 = dataSource.getConnection();
                    ) {
                        try (Connection con4 = dataSource.getConnection();) {

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}