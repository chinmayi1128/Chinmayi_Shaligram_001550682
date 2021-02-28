/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
/**
 *
 * @author chinmayi_shaligram
 */

public class Patients extends Person{
    private boolean status;
    private String category;
    private EncounterHistory patientEncounterHistory;

    public Patients(){
        this.patientEncounterHistory = new EncounterHistory();
    }

    public EncounterHistory getPatientEncounterHistory() {
        return patientEncounterHistory;
    }

    public void setPatientEncounterHistory(EncounterHistory patientEncounterHistory) {
        this.patientEncounterHistory = patientEncounterHistory;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public float getAge() {
        return Age;
    }

    @Override
    public void setAge(float age) {
        this.Age = Age;
    }

    @Override
    public String getGender() {
        return Gender;
    }

    @Override
    public void setGender(String gender) {
        this.Gender = gender;
    }
    
    public Encounter getLatestEncounter(){
        return getPatientEncounterHistory().getEncounterHistory().get(getPatientEncounterHistory().getEncounterHistory().size()-1);
    }
    
    public boolean VitalSignNormal(VitalSigns vs, String vitalAttribute, Float vitalAttributeValue){

        category = get_Category(vs);
        boolean VitalSignNormalStatus=false;
        

        if (vitalAttribute.equals("RespiratoryRateRange")){
            int intOfvitalAttributeValue = Math.round(vitalAttributeValue);
            vs.setRespiratory_Rate(intOfvitalAttributeValue);
            VitalSignNormalStatus = RespiratoryRateRange(category, vs);
        }
        else if (vitalAttribute.equals("HeartRateRange")) {
            int intOfvitalAttributeValue = Math.round(vitalAttributeValue);
            vs.setHeart_Rate(intOfvitalAttributeValue);
            VitalSignNormalStatus = HeartRateRange(category, vs);
        }
        else if (vitalAttribute.equals("BloodPressureRange")) {
            int intOfvitalAttributeValue = Math.round(vitalAttributeValue);
            vs.setBlood_Pressure(intOfvitalAttributeValue);
            VitalSignNormalStatus = BloodPressureRange(category, vs);
        }
        else if (vitalAttribute.equals("WtKGRange"))  {
            VitalSignNormalStatus = WtKgRange(category, vs);
        }
        else if (vitalAttribute.equals("WtPoundsRange"))  {
            VitalSignNormalStatus = WtPoundsRange(category, vs);
        }
        
        return VitalSignNormalStatus;
    }
    
     
     public boolean isPatientNormal(VitalSigns vs){ //vs is object which has users all data
        
         category = get_Category(vs);
   
        System.out.println("R: "+RespiratoryRateRange(category, vs));
        System.out.println("H: "+HeartRateRange(category, vs));
        System.out.println("B: "+BloodPressureRange(category,vs));
        System.out.println("WR: "+WtKgRange(category,vs));
        System.out.println("WP: "+WtPoundsRange(category, vs));
        status = false;
        if (RespiratoryRateRange(category, vs) && HeartRateRange(category, vs) && BloodPressureRange(category, vs) && WtKgRange(category, vs) && WtPoundsRange(category, vs)) {
            status= true;
        }
        System.out.println("status: "+status);
        return status;
        
    }
     
     private String get_Category(VitalSigns vs) {
        
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
        else if (vs.getAge()>=13){
            category = "Adolescent";
        } 
        System.out.println("patient category : "+category);
        return category;
    }

    private boolean RespiratoryRateRange(String category, VitalSigns vs) {

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

    private boolean HeartRateRange(String category, VitalSigns vs) {
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

    private boolean BloodPressureRange(String category, VitalSigns vs) {
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

    private boolean WtKgRange(String category, VitalSigns vs) {
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

    private boolean WtPoundsRange(String category, VitalSigns vs) {
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
    
public void checkup(){
            EncounterHistory encounterHistory = getPatientEncounterHistory();
            Encounter e = encounterHistory.addNewEncounters();
            VitalSigns vs = e.getVs();
                    
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Age:");
            vs.setAge(in.nextFloat());
            System.out.println("Enter Respiratory Rate:");
            vs.setRespiratory_Rate(in.nextInt());
            System.out.println("Enter Heart Rate:");
            vs.setHeart_Rate(in.nextInt());
            System.out.println("Enter Blood Pressure:");
            vs.setBlood_Pressure(in.nextInt());
            System.out.println("Enter Weight in KG:");
            vs.setWt_Kg(in.nextFloat());
            System.out.println("Enter Weight in Pounds:");
            vs.setWt_Pound(in.nextFloat());
            LocalDateTime localDate = LocalDateTime.now();
            vs.setDate(localDate.toString());
            
            System.out.println("Enter Doctors Name:");
            e.setDoctorName(in.next());
            e.setDate(localDate.toString());
            e.setVs(vs);
            e.showEncounter();
            
            if (isPatientNormal(vs)){
                System.out.println("Patient is normal");
            }
            else {
                System.out.println("Patient is not normal");
            }
    }
    
    public void checkSpecificVital(){
                        
        String VitalAttribute;
        float VitalAttributeValue;
        EncounterHistory encounterHistory = getPatientEncounterHistory();
        Encounter e = encounterHistory.addNewEncounters();
        VitalSigns vs = e.getVs();
        
        Scanner in = new Scanner(System.in); 
        
        System.out.println("Enter Age:");
        vs.setAge(in.nextFloat());
        System.out.println("Enter Vital Attribute to be checked :");
        VitalAttribute = in.next();
        System.out.println("Enter your value for : "+VitalAttribute);
        VitalAttributeValue = in.nextInt();
        
        if (VitalSignNormal(vs, VitalAttribute, VitalAttributeValue)){
            System.out.println("Patient is normal");
        }
        else {
            System.out.println("Patient is not normal");
        }
    }
    
}

        
        
 
   






