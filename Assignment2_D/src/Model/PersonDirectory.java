
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

public class PersonDirectory {
    private ArrayList<Person> personDirectory;

    public PersonDirectory(){
        this.personDirectory = new ArrayList<Person>();
    }

    public ArrayList<Person> getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(ArrayList<Person> personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    public void showPersonList(){
        System.out.println("Show All Patients:"+personDirectory );
        for(Person per: personDirectory){
            System.out.println("Person's Name : "+per.getName());
            System.out.println("Person's Name : "+per.getAge());
        }
    }
    
    public Person addNew_Person()
     {
        Person person = new Person();
        personDirectory.add(person);
        System.out.println("Person Directory Display : "+personDirectory);
        return person;
    }
}

