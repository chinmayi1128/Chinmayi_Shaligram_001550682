/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {
    String semester;
    ArrayList<SeatAssignment> seatassignments;
    
    public CourseLoad(String s){
        seatassignments = new ArrayList<SeatAssignment>();
        semester = s;
    }
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatAssignment sa = seat.newSeatAssignment();
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){
        
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
    
    public void showCourseLoad(){
        System.out.println("-----Displaying Course Load -------");
     for (SeatAssignment sa: seatassignments){
         System.out.println("Course Name :" +sa.getSeat().getCourseoffer().getCourse().getName());
         System.out.println("Faculty Name :" +sa.getSeat().getCourseoffer().getFacultyProfile().getPerson().getName());
     }
}

    public ArrayList<SeatAssignment> getSeatassignments() {
        return seatassignments;
    }
    
    public double getAvgGpaBySemester(){
        double AvgGpaBySemester = 0.0;
        for (SeatAssignment sa: seatassignments){
            AvgGpaBySemester += (sa.getSeat().getCourseoffer().getCourse().getGpa())/seatassignments.size();
        }
        return AvgGpaBySemester;
    }
    
    public double getAvgFacultyRatingBySemester(){
        double AvgFacultyRatingBySemester = 0.0;
        for (SeatAssignment sa: seatassignments){
            AvgFacultyRatingBySemester += (sa.getSeat().getCourseoffer().getFacultyProfile().getFacultyRating())/seatassignments.size();
        }
        return AvgFacultyRatingBySemester;
    }
    
    public double getAvgCourseRatingBySemester(){
        double AvgCourseRatingBySemester = 0.0;
        for (SeatAssignment sa: seatassignments){
            AvgCourseRatingBySemester += (sa.getSeat().getCourseoffer().getCourse().getIndustrialImportanceRating())/seatassignments.size();
        }
        return AvgCourseRatingBySemester;
    }
    
}
