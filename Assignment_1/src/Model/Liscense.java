/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author chinmayi_shaligram
 */
public class Liscense {
    
     private String Liscense_No;
     private String Issue_Date;
     private String Expiry_Date;
     private String Blood_Group;
     private String Photo;
     private String Path;

    public String getIssue_Date() {
        return Issue_Date;
    }

    public void setIssue_Date(String Issue_Date) {
        this.Issue_Date = Issue_Date;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String Path) {
        this.Path = Path;
    }
     
    
    public String getLiscense_No() {
        return Liscense_No;
    }

    public void setLiscense_No(String Liscense_No) {
        this.Liscense_No = Liscense_No;
    }

    public String getExpiry_Date() {
        return Expiry_Date;
    }

    public void setExpiry_Date(String Expiry_Date) {
        this.Expiry_Date = Expiry_Date;
    }

    public String getBlood_Group() {
        return Blood_Group;
    }

    public void setBlood_Group(String Blood_Group) {
        this.Blood_Group = Blood_Group;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }
     
}
