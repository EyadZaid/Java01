package com.training.experis;

import java.util.Date;

public class InvoiceItems {
    private final String invoiceId;
    private final String customerId;
    private final Date invoiceDate;
    private final String billingCity;
    private final String billingState;
    private final String billingCountry;
    private final String billingPostalCode;
    private final float total;

    public InvoiceItems(String invoiceId, String customerId, Date invoiceDate, String billingCity,
                        String billingState, String billingCountry, String billingPostalCode, float total) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingCountry = billingCountry;
        this.billingPostalCode = billingPostalCode;
        this.total = total;
    }

    @Override
    public String toString() {
        return "InvoiceItems{" +
                "invoiceId='" + invoiceId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", billingCity='" + billingCity + '\'' +
                ", billingState='" + billingState + '\'' +
                ", billingCountry='" + billingCountry + '\'' +
                ", billingPostalCode='" + billingPostalCode + '\'' +
                ", total=" + total +
                '}';
    }
}
