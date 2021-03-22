/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList();
        
    }

    public CourseOffer newCourseOffer(String n) {

        Course c = coursecatalog.getCourseByNumber(n);
        CourseOffer co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        for (CourseOffer co : schedule) {

            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }
    
    public void showCourseSchedule(){
        System.out.println("------Showing All Courses Schedule------");
        for (CourseOffer co : schedule){
            System.out.println("Course Name :"+co.getCourse().getName());
            System.out.println("Course Faculty ID: "+co.getFacultyProfile().getPerson().getPersonId());
            System.out.println("Course Faculty Name: "+co.getFacultyProfile().getPerson().getName() );
            System.out.println("Course Empty Seats : "+co.getEmptySeatNumber());
            System.out.println("Course Seat List : "+co.getFilledSeactNumber());
            System.out.println("");
        }
    }


}
