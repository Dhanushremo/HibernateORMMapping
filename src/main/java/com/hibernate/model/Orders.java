package com.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="oiD")
    private int oId;
    @Column(name = "iteamName")
    private String iteamName;
    @Column(name = "price")
    private float price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cId")
    private Customer c;

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public Orders(String iteamName, float price) {
        this.iteamName = iteamName;
        this.price = price;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getIteamName() {
        return iteamName;
    }

    public void setIteamName(String iteamName) {
        this.iteamName = iteamName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
