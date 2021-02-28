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
public class Community {
    private int Zip;
    private ArrayList<House>House;
    
    public Community(int Zip, ArrayList<House> Home){
        this.Zip = Zip;
        this.House = new ArrayList<House>();
        this.House = Home;
    }

    public int getZip() {
        return Zip;
    }

    public void setZip(int Zip) {
        this.Zip = Zip;
    }

    public ArrayList<House> getHouse() {
        return House;
    }

    public void setHome(ArrayList<House> House) {
        this.House = House;
    }
    
    
}
