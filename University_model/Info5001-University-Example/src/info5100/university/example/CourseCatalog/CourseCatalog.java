/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {
    Department department;
    String lastupdated;
    ArrayList<Course> courselist; 
    public CourseCatalog(Department d){
        courselist = new ArrayList();
        department = d;
    }
    
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    public Course newCourse(String n, String nm, int cr){
        Course c = new Course(n, nm, cr);
        courselist.add(c);
        return c;
    }
    
    public Course getCourseByNumber(String n){
        
        for( Course c: courselist){
//             System.out.println("asdadsa "+ c.getCOurseNumber());
            if(c.getCOurseNumber().equals(n)) return c;
        }
        return null;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public void setCourselist(ArrayList<Course> courselist) {
        this.courselist = courselist;
    }
    
    public void showCourseCatalog(){
        System.out.println("------Showing All Courses------");
        for (Course c : courselist){
            System.out.println("Course Name :"+c.getName());
            System.out.println("Course Number :"+c.getNumber());
            System.out.println("Course Price :"+c.getPrice());
            System.out.println("Course Credits :"+c.getCredits());
            System.out.println("");
        }
    }
  

}