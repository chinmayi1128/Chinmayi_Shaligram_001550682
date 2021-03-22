/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.EmploymentHistory;

import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.Employer.EmployerProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Employment {
    ArrayList<CourseOffer> relevantcourseoffers;
    int weight;
    String quality;
    String job;
    Employment nextemplyment;  //next job so they are in a sequence 
    
    EmployerProfile employer;
    public Employment(String j, ArrayList<CourseOffer> relevantcourseoffers){
        relevantcourseoffers = new ArrayList();
        this.job = j;
        this.relevantcourseoffers = relevantcourseoffers;
    }

    public ArrayList<CourseOffer> getRelevantcourseoffers() {
        return relevantcourseoffers;
    }

    public String getJob() {
        return job;
    }
    
    public void showRelevantcourseoffers(){
        System.out.println("showing relevant courses");
        for (CourseOffer co : getRelevantcourseoffers()){
            System.out.println("Course Name : "+co.getCourse().getName());
        }
    }
    

}
