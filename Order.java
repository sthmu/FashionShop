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
public class Order {
    Order nextOrder;

    private String orderId;
    private String phone_number;
    private String size;
    private String order_status;
    private int qty;

    {
        order_status = "PROCESSING";
    }

    Order() {
    }

    Order(
            String orderId,
            String phone_number,
            String size,
            //double price,
            String order_status,
            int qty) {
        this.orderId = orderId;
        this.size = size;
        this.phone_number = phone_number;
        this.order_status = order_status;
        // this.price = price;
        this.qty = qty;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setPhoneNumber(String phone) {
        this.phone_number = phone;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setOrderStatus(String order_status) {
        this.order_status = order_status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getSize() {
        return size;
    }

    public int getQty() {
        return qty;
    }

    public String getOrderStatus() {
        return order_status;
    }

    
}
