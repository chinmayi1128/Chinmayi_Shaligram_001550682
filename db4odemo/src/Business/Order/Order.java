/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Restaurant.Dishes;
import java.util.ArrayList;

/**
 *
 * @author chinmayi_shaligram
 */
public class Order {
private String order_id;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    private String restaurentName;
    private String customerName;
    private String deliverMan;
    private ArrayList<Dishes> Order;
    private String cost;
    private String status;
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    private String deliveryAddress;
    
    

    public String getRestaurentName() {
        return restaurentName;
    }

    public void setRestaurentName(String restaurentName) {
        this.restaurentName = restaurentName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliverMan() {
        return deliverMan;
    }

    public void setDeliverMan(String deliverMan) {
        this.deliverMan = deliverMan;
    }

    public ArrayList<Dishes> getOrder() {
        return Order;
    }

    public void setOrder(ArrayList<Dishes> Order) {
        this.Order = Order;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    @Override
    public String toString() {
        return order_id;
    }
    
}

