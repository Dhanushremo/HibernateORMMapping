package com.hibernate.manager;
import com.hibernate.model.Orders;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Customer;
import com.hibernate.model.CustomerDetails;

import org.hibernate.SessionFactory;

public class HibernateManager {
   private static SessionFactory sf;
    static {
      sf= new Configuration().configure()
              .addAnnotatedClass(Customer.class)
              .addAnnotatedClass(CustomerDetails.class)
              .addAnnotatedClass(Orders.class)
              .buildSessionFactory();
    }

    public int save(CustomerDetails cd){
      Session s = sf.openSession();
      s.beginTransaction();
      s.persist(cd);
      s.getTransaction().commit();
      return 1;
    }

    public void delete(int id){
        Session s = sf.openSession();
        s.beginTransaction();
      Customer c = s.get(Customer.class,id);
      if(c!=null){
          s.remove(c);
          System.out.println("Customer DELETED successfully");
      }else {
          System.out.println("Customer Deleted!!");
      }
    }

}
