package com.training.experis;

import java.util.Date;

public class InvoiceItems {
    private final int id;
    private final int invoiceId;
    private final int trackId;
    private final float unitPrice;
    private final int quantity;

    public InvoiceItems(int id, int invoiceId, int trackId, float unitPrice, int quantity) {
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
