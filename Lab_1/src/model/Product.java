/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chinmayi_shaligram
 */
public class Product 
{
    private String Name;
    private String Description;
    private String AvailNum;
    private String Price;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getAvailNum() {
        return AvailNum;
    }

    public void setAvailNum(String AvailNum) {
        this.AvailNum = AvailNum;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
     
}

