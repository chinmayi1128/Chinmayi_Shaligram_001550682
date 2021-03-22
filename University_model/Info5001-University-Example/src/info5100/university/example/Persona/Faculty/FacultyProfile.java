/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.Persona.*;
import info5100.university.example.CourseSchedule.CourseOffer;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyProfile {

    Person person;
    ArrayList <FacultyAssignment> facultyassignments; 
    double facultyRating;
    String jobType;
    int numberOfTrainingsPerYear;
    String specialization;

    public FacultyProfile(Person p) {

        person = p;
        facultyassignments = new ArrayList();
    }
    
     public FacultyProfile(Person p, double facultyRating, String jobType, int numberOfTrainingsPerYear, String specialization) {

        person = p;
        this.facultyRating = facultyRating;
        this.jobType = jobType;
        this.numberOfTrainingsPerYear = numberOfTrainingsPerYear;
        this.specialization = specialization;
        facultyassignments = new ArrayList();
    }
    

    public FacultyAssignment AssignAsTeacher(CourseOffer co){
        
        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyassignments.add(fa);
        
        return fa;
    }
    
    public FacultyProfile getCourseOffer(String courseid){
        return null; //complete it later
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public Person getPerson() {
        return person;
    }

    public double getFacultyRating() {
        return facultyRating;
    }

    public String getJobType() {
        return jobType;
    }

    public int getNumberOfTrainingsPerYear() {
        return numberOfTrainingsPerYear;
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<FacultyAssignment> getFacultyassignments() {
        return facultyassignments;
    }

    public void showFacultyAssignments(){
        System.out.println("-----Showing Course Taught By Faculty------");
        for  (FacultyAssignment fa : getFacultyassignments()){
            System.out.println("Course Name : "+ fa.getCourseoffer().getCourse().getName());
            
        }
    }
    
}
