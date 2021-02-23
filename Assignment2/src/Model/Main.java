/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.System.in;
import java.time.LocalDateTime;
import java.util.Scanner;
import Model.Patients;
import Model.VitalSigns;


public class Main {
/**
 *
 * @author chinmayi_shaligram
 *
 */
    private static char op;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome!");
        Patients patients = new Patients();
        
        System.out.println("Enter Your Name:");
        patients.setName(in.nextLine());

        do {

            System.out.println("Welcome to our Clinic!!");
            System.out.println("Menu");
            System.out.println("1. Checkup for all Vital Signs");
            System.out.println("2. See History");
            System.out.println("3. Checkup for Specific Vital Sign");
            int choice = in.nextInt();
            
           

            switch(choice)
            {
            case 1:
           //current vs

            VitalSigns vs = patients.addNewVitals(); 
           
            System.out.println("Enter Age:");
            vs.setAge(in.nextInt());
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

            if (patients.isPatientNormal(vs)){
                System.out.println("Patient is normal");
            }
            else {
                System.out.println("Patient is not normal");
            }
            break;
                
            case 2:       
            System.out.println(patients.getName());
            System.out.println("Current Vital :"+ patients.getVs());
            
            for (VitalSigns vs1 : patients.getHistory())
            {
            System.out.println("Blood Pressure:"+vs1.getBlood_Pressure());
            System.out.println("Date:"+vs1.getDate());
            System.out.println("Heart Rate:"+vs1.getHeart_Rate());
            System.out.println("Respiratory Rate:"+vs1.getRespiratory_Rate());
            System.out.println("Weight in Kg:"+vs1.getWt_Kg());
            System.out.println("Weight in pounds:"+vs1.getWt_Pound());
            System.out.println("Model: "+vs1);
            System.out.println("\n");
      
            } 
            break;
            
            case 3:
            String VitalAttribute;
            float VitalAttributeValue;
            
            vs = patients.addNewVitals();     

            System.out.println("Enter Age:");
            vs.setAge(in.nextInt());
            System.out.println("Enter Vital Attribute to be checked :");
            VitalAttribute = in.next();
            System.out.println("Enter your value for : "+VitalAttribute);
            VitalAttributeValue = in.nextInt();

            
            if (patients.isThisVitalSignNormal(vs, VitalAttribute, VitalAttributeValue)){
                System.out.println("Patient is normal");
            }
            else {
                System.out.println("Patient is not normal");
            }
            break;
            }
            
            System.out.println("Do you want to continue? If Yes press '1' else '0'");
            op = in.next().charAt(0);

        }while(op!='0');

    }



}


