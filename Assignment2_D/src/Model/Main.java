
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
import java.util.ArrayList;


public class Main {
/**
 *
 * @author chinmayi_shaligram
 *
 */
    private static char op;
    private static char op2;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome!");

        
        
//        EncounterHistory encounterHistory = new EncounterHistory();
          PatientDirectory patientdirectory = new PatientDirectory();
          PersonDirectory persondirectory = new PersonDirectory();
        
          //House Community part D
          
          City city = new City("Boston","Massachussets");
          
          //Add Community 1
          
          ArrayList<Patients> Patients_List_1 = new ArrayList<>();
          ArrayList<Patients> Patients_List_2 = new ArrayList<>();
          ArrayList<Patients> Patients_List_3 = new ArrayList<>();
          ArrayList<Patients> Patients_List_4 = new ArrayList<>();
          

        while(true){

           
            System.out.println("Menu");
            System.out.println("1. Add Patient");
            System.out.println("2. Show All Patients");
//          System.out.println("3. Show Person List");
            System.out.println("3. Calculate abnormal patients");
            System.out.println("4. Exit");
            int choice = in.nextInt();
            
           

            switch(choice)
            {
            case 1:
 
                    Person person = persondirectory.addNew_Person();
                    Patients patients =  patientdirectory.addNewPatient();
                    System.out.println("Enter Name:");
                    patients.setName(in.next());
                    System.out.println("Enter Gender:");
                    patients.setGender(in.next());
                    //Age input 
                    
                    //Allocate Patient to House
                    
                    System.out.println("Select House to be assigned:");
                    System.out.println("1. House 1");
                    System.out.println("2. House 2");
                    System.out.println("3. House 3");
                    System.out.println("4. House 4");
                    int House_Choice = in.nextInt();        //input House number assigned
                    
                    switch(House_Choice)
                    {
                       case 1: Patients_List_1.add(patients);
                       break;
                       
                       case 2: Patients_List_2.add(patients);
                       break;
                       
                       case 3: Patients_List_3.add(patients);
                       break;
                       
                       case 4: Patients_List_4.add(patients);
                       break;
                       
                       default : System.out.println("Incorrect Input! Please try again.");
                        
                    }
                    
                    
                    //Part D done 
                    
                    do{
                        
                        System.out.println("Menu for one patient");
                        System.out.println("1. Checkup for all Vital Signs");
                        System.out.println("2. Check Specific Vital (using attribute name)");
                        System.out.println("3. Run Test Cases");
                        System.out.println("4. See ALL Encounter History For this patient");
                       

                        
                        int choice1 = in.nextInt();

                        switch(choice1)
                        {
                            case 1 -> patients.checkup();
                            case 2 -> patients.checkSpecificVital();
                            case 3 -> testAllCases(patients);
                            case 4 -> patients.getPatientEncounterHistory().showAllEncounterHistory();
                
                            default -> System.out.println("Incorrect input!!! Please re-enter choice from our menu");
                        }
                        
                        System.out.println("Do you wish to continue ? If No press 'N' ");
                        op = in.next().charAt(0);
                        
                    }while(op!='N');
                    break;
                
                    case 2 :
                    patientdirectory.showAllPatients();
                    break;
                    
//                    case 3 :
//                    persondirectory.showPersonList();
//                    break;
//                    
                    case 3: 
                        System.out.println("Calculating total number of patients in a community with abnormal blood pressure of any age group");

                    // adding community one
                    House house_1 = new House(915, "75 Saint Alphonsus St", Patients_List_1);
                    House house_2 = new House(802, "75 Saint Alphonsus St", Patients_List_2);
                    ArrayList<House> house_list_1 = new ArrayList<>();
                    house_list_1.add(house_1);
                    house_list_1.add(house_2);
                    Community community_1 = new Community(02120, house_list_1);

                    //showing community one
                    int totalAbnormalPatientsInCommunity = 0;
                    System.out.println("Showing data for first community");
//                    System.out.println("Community zipcode           : "+community_1.getZip());
                    for (House h: community_1.getHouse()){
                        for (Patients p : h.getPatientInHome()){
                            System.out.println(h.getPatientInHome());
                            float bp_value = p.getLatestEncounter().getVs().getBlood_Pressure();

                            if(!p.VitalSignNormal(p.getLatestEncounter().getVs(), "BloodPressureRange",  bp_value)){
                                  totalAbnormalPatientsInCommunity++;
                            }
                        }                        
                    }
                    System.out.println("Abnormal patient is this community are : "+totalAbnormalPatientsInCommunity);

                    // adding community two
                    House house_3 = new House(101, "Hunington Avenue", Patients_List_3);
                    House house_4 = new House(102, "Hunington Avenue", Patients_List_4);
                    ArrayList<House> house_list_2 = new ArrayList<>();
                    house_list_2.add(house_3);
                    house_list_2.add(house_4);
                    Community community_2 = new Community(02120, house_list_2);

                    //showing community two
                    totalAbnormalPatientsInCommunity = 0;
                    System.out.println("Showing data for second community");
//                    System.out.println("Community zipcode           : "+community_2.getZip());
                    for (House h: community_2.getHouse()){
                        for (Patients p : h.getPatientInHome()){      
                             float bp_value = p.getLatestEncounter().getVs().getBlood_Pressure();

                            if(!p.VitalSignNormal(p.getLatestEncounter().getVs(), "isInbloodPressureRange",  bp_value)){
                                  totalAbnormalPatientsInCommunity++;
                            }
                        }
                    }

                    System.out.println("Abnormal patient is this community are : "+totalAbnormalPatientsInCommunity);
                    break;

                   
                    case 4:
                    System.out.println("Exiting the application");
                    System.exit(0);
                
                default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
            }
        }
    }
    
    
