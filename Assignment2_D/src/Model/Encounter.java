/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author chinmayi_shaligram
 */
public class Encounter {
    
    private String DoctorName;
    private String Date;
    VitalSigns vs;

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public VitalSigns getVs() {
        return vs;
    }

    public void setVs(VitalSigns vs) {
        this.vs = vs;
    }
    
     public Encounter(){
        this.vs = new VitalSigns();
    }
     
    public void showEncounter(){
       System.out.println("Display Encounter:");
       System.out.println("Doctor Name:" +getDoctorName());
       System.out.println("Encounter Date:" +getDate());
       System.out.println("Vital Sign::" +getVs());
       
    }
    
}
