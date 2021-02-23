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
    
        public Boolean isPatientNormal(VitalSigns vs)
        {
    
        Boolean patient_s = false;
        String AgeType = "";
      
        if (vs.getAge() == 0)
        {
            
            System.out.println("NewBorn");
            AgeType = "NewBorn";
        }
        if (vs.getAge() < 1 && vs.getAge() > 0)
        {
            
            System.out.println("Infant");
            AgeType = "Infant";
        }
        else if (vs.getAge() < 3 && vs.getAge() >= 1)
        {
            
            System.out.println("Toddler");
            AgeType = "Toddler";
        }
        
        else if (vs.getAge() <= 5 && vs.getAge() >= 3)
        {
            
            System.out.println("PreSchooler");
             AgeType = "PreSchooler";
        }
        
        else if (vs.getAge() <= 12 && vs.getAge() > 5)
        {
            
            System.out.println("SchoolAge");
             AgeType = "SchoolAge";
        }
        
        else if (vs.getAge() > 13)
        {
            
            System.out.println("Adolesent");
            AgeType = "Adolesent";
        }   
         
        if (AgeType == "NewBorn"){
            if(vs.getRespiratory_Rate() >= 30 && vs.getRespiratory_Rate() < 50){
            if(vs.getHeart_Rate() >= 120 && vs.getHeart_Rate() < 160){
            if(vs.getBlood_Pressure() >=50 && vs.getBlood_Pressure() < 70){
            if(vs.getWt_Kg()>= 2 && vs.getWt_Kg() <3){
            if(vs.getWt_Pound() >=4.5 && vs.getWt_Pound()<7){
                patient_s = true;
                             }
                           }
                        }
                     }
                  }
               }
        
        if (AgeType == "Infant"){
            if(vs.getRespiratory_Rate() >= 20 && vs.getRespiratory_Rate() < 30){
            if(vs.getHeart_Rate() >= 80 && vs.getHeart_Rate() < 140){
            if(vs.getBlood_Pressure() >=70 && vs.getBlood_Pressure() < 100){
            if(vs.getWt_Kg()>= 4 && vs.getWt_Kg() <10){
            if(vs.getWt_Pound() >=9 && vs.getWt_Pound()<22){
                patient_s = true;
                             }
                           }
                        }
                     }
                  }
               }
        
        
        
       if (AgeType == "Toddler"){
            if(vs.getRespiratory_Rate() >= 20 && vs.getRespiratory_Rate() < 30){
            if(vs.getHeart_Rate() >= 80 && vs.getHeart_Rate() < 130){
            if(vs.getBlood_Pressure() >=80 && vs.getBlood_Pressure() < 110){
            if(vs.getWt_Kg() >= 10 && vs.getWt_Kg() <14){
            if(vs.getWt_Pound() >=22 && vs.getWt_Pound()<31){
                patient_s = true;
                             }
                           }
                        }
                     }
                  }
               }
        
        if (AgeType == "PreSchooler"){
            if(vs.getRespiratory_Rate() >= 20 && vs.getRespiratory_Rate() < 30){
            if(vs.getHeart_Rate() >= 80 && vs.getHeart_Rate() < 120){
            if(vs.getBlood_Pressure() >=80 && vs.getBlood_Pressure() < 110){
            if(vs.getWt_Kg()>= 14 && vs.getWt_Kg() <18){
            if(vs.getWt_Pound() >=31 && vs.getWt_Pound()<40){
                patient_s = true;
                             }
                           }
                        }
                     }
                  }
               }
        
        
       if (AgeType == "SchoolAge"){
            if(vs.getRespiratory_Rate() >= 20 && vs.getRespiratory_Rate() < 30){
            if(vs.getHeart_Rate() >= 70 && vs.getHeart_Rate() < 110){
            if(vs.getBlood_Pressure() >=80 && vs.getBlood_Pressure() < 120){
            if(vs.getWt_Kg()>= 20 && vs.getWt_Kg() <42){
            if(vs.getWt_Pound() >=41 && vs.getWt_Pound()<92){
                patient_s = true;
                             }
                           }
                        }
                     }
                  }
               }
        
       if (AgeType == "Adolescent"){
            if(vs.getRespiratory_Rate() >= 20 && vs.getRespiratory_Rate() < 30){
            if(vs.getHeart_Rate() >= 55 && vs.getHeart_Rate() < 105){
            if(vs.getBlood_Pressure() >=110 && vs.getBlood_Pressure() < 120){
            if(vs.getWt_Kg() > 50){
            if(vs.getWt_Pound() > 110){
                patient_s = true;
                             }
                           }
                        }
                     }
                  }
               }
       
            return patient_s;
            
        
}
}

