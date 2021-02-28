
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

public class PatientDirectory {
    private ArrayList<Patients> PatientDirectory;

    public PatientDirectory(){
        this.PatientDirectory = new ArrayList<Patients>();
    }
    public ArrayList<Patients> getPatientDirectory() {
        return PatientDirectory;
    }

    public void setPatientDirectory(ArrayList<Patients> PatientDirectory) {
        this.PatientDirectory = PatientDirectory;
    }
    
    public void showAllPatients(){
        System.out.println("Showing all Patients:"+PatientDirectory );
        for(Patients pat: PatientDirectory){
            System.out.println("Patient's Name : "+pat);
            System.out.println("Patient's Name : "+pat.getName());
        }
    }
    
    public Patients addNewPatient(){
        Patients patients = new Patients();
        PatientDirectory.add(patients);
        System.out.println("Patient Directory : "+PatientDirectory);
        return patients;
    }
    
}
