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
public class OrderListImpl implements OrderList{
    private Order front;
    private final Order zeroOrder = new Order();

     OrderListImpl() {
        front = null;
    }

    private boolean isEmpty() {
        return front == null;
    }

    @Override
    public void add(Order order) {
        if (isEmpty()) {
            front = order;
        } else {
            Order tempOrder = front;
            while (tempOrder.nextOrder != null) {
                tempOrder = tempOrder.nextOrder;
            }
            tempOrder.nextOrder = order;
        }
    }

    @Override
    public void add(int index, Order order) {
        Order tempOrder = front;
        Order prevtempOrder = null;

        for (int i = 0; i < index; i++) {
            if (tempOrder == null) {
                System.out.println("Index out of range");
                return;
            }
            prevtempOrder = tempOrder;
            tempOrder = tempOrder.nextOrder;
        }
        prevtempOrder.nextOrder = order;
        order.nextOrder = tempOrder;
    }

    @Override
    public void printList() {
        System.out.print("[");
        if (isEmpty()) {
            System.out.print("Empty  ");
        } else {
            Order tempOrder = front;
            while (tempOrder != null) {
                System.out.print(tempOrder.getOrderId() + ", "+tempOrder.getPhoneNumber()+", ");
                tempOrder = tempOrder.nextOrder;
            }
        }
        System.out.println("\b\b]");
    }

    @Override
    public Order getLast() {
        Order tempOrder=front;
        if(tempOrder==null){
            return tempOrder;
        }else{
            while(tempOrder.nextOrder!=null){
                tempOrder=tempOrder.nextOrder;
            }
            return tempOrder;
        }
    }

    @Override
    public Order getFront() {
        return front;
    }
    
    @Override
    public void setFront(Order order){
        front=order;
    }

   

    
}
