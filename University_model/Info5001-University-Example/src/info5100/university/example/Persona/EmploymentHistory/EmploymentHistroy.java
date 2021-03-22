 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.EmploymentHistory;

import info5100.university.example.CourseSchedule.CourseOffer;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmploymentHistroy {
    ArrayList<Employment> employments;
    public EmploymentHistroy(){
        employments = new ArrayList();
    }
    
    public Employment newEmployment(String job, ArrayList<CourseOffer> relevantcourseofferss){
        Employment ne = new Employment(job, relevantcourseofferss);
        employments.add(ne);
        return ne;
    }
    
    public void showEmployment(){
        System.out.println("----Showing Employemnt----");
        for (Employment e : getEmployments()){
            System.out.println("Job Details: "+e.getJob());
            e.showRelevantcourseoffers();
        }
    }

    public ArrayList<Employment> getEmployments() {
        return employments;
    }
    
}
