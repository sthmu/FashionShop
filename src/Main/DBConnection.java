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
public class DBConnection {
    private OrderList initialOrderList;
    private static DBConnection dBConnection;
    DBConnection(){
        initialOrderList=new OrderListImpl();        
    }
    
    public static DBConnection  getInstance(){
        if(dBConnection==null){
            dBConnection=new DBConnection();
        }
        return dBConnection;
    }
    public OrderList getOrderList(){
        return initialOrderList;
    }
}
