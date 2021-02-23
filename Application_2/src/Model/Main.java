/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;

public class Main {
/**
 *
 * @author chinmayi_shaligram
 *
 */
    private static int op;
    public static void main(String[] args) {
 
VitalSigns vs = new VitalSigns();
        
Scanner in = new Scanner(System.in);
        
        do{
        System.out.println("Enter Age:");
        vs.setAge(in.nextFloat());
        
        System.out.println("Enter Respiratory Rate:");
        vs.setRespiratory_Rate(in.nextInt());
        
        System.out.println("Enter Heart Rate:");
        vs.setHeart_Rate(in.nextInt());
        
        System.out.println("Enter Blood Pressure:");
        vs.setBlood_Pressure(in.nextInt());
        
        System.out.println("Enter Weight in Kgs:");
        vs.setWt_Kg(in.nextDouble());
        
        System.out.println("Enter Weight in Pounds:");
        vs.setWt_Pound(in.nextDouble());
        
        System.out.println("Do you want to continue? If yes press 0 else continue.");
        
        op= in.nextInt();
        
        }while(op!=0);
        
       Patients patient = new Patients();
       if(patient.isPatientNormal(vs))
        {
            System.out.println("Patient is normal");
        }
        else
        {
              System.out.println("Patient is  not normal");
        }
 
        
    }
}