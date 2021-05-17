package com.training.experis;

import java.util.Date;

public class Invoice {
    private final int id;
    private final int customerId;
    private final Date invoiceDate;
    private final String billingAddress;
    private final String billingCity;
    private final String billingState;
    private final String billingCountry;
    private final String billingPostalCode;
    private final float total;

    public Invoice(int id, int customerId, Date invoiceDate, String billingAddress, String billingCity, String billingState,
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
