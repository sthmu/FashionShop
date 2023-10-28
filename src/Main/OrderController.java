/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class OrderController {

    public static String[] sizes = {"XS", "S", "M", "L", "XL", "XXL"};
    public static int[] prices = {600, 800, 900, 1000, 1100, 1200};

    public static void placeOrder(String orderId, String phone, String size, String order_status, int qty) {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        Order temp_order = new Order(orderId, phone, size, order_status, qty);
        orderList.add(temp_order);

    }

    public static String createOrderId() {
        OrderList orderList = DBConnection.getInstance().getOrderList();

        Order temp = orderList.getLast();
        String orderId = "";
        if (temp == null) {
            return "ODR#000001";
        } else {
            orderId = temp.getOrderId();
        }

        String orderNum = "";
        for (int i = 4; i <10; i++) {
            orderNum += orderId.charAt(i);
        }

        //not OrderNumber is like 0004
        int orderNum2 = Integer.parseInt(orderNum) + 1;
        orderNum = String.valueOf(orderNum2);
        for (int i = orderNum.length(); i < 6; i++) {
            orderNum = "0" + orderNum;
        }
        return "ODR#" + orderNum;
    }

    public static Order[] getReferenceListByPhone(String phone) {
        Order tempOrder = DBConnection.getInstance().getOrderList().getFront();

        Order[] refferences = new Order[0];
        while (tempOrder != null) {
            if (tempOrder.getPhoneNumber().equals(phone)) {
                Order[] temprefferences = new Order[refferences.length + 1];
                for (int i = 0; i < refferences.length; i++) {
                    temprefferences[i] = refferences[i];
                }
                refferences = temprefferences;
                if (refferences.length != 0) {
                    refferences[refferences.length - 1] = tempOrder;
                }
            }
            tempOrder = tempOrder.nextOrder;
        }
        return refferences;
    }

    public static Order getReferenceByOrder(String OrderId) {
        Order tempOrder = DBConnection.getInstance().getOrderList().getFront();
        while (tempOrder != null) {
            if (tempOrder.getOrderId().equals(OrderId)) {
                return tempOrder;
            }
            tempOrder = tempOrder.nextOrder;
        }
        return tempOrder;
    }

    public static int getIndexInSizes(String size) {
        for (int i = 0; i < sizes.length; i++) {
            if (size.equals(sizes[i])) {
                return i;
            }
        }
        return -1;
    }

    public static Order getOrderByIndex(int index) {
        Order tempOrder = DBConnection.getInstance().getOrderList().getFront();
        int i = 0;
        for (; i < index; i++) {
            if (tempOrder.nextOrder == null & (index - i) > 0) {
                System.out.println("out of bound index");
                return null;
            }
            tempOrder = tempOrder.nextOrder;
        }
        return tempOrder;
    }

    public static void deleteOrderByIndex(int index) {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        if (index == 0) {
            orderList.setFront(orderList.getFront().nextOrder);
        } else {
            Order prevOrder = getOrderByIndex(index - 1);
            prevOrder.nextOrder = getOrderByIndex(index + 1);
        }

    }

    public static Object[][] getBestInCustomers() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        Object[][] tableRows = new Object[0][];
        Order tempOrder = orderList.getFront();
        while (tempOrder != null) {
            String phone = tempOrder.getPhoneNumber();
            int qty = tempOrder.getQty();
            String size = tempOrder.getSize();
            double amount = qty * prices[getIndexInSizes(size)];

            //check if the customer id is already in the tableRows;
            int index = getIndexInObjects(tableRows, phone);
            if (index != -1) {
                //If the customer is already at the table then add values to him
                tableRows[index][1] = qty + (int) tableRows[index][1];
                tableRows[index][2] = amount + (int) tableRows[index][1];
            } else if (index == -1) {
                //if the customer not already in the table then do this

                tableRows = increaseLen(tableRows, 1, 3);

                tableRows[tableRows.length - 1][0] = phone;
                tableRows[tableRows.length - 1][1] = qty;
                tableRows[tableRows.length - 1][2] = amount;

            }
            tempOrder = tempOrder.nextOrder;
        }
        sortObjectArr(tableRows, 2);
        return tableRows;
    }

    public static Object[][] getViewCustomers() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        Object[][] tableRows = new Object[0][3];
        Order tempOrder = orderList.getFront();
        while (tempOrder != null) {
            String phone = tempOrder.getPhoneNumber();
            int qty = tempOrder.getQty();
            String size = tempOrder.getSize();
            double amount = qty * prices[getIndexInSizes(size)];

            //check if the customer id is already in the tableRows;
            int index = getIndexInObjects(tableRows, phone);
            if (index != -1) {
                //If the customer is already at the table then add values to him
                tableRows[index][1] = qty + (int) tableRows[index][1];
                tableRows[index][2] = amount + (int) tableRows[index][1];
            } else if (index == -1) {
                //if the customer not already in the table then do this

                tableRows = increaseLen(tableRows, 1, 3);

                tableRows[tableRows.length - 1][0] = phone;
                tableRows[tableRows.length - 1][1] = qty;
                tableRows[tableRows.length - 1][2] = amount;

            }
            tempOrder = tempOrder.nextOrder;
        }

        return tableRows;
    }

    private static Object[][] increaseLen(Object[][] objectArr, int increaseBy, int subArraySize) {
        Object[][] tempObjectArr = new Object[objectArr.length + increaseBy][subArraySize];

        for (int i = 0; i < objectArr.length; i++) {
            tempObjectArr[i] = objectArr[i];
        }
        return tempObjectArr;

    }

    private static int getIndexInObjects(Object[][] rows, Object item) {
        if (rows.length > 0) {
            for (int i = 0; i < rows.length; i++) {
                if (rows[i][0].equals(item)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static void sortObjectArr(Object[][] arr, int byIndex) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if ((double) arr[i][byIndex] < (double) arr[j][byIndex]) {
                    Object temp[] = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static Object[][] getAllCustomerDetails() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        Object[][] tableRows = new Object[0][8];
        Order tempOrder = orderList.getFront();
        while (tempOrder != null) {
            String phone = tempOrder.getPhoneNumber();
            int qty = tempOrder.getQty();
            String size = tempOrder.getSize();
            double amount = qty * prices[getIndexInSizes(size)];

            //check if the customer id is already in the tableRows;
            int index = getIndexInObjects(tableRows, phone);
            if (index != -1) {
                //If the customer is already at the table then add values to him

                int qtyInTheSize = (tableRows[index][getIndexInSizes(size) + 1]) != null ? ((int) tableRows[index][getIndexInSizes(size) + 1]) : 0;

                tableRows[index][getIndexInSizes(size) + 1] = qty + qtyInTheSize;
                tableRows[index][7] = amount + (double) tableRows[index][7];
            } else if (index == -1) {
                //if the customer not already in the table then do this

                tableRows = increaseLen(tableRows, 1, 8);

                tableRows[tableRows.length - 1][0] = phone;
                tableRows[tableRows.length - 1][7] = amount;
                System.out.println((getIndexInSizes(size) + 1) + "index of the sizes to be entered to tableRow");
                tableRows[tableRows.length - 1][getIndexInSizes(size) + 1] = qty;
                tableRows[tableRows.length - 1][7] = amount;

            }
            tempOrder = tempOrder.nextOrder;
        }

        return tableRows;
    }

    public static Object[][] getItemsByQty() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        Object[][] tableRows = new Object[6][3];

        for (int i = 0; i < tableRows.length; i++) {
            tableRows[i][0] = sizes[i];
            tableRows[i][1] = 0d;
            tableRows[i][2] = 0.0d;
        }

        Order tempOrder = orderList.getFront();
        while (tempOrder != null) {
            int qty = tempOrder.getQty();
            String size = tempOrder.getSize();
            int index = getIndexInSizes(size);
            double amount = prices[index] * qty;
            tableRows[index][1] = qty + (double) tableRows[index][1];
            tableRows[index][2] = amount + (double) tableRows[index][2];
            tempOrder = tempOrder.nextOrder;
        }
        sortObjectArr(tableRows, 1);
        return tableRows;
    }

    public static Object[][] getItemsBtAmount() {
        OrderList orderList = DBConnection.getInstance().getOrderList();
        Object[][] tableRows = new Object[6][3];

        for (int i = 0; i < tableRows.length; i++) {
            tableRows[i][0] = sizes[i];
            tableRows[i][1] = 0d;
            tableRows[i][2] = 0.0d;
        }

        Order tempOrder = orderList.getFront();
        while (tempOrder != null) {
            int qty = tempOrder.getQty();
            String size = tempOrder.getSize();
            int index = getIndexInSizes(size);
            double amount = prices[index] * qty;
            tableRows[index][1] = qty + (double) tableRows[index][1];
            tableRows[index][2] = amount + (double) tableRows[index][2];
            tempOrder = tempOrder.nextOrder;
        }
        return tableRows;

    }

    public static Object[][] getAllOrders(){
        OrderList orderList=DBConnection.getInstance().getOrderList();
        Object[][] tableRows=new Object[0][6];
        Order tempOrder=orderList.getFront();
        for(int i=0;tempOrder!=null;i++){
            tableRows=increaseLen(tableRows,1,6);
            String orderId=tempOrder.getOrderId();
            String customerId=tempOrder.getPhoneNumber();
            String size=tempOrder.getSize();
            int qty=tempOrder.getQty();
            double amount=qty*prices[getIndexInSizes(size)];
            String status=tempOrder.getOrderStatus();
            System.out.println("tableRows[i][0]"+tableRows[i][0]);
            tableRows[i][0]=orderId;
            tableRows[i][1]=customerId;
            tableRows[i][2]=size;
            tableRows[i][3]=qty;
            tableRows[i][4]=amount;
            tableRows[i][5]=status;
            tempOrder=tempOrder.nextOrder;
        }
        return tableRows;
    }
    
    public static Object[][] getAllOrdersByAmount(){
        OrderList orderList=DBConnection.getInstance().getOrderList();
        Object[][] tableRows=new Object[0][6];
        Order tempOrder=orderList.getFront();
        for(int i=0;tempOrder!=null;i++){
            tableRows=increaseLen(tableRows,1,6);
            String orderId=tempOrder.getOrderId();
            String customerId=tempOrder.getPhoneNumber();
            String size=tempOrder.getSize();
            int qty=tempOrder.getQty();
            double amount=qty*prices[getIndexInSizes(size)];
            String status=tempOrder.getOrderStatus();
            tableRows[i][0]=orderId;
            tableRows[i][1]=customerId;
            tableRows[i][2]=size;
            tableRows[i][3]=qty;
            tableRows[i][4]=amount;
            tableRows[i][5]=status;
            tempOrder=tempOrder.nextOrder;
        }
        sortObjectArr(tableRows, 4);
        return tableRows;
    }
    
    public static boolean validatePhone(String phone){
        if(phone.length()>10 || phone.length()<10){
            return false;
        }
        return true;
    }
    public static boolean validateOrderId(String orderId){
        if(orderId.length()>10 || orderId.length()<10){
            return false;
        } 
        return true;
    }
    private static boolean validateQty(int qty){
        if(qty>0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean validate(String orderId,String phone,int qty){
        boolean isPhoneValid=validatePhone(phone);
        boolean isOrderIdValid=validateOrderId(orderId);
        boolean isQtyValid=validateQty(qty);
        
        if(!isPhoneValid){
            JOptionPane.showMessageDialog(null, "Phone Number is not valid");
            return false;
        }
        else if(!isOrderIdValid){
            JOptionPane.showMessageDialog(null,"Order Id is not valid");
            return false;
        }
        else if(!isQtyValid){
            JOptionPane.showMessageDialog(null,"Entered Qty is not valid");
            return false;
        }
        else{
        return true;
         }
        
    }
}