private static void testAllCases(Patients patient) {
    
                  System.out.println("Test Cases for Newborn:");
                  testPatient(patient, 0, 40, 152, 60, 3, 6);
                  testPatient(patient, 0, 25, 170, 45, 1, 4);
                  System.out.println("Test Cases for Infant:");
                  testPatient(patient, 1, 25, 90, 80, 5, 14);
                  testPatient(patient, 5, 19, 142, 105, 1, 4);
                  System.out.println("Running Test Cases for Toddlerz:");
                  testPatient(patient, 2, 25, 90, 90, 12, 25);
                  testPatient(patient, 1, 35, 90, 90, 13, 35);
                  System.out.println("Running Test Cases for Preschooler:");
                  testPatient(patient, 4, 25, 100, 100, 16, 35);
                  testPatient(patient, 4, 25, 170, 45, 1, 40);
                  System.out.println("Running Test Cases for SchoolAge:");
                  testPatient(patient, 8, 28, 85, 90, 32, 54);
                  testPatient(patient, 7, 25, 70, 45, 38, 51);
                  System.out.println("Running Test Cases for Adolescent:");
                  testPatient(patient, 18, 18, 68, 115, 75, 126);
                  testPatient(patient, 15, 15, 80, 105, 72, 109);
                  
                  
         
               
}
          
           

 private static void testPatient(Patients patients, float age, int RespiratoryRate, int HeartRate, int BloodPressure, float WtKG, float WtPounds) {
    
        EncounterHistory encounterHistory = new EncounterHistory();
        Encounter ec = encounterHistory.addNewEncounters();
        VitalSigns vs = ec.getVs();
        Scanner in = new Scanner(System.in); 
       
        vs.setAge(age);
        vs.setRespiratory_Rate(RespiratoryRate);
        vs.setHeart_Rate(HeartRate);
        vs.setBlood_Pressure(BloodPressure);
        vs.setWt_Kg(WtKG);
        vs.setWt_Pound(WtPounds);
        LocalDateTime localDate = LocalDateTime.now();
        vs.setDate(localDate.toString());
        
        if (patients.isPatientNormal(vs)){
            System.out.println("Patient is normal");
        }
        else {
            System.out.println("Patient is not normal");
        }
    }

}
    
 


