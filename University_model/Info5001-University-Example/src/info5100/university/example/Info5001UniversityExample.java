/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.College.College;
import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Employer.EmployerDirectory;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Feedback;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.time.Clock;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        College college = new College("College of Engineering");
       
        
        Scanner in = new Scanner(System.in); 
        
        while(true){
            System.out.println("--------Main Menu--------");
            System.out.println("0. Show All Department");
            System.out.println("1. Department Information Systems");
            System.out.println("2. Department Computer Science");
            System.out.println("3. Exit");
            System.out.println("--------End of Main Menu--------");
            
            int choice2 = in.nextInt();
            
            switch(choice2)
            {
                case 0 : 
                    populateDepartmentOne(college);
                    populateDepartmentTwo(college);
                    college.showAllDepartment();
                break;
                
                case 1 : 
                    Department department = populateDepartmentOne(college);              
                    MainDepartmentMenu(department);
                    
                        
                break;
                
                case 2: 
                    Department departmentTwo = populateDepartmentTwo(college); 
                    MainDepartmentMenu(departmentTwo);
                break;
                
                case 3: 
                    System.out.println("Exiting the application");
                    System.exit(0);
            }
        }
                        
        }
        
    private static Department populateDepartmentOne(College college){
        Department department = college.addNewDepartment("Information Systems");

        //create courses
        Course course = department.newCourse("App engineering development", "info-5100", 4);
        Course courseTwo = department.newCourse("Web design", "info-5101", 4);
        Course courseThree = department.newCourse("Methods and Tools", "info-5102", 4);
        Course courseFour = department.newCourse("Data Science", "info-5103", 4);
        Course courseFive = department.newCourse("Robotics", "info-5104", 4);
        Course courseSix = department.newCourse("Artificial Intelligence", "info-5105", 4);
        //set industrial importance course rating
        course.setIndustrialImportanceRating(9.8);
        courseTwo.setIndustrialImportanceRating(8.3);
        courseThree.setIndustrialImportanceRating(6.1);
        courseFour.setIndustrialImportanceRating(6.1);
        courseFive.setIndustrialImportanceRating(7);
        courseSix.setIndustrialImportanceRating(9);

        //create course schedules
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
        CourseSchedule coursescheduleTwo = department.newCourseSchedule("Spring2020");

        //create course offered for that course schedule
        //fall
        CourseOffer courseoffer = courseschedule.newCourseOffer("info-5100");
        CourseOffer courseofferTwo = courseschedule.newCourseOffer("info-5101");
        //spring
        CourseOffer courseofferThree = coursescheduleTwo.newCourseOffer("info-5102");
        CourseOffer courseofferFour = coursescheduleTwo.newCourseOffer("info-5103");
        CourseOffer courseofferFive = coursescheduleTwo.newCourseOffer("info-5104");
        CourseOffer courseofferSix = coursescheduleTwo.newCourseOffer("info-5105");
        
        //generate seats for all courses
        courseoffer.generatSeats(10);
        courseofferTwo.generatSeats(10);
        courseofferThree.generatSeats(10);
        courseofferFour.generatSeats(10);
        courseofferFive.generatSeats(10);
        courseofferSix.generatSeats(10);
        
        
        PersonDirectory pd = department.getPersonDirectory();
        FacultyDirectory fd = department.getFacultydirectory();
  
        //create faculty, rating other details
        Person personTwo = pd.newPerson("101", "Faculty: Robin Sharma");
        FacultyProfile fp = fd.newStudentProfile(personTwo, 15, "Full Time", 9, "Phd in Machine Learning");
        
        Person personThree = pd.newPerson("102", "Faculty: Jenifer Colin");
        FacultyProfile fpTwo = fd.newStudentProfile(personThree, 8, "Full Time", 5, "Phd in Analyst");
        
        Person personFour = pd.newPerson("103", "Faculty: Divya Patel");
        FacultyProfile fpThree = fd.newStudentProfile(personFour, 6, "Full Time", 4, "Phd in Marketing");
        
        //assign faculty to courseoffer 
        courseoffer.AssignAsTeacher(fp);
        courseofferTwo.AssignAsTeacher(fpTwo);
        courseofferThree.AssignAsTeacher(fpThree);
        courseofferFour.AssignAsTeacher(fpThree);
        courseofferFive.AssignAsTeacher(fpThree);
        courseofferSix.AssignAsTeacher(fpThree);
        
        
        
        StudentDirectory sd = department.getStudentDirectory();
        //create student -1 
        Person person = pd.newPerson("100", "Student: Ramesh Iher");
        StudentProfile student = sd.newStudentProfile(person);
        //add course for the student
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
        CourseLoad courseloadSpring = student.newCourseLoad("Spring2020"); 
        //register student in class
        courseload.newSeatAssignment(courseoffer);
        // set GPA
        courseoffer.getCourse().setGpa(3.5);
        // register student in another class
        courseloadSpring.newSeatAssignment(courseofferThree);
         // set GPA for another class
        courseofferThree.getCourse().setGpa(3.8);
        // set employment 
        ArrayList<CourseOffer> relevantcourses = new ArrayList<CourseOffer>();
        relevantcourses.add(courseoffer);
        relevantcourses.add(courseofferThree);
        student.getEmploymenthistory().newEmployment("Apple : Software Engineer", relevantcourses);
        student.getEmploymenthistory().newEmployment("Facebook : Software Developer", relevantcourses);
        //set employeer rating
        Feedback student_Feedback = new Feedback("Software Developer", "128000", 4, 9.8);
        student.setFeedback(student_Feedback);
        
        //create student -2
        Person personFive = pd.newPerson("99", "Student: John Green");
        StudentProfile studentTwo = sd.newStudentProfile(personFive);
        //add course for the student
        CourseLoad courseloadTwo = studentTwo.newCourseLoad("Fall2020"); 
        //register student in class
        courseloadTwo.newSeatAssignment(courseofferTwo);
        // set GPA
        courseofferTwo.getCourse().setGpa(4.0);
        //set employment 
        studentTwo.getEmploymenthistory().newEmployment("Google : Software Developer 1", relevantcourses);
        //set employeer rating
        Feedback studentTwo_Feedback = new Feedback("Software Developer 1", "118000", 2, 7.9);
        studentTwo.setFeedback(studentTwo_Feedback);
        
        
        //create stucent -3 
        Person personSix = pd.newPerson("98", "Student: Pooja Deshmukh");
        StudentProfile studentThree = sd.newStudentProfile(personSix);
        //add course for the student
        CourseLoad courseloadThree = studentThree.newCourseLoad("Spring2020"); 
        //register student in class
        courseloadThree.newSeatAssignment(courseofferThree);
         //set employment
        studentThree.getEmploymenthistory().newEmployment("Amazon : Software Developer 1", relevantcourses);
        //set employeer rating
        Feedback studentThree_Feedback = new Feedback("Software Developer 1", "100000", 1, 6.6);
        studentThree.setFeedback(studentThree_Feedback);
        
        //create student - 4
        Person personSeven = pd.newPerson("97", "Student: Rachel Blanc");
        StudentProfile studentFour = sd.newStudentProfile(personSeven);
        //add course for the student
        CourseLoad courseloadFour = studentFour.newCourseLoad("Fall2020"); 
        //register student in class
        courseloadFour.newSeatAssignment(courseofferFour);
        //set GPA
        courseofferFour.getCourse().setGpa(3.0);
        //set employment
        studentFour.getEmploymenthistory().newEmployment("Amazon : Data Analyst", relevantcourses);
        //set employeer rating
        Feedback studentFour_Feedback = new Feedback("Software Developer 1", "90000", 2, 5.9);
        studentFour.setFeedback(studentFour_Feedback);
        
        return department;
    }

    private static Department populateDepartmentTwo(College college) {
        Department department = college.addNewDepartment("Computer Science");


        //create courses
        Course course = department.newCourse("Machine Learning", "cs-6000", 5);
        Course courseTwo = department.newCourse("Object Oriented Programming", "cs-6001", 5);
        Course courseThree = department.newCourse("Python", "cs-6002", 5);
        Course courseFour = department.newCourse("DevOps", "cs-6003", 5);
        Course courseFive = department.newCourse("Data Science", "cs-6004", 5);
        Course courseSix = department.newCourse("IOT", "cs-6005", 5);
        //set industrial importance course rating
        course.setIndustrialImportanceRating(9.8);
        courseTwo.setIndustrialImportanceRating(8.3);
        courseThree.setIndustrialImportanceRating(6.1);
        courseFour.setIndustrialImportanceRating(6.1);
        courseFive.setIndustrialImportanceRating(5.6);
        courseSix.setIndustrialImportanceRating(5);

        //create course schedules
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
        CourseSchedule coursescheduleTwo = department.newCourseSchedule("Spring2020");

        //create course offered for that course schedule
        //fall
        CourseOffer courseoffer = courseschedule.newCourseOffer("cs-6000");
        CourseOffer courseofferTwo = courseschedule.newCourseOffer("cs-6001");
        //spring
        CourseOffer courseofferThree = coursescheduleTwo.newCourseOffer("cs-6002");
        CourseOffer courseofferFour = coursescheduleTwo.newCourseOffer("cs-6003");
        CourseOffer courseofferFive = coursescheduleTwo.newCourseOffer("cs-6004");
        CourseOffer courseofferSix = coursescheduleTwo.newCourseOffer("cs-6005");
        
        //generate seats for all courses
        courseoffer.generatSeats(10);
        courseofferTwo.generatSeats(10);
        courseofferThree.generatSeats(10);
        courseofferFour.generatSeats(10);
        courseofferFive.generatSeats(10);
        courseofferSix.generatSeats(10);
        
        
        PersonDirectory pd = department.getPersonDirectory();
        FacultyDirectory fd = department.getFacultydirectory();
  
        //create faculty, rating other details
        Person personTwo = pd.newPerson("101", "Faculty: Birla Kumar");
        FacultyProfile fp = fd.newStudentProfile(personTwo, 9, "Full Time", 9, "Phd in Software Development");
        
        Person personThree = pd.newPerson("102", "Faculty: Arvind Kolapkar");
        FacultyProfile fpTwo = fd.newStudentProfile(personThree, 7, "Full Time", 7, "Phd in Computer Networks");
        
        Person personFour = pd.newPerson("103", "Faculty: Neha Sharma");
        FacultyProfile fpThree = fd.newStudentProfile(personFour, 6, "Full Time", 4, "Phd in Computation");
        
        //assign faculty to courseoffer 
        courseoffer.AssignAsTeacher(fp);
        courseofferTwo.AssignAsTeacher(fpTwo);
        courseofferThree.AssignAsTeacher(fpThree);
        courseofferFour.AssignAsTeacher(fpThree);
        courseofferFive.AssignAsTeacher(fpThree);
        courseofferSix.AssignAsTeacher(fpThree);
        
        
        
        StudentDirectory sd = department.getStudentDirectory();
        //create student -1 
        Person person = pd.newPerson("100", "Student: Rohit Pawar");
        StudentProfile student = sd.newStudentProfile(person);
        //add course for the student
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
        CourseLoad courseloadSpring = student.newCourseLoad("Spring2020"); 
        //register student in class
        courseload.newSeatAssignment(courseoffer);
        // set GPA
        courseoffer.getCourse().setGpa(3.5);
        // register student in another class
        courseloadSpring.newSeatAssignment(courseofferThree);
         // set GPA for another class
        courseofferThree.getCourse().setGpa(3.8);
        // set employment 
        ArrayList<CourseOffer> relevantcourses = new ArrayList<CourseOffer>();
        relevantcourses.add(courseoffer);
        relevantcourses.add(courseofferThree);
        student.getEmploymenthistory().newEmployment("Apple : System engineer", relevantcourses);
        //set employeer rating
        Feedback student_Feedback = new Feedback("System engineer", "158000", 6, 9.9);
        student.setFeedback(student_Feedback);
        
        //create student -2
        Person personFive = pd.newPerson("99", "Student: Sumesh Methkar");
        StudentProfile studentTwo = sd.newStudentProfile(personFive);
        //add course for the student
        CourseLoad courseloadTwo = studentTwo.newCourseLoad("Fall2020"); 
        //register student in class
        courseloadTwo.newSeatAssignment(courseofferTwo);
        // set GPA
        courseofferTwo.getCourse().setGpa(4.0);
        //set employment 
        studentTwo.getEmploymenthistory().newEmployment("Barclays : Software Developer 1", relevantcourses);
        //set employeer rating
        Feedback studentTwo_Feedback = new Feedback("Software Developer 1", "92000", 2, 6.9);
        studentTwo.setFeedback(studentTwo_Feedback);
        
        
        //create stucent -3 
        Person personSix = pd.newPerson("98", "Student:  Ujjawal Kumar");
        StudentProfile studentThree = sd.newStudentProfile(personSix);
        //add course for the student
        CourseLoad courseloadThree = studentThree.newCourseLoad("Spring2020"); 
        //register student in class
        courseloadThree.newSeatAssignment(courseofferThree);
         //set employment
        studentThree.getEmploymenthistory().newEmployment("Amazon : Graduate Engineer Trainee", relevantcourses);
        //set employeer rating
        Feedback studentThree_Feedback = new Feedback(" Graduate Engineer Trainee", "80000", 0, 5.6);
        studentThree.setFeedback(studentThree_Feedback);
        
        //create student - 4
        Person personSeven = pd.newPerson("97", "Student:  Pratik Agrawal");
        StudentProfile studentFour = sd.newStudentProfile(personSeven);
        //add course for the student
        CourseLoad courseloadFour = studentFour.newCourseLoad("Fall2020"); 
        //register student in class
        courseloadFour.newSeatAssignment(courseofferFour);
        //set GPA
        courseofferFour.getCourse().setGpa(3.0);
        //set employment
        studentFour.getEmploymenthistory().newEmployment("Amazon : Data Analyst", relevantcourses);
        //set employeer rating
        Feedback studentFour_Feedback = new Feedback("Data Analyst", "70000", 2, 4.9);
        studentFour.setFeedback(studentFour_Feedback);
        
        return department;
    }

    private static void MainDepartmentMenu(Department department) {
        Scanner in = new Scanner(System.in); 
        char op;
        do{
            System.out.println("--------Department "+department.getName()+" Menu-------");
            System.out.println("1. Show Courses Catalog");
            System.out.println("2. Show Course Schedule for Courses it offers");
            System.out.println("3. Show Person Directory");
            System.out.println("4. Show Student Directory");
            System.out.println("5. Show Faculty Directory");
            System.out.println("6. Check Course load of student Using ID");
            System.out.println("7. Calculate Revenue By semister");
            System.out.println("8. Calculate Total Revenue Of Department");
            System.out.println("9. Go to Student Menu");
            System.out.println("10. Go to Update Menu");
            System.out.println("11. Calculate Student Performance");
            int choice = in.nextInt();

            switch(choice)
            {
                case 1 : {
                    department.getCourseCatalog().showCourseCatalog();
                    break;
                }
                case 2 : {
                    System.out.print("Enter Semister e.g Fall2020, Spring2020 :");
                    String semester = in.next();
                    department.getCourseSchedule(semester).showCourseSchedule();
                    break;
                }

                case 3: {
                    department.getPersonDirectory().showPersonDirectory();
                    break;
                }

                case 4: {
                    department.getStudentDirectory().showStudentDirectory();
                    break;
                }

                case 5: {
                    department.getFacultydirectory().showFacultyDirectory();
                    break;
                }

                case 6:{
                    System.out.print("Enter Student ID: ");
                    String studentID = in.next();
                    StudentProfile sp = department.getStudentDirectory().findStudent(studentID);
                    System.out.print("Enter Semister e.g Fall2020, Spring2020 :");
                    String semester = in.next();
                    CourseLoad cl = sp.getCourseLoadBySemester(semester);
                    cl.showCourseLoad();
                    break;
                }

                case 7:{
                    System.out.print("Enter Semister e.g Fall2020, Spring2020 :");
                    String semester = in.next();
                    int total = department.calculateRevenuesBySemester(semester);
                    System.out.println("Total Revenue : " + total);
                    break;
                }

                case 8:{
                    System.out.print("-------Total Revenue for Department-------");
                    System.out.println("Total Revenue : " + department.calculateTotalRevenue());
                    break;
                }

                case 9 :{

                        System.out.print("Enter Student ID: ");
                        String studentID = in.next();
                        StudentProfile sp = department.getStudentDirectory().findStudent(studentID);
                    do{
                        System.out.println("-----Welcome to Student "+sp.getPerson().getName()+" Menu-----");
                        System.out.println("1. Check Course Load By Semester");
                        System.out.println("2. Get GPA by Semester");
                        System.out.println("3. Student Accounts");
                        System.out.println("4. Student Employment");
                        System.out.println("5. Get Total GPA");
                        System.out.println("6. Get Feedback From Employeer");

                        int choice3 = in.nextInt();

                        switch(choice3){
                            case 1: {

                                System.out.print("Enter Semister e.g Fall2020, Spring2020 :");
                                String semester = in.next();
                                CourseLoad cl = sp.getCourseLoadBySemester(semester);
                                cl.showCourseLoad();
                                break;
                            }

                            case 2: {

                                System.out.print("Enter Semister e.g Fall2020, Spring2020 :");
                                String semester = in.next();
                                CourseLoad cl = sp.getCourseLoadBySemester(semester);
                                if (cl != null) {
                                   System.out.println("GPA : " + cl.getAvgGpaBySemester()); 
                                }
                                else {
                                     System.out.println("GPA : " + 0.0); 
                                }
                                break;
                            }

                            case 3: {
                                System.out.println("Total Billing of Student : 12000");
                            }
                            case 4 :{
                                sp.getEmploymenthistory().showEmployment();
                                break;

                            }
                            case 5: {
                                System.out.println("Total GPA : "+sp.getTranscript().getTotalGPA());
                                break;
                            }

                            case 6: {
                                sp.getFeedback().showFeedback();
                                break;
                            }
                        }


                        System.out.println("Do you wish to continue Update Menu? If No press 'N' ");
                        op = in.next().charAt(0);

                    }while(op!='N');
                    break;
                }

                case 10: {

                    System.out.println("-----Update Menu-----");

                    do{

                        System.out.println("1. Update student details.");
                        System.out.println("2. Update faculty details.");
                        System.out.println("3. Update employment of the student");
                        System.out.println("4. Update course details");
                        System.out.println("5. Update course credit");
                        System.out.println("6. Update employer feedback");
                        System.out.println("Enter your choice");

                        int choice4 = in.nextInt();

                        switch (choice4){


                                case 1: {
                                    System.out.println("Enter Student ID for which details are to be updated.");
                                    String studentID = in.next();
                                    StudentProfile sp = department.getStudentDirectory().findStudent(studentID);
                                    System.out.println("Existing name in the system:");
                                    System.out.println(sp.getPerson().getName());
                                    System.out.println("Enter updated name of the student");
                                    sp.getPerson().setName(in.next());
                                    System.out.println("Student name successfully updated!");

                                break;

                                }

                                case 2: {
                                    System.out.println("Enter ID of the faculty to be updated.");
                                    String f_id = in.next();
                                    System.out.println("Enter updated name of the faculty");
                                    department.getFacultydirectory().findTeachingFaculty(f_id).getPerson().setName(in.next());
                                    System.out.println("Faculty name successfully updated!");

                                break;

                                }

                                case 3: {       

                                    EmployerDirectory ed = new EmployerDirectory(department);
                                    ed.newEmployerProfile("Apple", "1000");
                                    ed.newEmployerProfile("Facebook", "1001");
                                    ed.newEmployerProfile("Google", "1002");
                                    ed.newEmployerProfile("Microsoft", "1003");
                                    ed.showEmployerProfile();
                                    System.out.println("Enter ID of the employer to be updated");
                                    String e_id = in.next();

                                    System.out.println("Enter new employer name");
                                    String e_name = in.next();

                                    ed.findEmployer(e_id).setName(e_name);
                                    System.out.println("Employer name successfully updated!");
                                break;

                                }

                                case 4:
                                {

                                    System.out.println("List of courses: ");
                                    department.getCourseCatalog().showCourseCatalog();
                                    System.out.println("Enter course number of the course to be updated");
                                    String n = in.next();
                                    System.out.println("Enter updated name");
                                    department.getCourseCatalog().getCourseByNumber(n).setName(in.next());
                                    System.out.println("Course name updated successfully");

                                    break;
                                }


                                case 5:
                                {
                                    System.out.println("Enter course number of the course to be updated");
                                    String n1 = in.next();
                                    System.out.println("Enter updated credits for the course");
                                    department.getCourseCatalog().getCourseByNumber(n1).setCredits(in.nextInt());  
                                    break;
                                }

                        }

                        System.out.println("Do you wish to continue Update Menu? If No press 'N' ");
                        op = in.next().charAt(0);

                    }while(op !='N');
                break;
            }

                case 11:{
                    department.getStudentDirectory().calculateStudentPerformance();

                }
            }

            System.out.println("Do you wish to continue Department Menu? If No press 'N' ");
            op = in.next().charAt(0);

        }while(op!='N');
    }

   }

