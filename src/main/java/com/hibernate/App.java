package com.hibernate;

import com.hibernate.manager.HibernateManager;
import com.hibernate.model.Customer;
import com.hibernate.model.CustomerDetails;
import com.hibernate.model.Orders;

import java.util.ArrayList;

public class App {
    public static void main( String[] args ) {
        HibernateManager hm=new HibernateManager();
        System.out.println("Customer Saving");
        Customer c=new Customer("Rock");
        CustomerDetails cd=new CustomerDetails("Male","rock@gdn","8790820213");
        c.setCd(cd);
        cd.setC(c);

        System.out.println("Orders Saving");
        ArrayList<Orders> orders=new ArrayList<>();
        Orders o1=new Orders("Chapati",15);
        Orders o2=new Orders("ChickenRice",80);
        Orders o3=new Orders("Kabab",60);
        Orders o4=new Orders("LemonJuice",10);
        Orders o5=new Orders("GulabJamun",15);

        orders.add(o1);
        orders.add(o2);
        orders.add(o3);
        orders.add(o4);
        orders.add(o5);

        c.setOrders(orders);
        o1.setC(c);
        o2.setC(c);
        o3.setC(c);
        o4.setC(c);
        o5.setC(c);

        int status=hm.save(cd);
        if(status!=0){
            System.out.println("SUCCESSFULLY SAVED!!");
        }





    }
}
