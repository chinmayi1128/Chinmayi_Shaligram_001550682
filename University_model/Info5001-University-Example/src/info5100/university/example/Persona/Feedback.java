/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

/**
 *
 * @author abhisheksatbhai
 */
public class Feedback {
    String currentJobnDescription;
    String currentSalary;
    int promotionReceived;
    double employeeRating;
    
    public Feedback(String currentJobnDescription, String currentSalary, int promotionReceived , double employeeRating){
        
        this.currentJobnDescription = currentJobnDescription;
        this.currentSalary = currentSalary;
        this.promotionReceived = promotionReceived;
        this.employeeRating = employeeRating;
        
    }
    
    public void showFeedback(){
        System.out.println("-----Showing Feedback ------");
        System.out.println("Current Job Description : "+ getCurrentJobnDescription());
        System.out.println("Current Salary : "+ getCurrentSalary());
        System.out.println("Promotions Received  : "+ getPromotionReceived());
        System.out.println("Employment Rating : "+ getEmployeeRating());
    }

    public String getCurrentJobnDescription() {
        return currentJobnDescription;
    }

    public void setCurrentJobnDescription(String currentJobnDescription) {
        this.currentJobnDescription = currentJobnDescription;
    }

    public String getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(String currentSalary) {
        this.currentSalary = currentSalary;
    }

    public int getPromotionReceived() {
        return promotionReceived;
    }

    public void setPromotionReceived(int promotionReceived) {
        this.promotionReceived = promotionReceived;
    }

    public double getEmployeeRating() {
        return employeeRating;
    }

    public void setEmployeeRating(double employeeRating) {
        this.employeeRating = employeeRating;
    }
        
}
