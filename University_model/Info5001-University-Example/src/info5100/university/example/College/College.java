/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.College;

import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author abhisheksatbhai
 */
public class College {
    String name;
    ArrayList<Department> departments;
    
    public College(String collegeName){
        this.name = collegeName;
        departments = new ArrayList<Department>();
        
    }
    
    public Department addNewDepartment(String departmentName){
        Department department = new Department(departmentName);
        departments.add(department);
        return department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
    
    public void showAllDepartment(){
        System.out.println("--------Showing Departments--------");
        for (Department d: departments){
            System.out.println(d.getName());
            
        }
    }
}
