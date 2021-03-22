/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.Persona.*;
import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyDirectory {

    Department department;
    ArrayList<FacultyProfile> teacherlist;

    public FacultyDirectory(Department d) {

        department = d;
        teacherlist = new ArrayList();

    }

    public FacultyProfile newStudentProfile(Person p, double facultyRating, String jobType, int numberOfTrainingsPerYear, String specialization) { //rename to newFacultyProfile

        FacultyProfile sp = new FacultyProfile(p,facultyRating, jobType ,numberOfTrainingsPerYear, specialization);
        teacherlist.add(sp);
        return sp;
    }

    public FacultyProfile findTeachingFaculty(String id) {

        for (FacultyProfile sp : teacherlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
        
    public void showFacultyDirectory() {
        System.out.println("-----Showing Faculty Directory-----");
        for (FacultyProfile fp: teacherlist)
        {
            System.out.println("Faculty ID: "+fp.person.getPersonId());
            System.out.println("Faculty Name: "+fp.person.getName());
            System.out.println("Faculty Rating: "+fp.getFacultyRating());
            System.out.println("Faculty Job Type: "+fp.getJobType());
            System.out.println("Faculty Tranings Completed per year: "+fp.getNumberOfTrainingsPerYear());
            System.out.println("Faculty Specialiation: "+fp.getSpecialization());
//            fp.showFacultyAssignments();
            System.out.println("");
        }
    }
}
