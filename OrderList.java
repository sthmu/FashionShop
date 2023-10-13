/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author user
 */
public interface OrderList {
   
    
    public void add(Order order);
    public void add(int index,Order order);
    public void printList();
    public Order getLast();
    public Order getFront();
    public void setFront(Order order);
   
}
