package com.scaler.ecom.payment.services;

import com.stripe.exception.StripeException;

public interface IPaymentService {
    String generatePaymentLink(String orderId) throws StripeException;
}
