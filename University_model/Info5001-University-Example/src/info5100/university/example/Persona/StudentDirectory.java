/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {

    Department department;
    ArrayList<StudentProfile> studentlist;

    public StudentDirectory(Department d) {

        department = d;
        studentlist = new ArrayList();

    }

    public StudentProfile newStudentProfile(Person p) {

        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }

    public StudentProfile findStudent(String id) {

        for (StudentProfile sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
    }
    
    public void showStudentDirectory() {
        System.out.println("-----Showing Student Directory-----");
        for (StudentProfile sp: studentlist)
        {
            System.out.println("Student ID: "+sp.person.getPersonId());
            System.out.println("Student Name: "+sp.person.getName());
            System.out.println("");
        }
    }
    
    public void calculateStudentPerformance(){
        System.out.println("-----Displaying Student Performance-----");
        for (StudentProfile sp: studentlist){
            System.out.println("Student ID: "+sp.person.getPersonId());
            System.out.println("Student Name: "+sp.person.getName());            
            System.out.println("Student Avg Faculty Ratings : "+sp.getTranscript().getFacultyRating());      
            System.out.println("Student Avg Course Ratings : "+ sp.getTranscript().getCourseRating());      
            System.out.println("Student Avg GPA : "+ sp.getTranscript().getTotalGPA());      
            System.out.println("Student University Rating : "+ sp.getTranscript().getUniversityRating());  
            
            System.out.println("-----Student Employment Details------");
            sp.getFeedback().showFeedback();
            System.out.println("");      
        }
        
    }
}
