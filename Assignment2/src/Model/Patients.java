/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.*;
import java.io.*;
/**
 *
 * @author chinmayi_shaligram
 */

public class Patients {
    
    private String Name;
    private boolean patient_s;
    private String category;
    private ArrayList<VitalSigns> History;
//    VitalSigns currentVital;
    VitalSigns vs; //current Vital Sign
    
    

    public VitalSigns getVs() {
        return vs;
    }

    public void setVs(VitalSigns vs) {
        this.vs = vs;
    }

    public Patients(){
        this.History = new ArrayList<VitalSigns>();
    }

    public ArrayList<VitalSigns> getHistory() {
        return History;
    }

    public void setHistory(ArrayList<VitalSigns> history) {
        this.History = history;
    }

    public String getName() {
        return Name;
    }

    public void setName(String fullName) {
        this.Name = Name;
    }


    public VitalSigns addNewVitals(){
        VitalSigns newVitals = new VitalSigns();
        History.add(newVitals);
        return newVitals;
    }

     public boolean isThisVitalSignNormal(VitalSigns vs, String VitalAttribute, Float VitalAttributeValue){
        this.vs = vs;
    
        if (vs.getAge() == 0){
            category = "NewBorn";
        }
        else if (0 < vs.getAge() && vs.getAge() <= 1){
            category = "Infant";
        }
        else if (1 < vs.getAge() && vs.getAge() <= 3){
            category = "Toddler";
        }
        else if (3 < vs.getAge() && vs.getAge() <= 5){
            category = "PreSchooler";
        }
        else if (6 < vs.getAge() && vs.getAge() <= 12){
            category = "SchoolAge";
        }
        else if (13 >= vs.getAge()){
            category = "Adolesent";
        }
           
        boolean VitalSignNormalStatus=false;

        if (VitalAttribute.equals("RespiratoryRateRange")){
            int intOfVitalAttributeValue = Math.round(VitalAttributeValue);
            vs.setRespiratory_Rate(intOfVitalAttributeValue);
            VitalSignNormalStatus = RespiratoryRateRange(category);
        }
        else if (VitalAttribute.equals("HeartRateRange")) {
            int intOfVitalAttributeValue = Math.round(VitalAttributeValue);
            vs.setHeart_Rate(intOfVitalAttributeValue);
            VitalSignNormalStatus = HeartRateRange(category);
        }
        else if (VitalAttribute.equals("BloodPressureRange")) {
            int intOfVitalAttributeValue = Math.round(VitalAttributeValue);
            vs.setBlood_Pressure(intOfVitalAttributeValue);
            VitalSignNormalStatus = BloodPressureRange(category);
        }
        else if (VitalAttribute.equals("WtKGRange"))  {
            VitalSignNormalStatus = WtKGRange(category);
        }
        else if (VitalAttribute.equals("WtPoundsRange"))  {
            VitalSignNormalStatus = WtPoundsRange(category);
        }
        else System.out.println("Vital Attribute not found.");
        return VitalSignNormalStatus;
    }
    
     
     public boolean isPatientNormal(VitalSigns vs){ //vs is object which has users all data
        this.vs = vs;
        
        if (vs.getAge() == 0){
            category = "NewBorn";
        }
        else if (0 < vs.getAge() && vs.getAge() <= 1){
            category = "Infant";
        }
        else if (1 < vs.getAge() && vs.getAge() <= 3){
            category = "Toddler";
        }
        else if (3 < vs.getAge() && vs.getAge() <= 5){
            category = "PreSchooler";
        }
        else if (6 < vs.getAge() && vs.getAge() <= 12){
            category = "SchoolAge";
        }
        else if (vs.getAge() >=13 ){
            category = "Adolesent";
        }
        System.out.println("patient category is this : "+category);

        if (RespiratoryRateRange(category) && HeartRateRange(category) && BloodPressureRange(category) && WtKGRange(category) && WtPoundsRange(category)) {
            patient_s= true;
        }
        return patient_s;
    }
        

    private boolean RespiratoryRateRange(String category) {

        switch(category){
            case "NewBorn":  if(30 <= vs.getRespiratory_Rate() && vs.getRespiratory_Rate() <= 50) return true;
            break;

            case "Infant":  if(20 <= vs.getRespiratory_Rate() && vs.getRespiratory_Rate() <= 30) return true;
            break;

            case "Toddler":  if(20 <= vs.getRespiratory_Rate() && vs.getRespiratory_Rate() <= 30) return true;
            break;

            case "PreSchooler":  if(20 <= vs.getRespiratory_Rate() && vs.getRespiratory_Rate() <= 30) return true;
            break;

            case "SchoolAge":  if(20 <= vs.getRespiratory_Rate() && vs.getRespiratory_Rate() <= 30) return true;
            break;

            case "Adolescent":  if(12 <= vs.getRespiratory_Rate() && vs.getRespiratory_Rate() <= 20) return true;
            break;

            default: System.out.println("Catetogry does not match");

        }
            return false;
    }

