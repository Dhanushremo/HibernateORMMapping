package com.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name="customerDetails")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cdId")
    private int cdId;
    @Column(name="cdGender")
    private String cdGender;
    @Column(name="cdEmail")
    private String cdEmail;
    @Column(name="cdPhone")
    private String cdPhone;
    //we have to tell the mapped Reference in CutomerClass!!
    @OneToOne( mappedBy = "cd", cascade = CascadeType.ALL)
    private Customer c;

    public CustomerDetails(String cdGender, String cdEmail, String cdPhone) {
        this.cdGender = cdGender;
        this.cdEmail = cdEmail;
        this.cdPhone = cdPhone;
    }

    public int getCdId() {
        return cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    public String getCdGender() {
        return cdGender;
    }

    public void setCdGender(String cdGender) {
        this.cdGender = cdGender;
    }

    public String getCdEmail() {
        return cdEmail;
    }

    public void setCdEmail(String cdEmail) {
        this.cdEmail = cdEmail;
    }

    public String getCdPhone() {
        return cdPhone;
    }

    public void setCdPhone(String cdPhone) {
        this.cdPhone = cdPhone;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "cdId=" + cdId +
                ", cdGender='" + cdGender + '\'' +
                ", cdEmail='" + cdEmail + '\'' +
                ", cdPhone='" + cdPhone + '\'' +
                '}';
    }
}
