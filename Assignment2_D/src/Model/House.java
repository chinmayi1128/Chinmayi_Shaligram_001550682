/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author chinmayi_shaligram
 */
public class House {
    private int AptNumber;
    private String Street;
    private ArrayList<Patients> PatientInHome;
    
    public House(int AptNumber, String Street, ArrayList<Patients> patients1){
        this.AptNumber = AptNumber;
        this.Street = Street;
        this.PatientInHome = new ArrayList<Patients>();
        this.PatientInHome = patients1;
        
    }

    public int getAptNumber() {
        return AptNumber;
    }

    public void setAptNumber(int AptNumber) {
        this.AptNumber = AptNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public ArrayList<Patients> getPatientInHome() {
        return PatientInHome;
    }

    public void setPatientInHome(ArrayList<Patients> PatientInHome) {
        this.PatientInHome = PatientInHome;
    }
    
        
        
}
    
