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
public class Medical {
    
    private String Record_No;
    private String Blood_Grp;
    private String Diabetes;
    private String Blood_Pressure;
    private String Covid;

    public String getBlood_Grp() {
        return Blood_Grp;
    }

    public void setBlood_Grp(String Blood_Grp) {
        this.Blood_Grp = Blood_Grp;
    }

    public String getRecord_No() {
        return Record_No;
    }

    public void setRecord_No(String Record_No) {
        this.Record_No = Record_No;
    }

    public String getDiabetes() {
        return Diabetes;
    }

    public void setDiabetes(String Diabetes) {
        this.Diabetes = Diabetes;
    }

    public String getBlood_Pressure() {
        return Blood_Pressure;
    }

    public void setBlood_Pressure(String Blood_Pressure) {
        this.Blood_Pressure = Blood_Pressure;
    }

    public String getCovid() {
        return Covid;
    }

    public void setCovid(String Covid) {
        this.Covid = Covid;
    }
    
}
