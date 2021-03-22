/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import info5100.university.example.CourseSchedule.CourseLoad;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Transcript {
    
    
    HashMap<String, CourseLoad> courseloadlist;
    
    CourseLoad currentcourseload;
    
    public Transcript(){
        
        courseloadlist = new HashMap<String, CourseLoad>();
        
    }
    
    public CourseLoad newCourseLoad(String sem){
        
        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }
    
    public CourseLoad getCurrentCourseLoad(){
        
        return currentcourseload;
        
    }
        public CourseLoad getCourseLoadBySemester(String semester){
        
        return courseloadlist.get(semester);
        
    }
    
        public double getTotalGPA(){
            CourseLoad cl_Fall = getCourseLoadBySemester("Fall2020");
            CourseLoad cl_Spring = getCourseLoadBySemester("Spring2020");
            
            if (cl_Fall != null && cl_Spring != null) {
                return (cl_Fall.getAvgGpaBySemester() + cl_Spring.getAvgGpaBySemester())/2;
            }
            else if (cl_Fall != null){
                return cl_Fall.getAvgGpaBySemester();
            }
            else if (cl_Spring != null){
                return cl_Spring.getAvgGpaBySemester();
            }
            return 0.0;
            
        }
        
        public double getFacultyRating(){
            CourseLoad cl_Fall = getCourseLoadBySemester("Fall2020");
            CourseLoad cl_Spring = getCourseLoadBySemester("Spring2020");
            
            if (cl_Fall != null && cl_Spring != null) {
                return (cl_Fall.getAvgFacultyRatingBySemester() + cl_Spring.getAvgFacultyRatingBySemester())/2;
            }
            else if (cl_Fall != null){
                return cl_Fall.getAvgFacultyRatingBySemester();
            }
            else if (cl_Spring != null){
                return cl_Spring.getAvgFacultyRatingBySemester();
            }
            return 0.0;
            
        }
        
        public double getCourseRating(){
            CourseLoad cl_Fall = getCourseLoadBySemester("Fall2020");
            CourseLoad cl_Spring = getCourseLoadBySemester("Spring2020");
            
            if (cl_Fall != null && cl_Spring != null) {
                return (cl_Fall.getAvgCourseRatingBySemester() + cl_Spring.getAvgCourseRatingBySemester())/2;
            }
            else if (cl_Fall != null){
                return cl_Fall.getAvgCourseRatingBySemester();
            }
            else if (cl_Spring != null){
                return cl_Spring.getAvgCourseRatingBySemester();
            }
            return 0.0;
            
        }
        
        public double getUniversityRating(){
            double UniversityRating = (getCourseRating() * 50/100 + getFacultyRating() *20/100 + getTotalGPA() *30/100 )/3;
            return UniversityRating;
            
        }
}
