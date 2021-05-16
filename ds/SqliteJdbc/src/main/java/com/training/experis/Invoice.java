package com.training.experis;

import java.util.Date;

public class Invoice {
    private String id;
    private String customerId;
    private Date invoiceDate;
    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingPostalCode;
    private float total;

    public Invoice(String id, String customerId, Date invoiceDate, String billingAddress, String billingCity,
                   String billingState, String billingCountry, String billingPostalCode, float total) {
        this.id = id;
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.billingAddress = billingAddress;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingCountry = billingCountry;
        this.billingPostalCode = billingPostalCode;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", billingAddress='" + billingAddress + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", billingState='" + billingState + '\'' +
                ", billingCountry='" + billingCountry + '\'' +
                ", billingPostalCode='" + billingPostalCode + '\'' +
                ", total=" + total +
                '}';
    }
}
