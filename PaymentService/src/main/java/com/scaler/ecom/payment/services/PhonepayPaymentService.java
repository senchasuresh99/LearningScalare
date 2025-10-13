package com.scaler.ecom.payment.services;

public class PhonepayPaymentService implements IPaymentService{
    @Override
    public String generatePaymentLink(String orderId) {
        return "Phone pay does not support!";
    }
}