    private boolean HeartRateRange(String category) {
         switch(category){
            case "NewBorn":  if(120 <= vs.getHeart_Rate() && vs.getHeart_Rate()  <= 160) return true;
            break;

            case "Infant":  if(80 <= vs.getHeart_Rate()  && vs.getHeart_Rate()  <= 140) return true;
            break;

            case "Toddler":  if(80 < vs.getHeart_Rate()  && vs.getHeart_Rate()  < 130) return true;
            break;

            case "PreSchooler":  if(80 < vs.getHeart_Rate()  && vs.getHeart_Rate()  < 120) return true;
            break;

            case "SchoolAge":  if(70 < vs.getHeart_Rate()  && vs.getHeart_Rate()  < 110) return true;
            break;

            case "Adolescent":  if(55< vs.getHeart_Rate()  && vs.getHeart_Rate()  < 105) return true;
            break;

            default: System.out.println("Catetogry does not match");

        }
            return false;
    }

    private boolean BloodPressureRange(String category) {
           switch(category){
            case "NewBorn":  if(50 <= vs.getBlood_Pressure() && vs.getBlood_Pressure()  <= 70) return true;
            break;

            case "Infant":  if(70 <= vs.getBlood_Pressure()  && vs.getBlood_Pressure()  <= 100) return true;
            break;

            case "Toddler":  if(80 < vs.getBlood_Pressure()  && vs.getBlood_Pressure()  < 110) return true;
            break;

            case "PreSchooler":  if(80 < vs.getBlood_Pressure()  && vs.getBlood_Pressure() < 110) return true;
            break;

            case "SchoolAge":  if(80 < vs.getBlood_Pressure()  && vs.getBlood_Pressure()  < 120) return true;
            break;

            case "Adolescent":  if(110< vs.getBlood_Pressure() && vs.getBlood_Pressure()  < 120) return true;
            break;

            default: System.out.println("Catetogry does not match");

        }
            return false;
    }

    private boolean WtKGRange(String category) {
         switch(category){
            case "NewBorn":  if(2 <= vs.getWt_Kg() && vs.getWt_Kg() <= 3) return true;
            break;

            case "Infant":  if(4 <= vs.getWt_Kg()  && vs.getWt_Kg() <= 10) return true;
            break;

            case "Toddler":  if(10 < vs.getWt_Kg() && vs.getWt_Kg() <= 14) return true;
            break;

            case "PreSchooler":  if(14 < vs.getWt_Kg()  && vs.getWt_Kg() <= 18) return true;
            break;

            case "SchoolAge":  if(20 < vs.getWt_Kg()  && vs.getWt_Kg()  <= 42) return true;
            break;

            case "Adolescent":  if(vs.getWt_Kg() >50) return true;
            break;

            default: System.out.println("Catetogry does not match");

        }
            return false;
    }

    private boolean WtPoundsRange(String category) {
         switch(category){
            case "NewBorn":  if(4.5 <= vs.getWt_Pound() && vs.getWt_Pound() <= 7) return true;
            break;
            case "Infant":  if(9 <= vs.getWt_Pound()  && vs.getWt_Pound() <= 22) return true;
            break;

            case "Toddler":  if(22 < vs.getWt_Pound() && vs.getWt_Pound() < 31) return true;
            break;

            case "PreSchooler":  if(31 < vs.getWt_Pound() && vs.getWt_Pound() < 40) return true;
            break;

            case "SchoolAge":  if(41 < vs.getWt_Pound()  && vs.getWt_Pound()  < 92) return true;
            break;

            case "Adolescent":  if(vs.getWt_Pound() >110) return true;
            break;

            default: System.out.println("Catetogry does not match");

        }
            return false;
    }
    
}
    
    
    //Test Cases
//    public void CheckData(){
//        
//        patients.setName("Chinmayi");
//        System.out.println("Test Cases");
//        VitalSigns vs = new VitalSigns();
//        
//        vs.setAge(0);
//        vs.setRespiratory_Rate(40);
//        vs.setHeart_Rate(130);
//        vs.setBlood_Pressure(60);
//        vs.setWt_Kg(2.5);
//        vs.setWt_Pound(6);
//        
        
        
        
 
   






