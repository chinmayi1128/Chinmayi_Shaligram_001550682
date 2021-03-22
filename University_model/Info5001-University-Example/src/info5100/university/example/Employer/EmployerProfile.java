/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Employer;

import info5100.university.example.Persona.EmploymentHistory.Employment;
import java.util.ArrayList;

/**
 *   
 * 
 * 
 * @author kal bugrara
 */
public class EmployerProfile {
    String name;
    String employerID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployerID() {
        return employerID;
    }

    public void setEmployerID(String employerID) {
        this.employerID = employerID;
    }
    
    ArrayList<Employment> employments;
    double maxSalary;
    double minSalary;
    int fortuneRanking;
    public EmployerProfile(String n, String employerID){  //could be company instead of just a name as a string
        name = n;
        this.employerID = employerID;
        
    }
         public boolean isMatch(String id){
        if(name.equals(id)) return true;             //String is an object and can do equal matach
        return false;
    }
    
}
