package com.training.experis.data;

import java.util.Date;

public class Invoice {
    private final String id;
    private final String customerId;
    private final Date invoiceDate;
    private final String billingAddress;
    private final String billingCity;
    private final String billingState;
    private final String billingCountry;
    private final String billingPostalCode;
    private final float total;

    public Invoice(String id, String customerId, Date invoiceDate, String billingAddress, String billingCity, String billingState,
                   String billingCountry, String billingPostalCode, float total) {
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
                "id=" + id +
                ", customerId=" + customerId +
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
