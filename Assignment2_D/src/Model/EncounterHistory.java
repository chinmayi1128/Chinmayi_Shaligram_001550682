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
public class EncounterHistory {
    private ArrayList<Encounter> encounterHistory;

    public EncounterHistory(){
        this.encounterHistory = new ArrayList<Encounter>();
    }
    public ArrayList<Encounter> getEncounterHistory() {
        return encounterHistory;
    }

    public void setEncounterHistory(ArrayList<Encounter> encounterHistory) {
        this.encounterHistory = encounterHistory;
    }
    
    public Encounter addNewEncounters(){
        Encounter ec = new Encounter();
        encounterHistory.add(ec);
        return ec;
    }
    
    public void showAllEncounterHistory(){
        System.out.println("Encounter History:");
        for(Encounter en: encounterHistory){
            System.out.println("Display Encounter:");
            System.out.println("Doctor : "+ en.getDoctorName());
            System.out.println("Encounter Date : "+en.getDate());
            System.out.println("Vital Sign model: "+en.getVs());
            System.out.println("Vital Sign Details:");
            
            System.out.println("******************");
            System.out.println("Blood pressure : "+en.getVs().getBlood_Pressure());
            System.out.println("Date : "+en.getVs().getDate());
            System.out.println("Heart Rate : "+en.getVs().getHeart_Rate());
            System.out.println("Repiratory Rate : "+en.getVs().getRespiratory_Rate());
            System.out.println("Weight in Kg : "+en.getVs().getWt_Kg());
            System.out.println("Weight in Pounds : "+en.getVs().getWt_Pound());
            System.out.println("*******************");
        }
        System.out.println("End Of Encounter History");
      
    }
}

   
