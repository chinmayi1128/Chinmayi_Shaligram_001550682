/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Order.Order;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class Restaurant {
    private String adminUName;
    private ArrayList<Dishes> Menu;
    private ArrayList<Order> orderList;
    int id=101;

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

  
    
     public void addOrder(String restaurentName, String customerName, String deliverMan, ArrayList<Dishes> Order, String cost, String deliveryAddress) {
        Order order=new Order();
        order.setOrder_id(String.valueOf(id));
        order.setCustomerName(customerName);
        order.setRestaurentName(restaurentName);
        order.setDeliverMan(deliverMan);
        order.setOrder(Order);
        order.setCost(cost);
        order.setDeliveryAddress(deliveryAddress);
        order.setStatus("New Order");
        orderList.add(order);
        id++;
    }
    public ArrayList<Dishes> getMenu() {
        return Menu;
    }
    public void addDishes(Dishes menu){
        
        Menu.add(menu);
    }
    
    
    
    public void removeDishes(Dishes menu){
        
        Menu.remove(menu);
    }

    
    
    public String getAdminUName() {
        return adminUName;
    }

    

    public void setAdminUName(String adminUName) {
        this.adminUName = adminUName;
    }

    public Restaurant(String UName) {
        this.adminUName=UName;
        Menu=new ArrayList<Dishes>();
        orderList=new ArrayList<Order>();
    }
    
  
    private String name;
    private String address;
    private String number;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}

