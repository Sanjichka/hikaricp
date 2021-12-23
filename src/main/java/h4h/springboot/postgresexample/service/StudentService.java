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

    //int i=0;
    public void postStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents() throws SQLException {
        String SQL_QUERY = "select * from student";
        List<Student> students = null;
        //i++;
        /*try{
            if(i>4) {
                throw new CustomExc("Max!!!"+i);
            }

        } catch (CustomExc e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }*/
//
//        try  (
//                Connection con = dataSource.getConnection();
////                PreparedStatement pst = con.prepareStatement( SQL_QUERY );
////                ResultSet rs = pst.executeQuery();
//                ){
//
//            try( Connection con1 = dataSource.getConnection();
////                 PreparedStatement pst1 = con1.prepareStatement( SQL_QUERY );
////                 ResultSet rs1 = pst1.executeQuery();
//                 ) {
//                try( Connection con2 = dataSource.getConnection();
////                     PreparedStatement pst2 = con2.prepareStatement( SQL_QUERY );
////                     ResultSet rs2 = pst2.executeQuery();
//                     ) {
//                    try( Connection con3 = dataSource.getConnection();
////                         PreparedStatement pst3 = con3.prepareStatement( SQL_QUERY );
////                         ResultSet rs3 = pst3.executeQuery();
//                         ) {
//                        try( Connection con4 = dataSource.getConnection();
//                             PreparedStatement pst4 = con4.prepareStatement( SQL_QUERY );
//                             ResultSet rs4 = pst4.executeQuery();) {
//                            students = new ArrayList<>();
//                            Student student;
//                            while ( rs4.next() ) {
//                                student = new Student();
//                                student.setId( rs4.getLong( "id" ) );
//                                student.setName( rs4.getString( "name" ) );
//                                students.add( student );
//                            }
//
//                        }
////                        catch(Exception e) {
////                            e.printStackTrace();
////                        }
//                    }
//                }
//            }



            //TimeUnit.SECONDS.sleep(30);
            //i--;


//        }
//        catch(SQLException e){
//            e.printStackTrace();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        func();

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



}