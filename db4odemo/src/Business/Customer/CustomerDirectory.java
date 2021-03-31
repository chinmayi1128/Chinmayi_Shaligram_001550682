/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
private ArrayList<Customer> custList;
   
    private Customer customer;
    public ArrayList<Customer> getCustList() {
        return custList;
    }
    
    
    
    public void setCustList(ArrayList<Customer> custList) {
        this.custList = custList;
    }
    
    
    
    public CustomerDirectory(){
        this.custList=new ArrayList<Customer>();
    }
    
    
    
    public Customer createCustomer(String uName){
        customer= new Customer(uName);
        custList.add(customer);
        return customer;
    }
    
    public void deleteCustomer(String username){
        for(int i=0;i<custList.size();i++){
            if(custList.get(i).getUserName().equals(username)){
                custList.remove(i);
            }
        }
    }
    
}
