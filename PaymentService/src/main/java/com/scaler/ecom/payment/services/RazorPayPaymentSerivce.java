package com.scaler.ecom.payment.services;

public class RazorPayPaymentSerivce implements IPaymentService{
    @Override
    public String generatePaymentLink(String orderId) {
        return "Razorpay does not support!";
    }
}
