package com.training.experis.data;

import java.util.Date;

public class InvoiceItems {
    private final String id;
    private final String invoiceId;
    private final String trackId;
    private final float unitPrice;
    private final int quantity;

    public InvoiceItems(String id, String invoiceId, String trackId, float unitPrice, int quantity) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.trackId = trackId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InvoiceItems{" +
                "id=" + id +
                ", invoiceId=" + invoiceId +
                ", trackId=" + trackId +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }
}
