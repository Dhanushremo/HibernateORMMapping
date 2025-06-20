package com.hibernate.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cId")
    private int cId;
    @Column(name="cName")
    private String cName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cdId")
    private CustomerDetails cd;

    @OneToMany(mappedBy = "c",cascade = CascadeType.ALL)
    private List<Orders> orders;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Customer(String cName) {
        this.cName = cName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public CustomerDetails getCd() {
        return cd;
    }

    public void setCd(CustomerDetails cd) {
        this.cd = cd;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                '}';
    }
}
