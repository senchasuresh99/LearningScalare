package com.scaler.ecom.payment.controllers;

import com.scaler.ecom.payment.services.IPaymentService;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private IPaymentService iPaymentService;

    public PaymentController(IPaymentService iPaymentService){
        this.iPaymentService = iPaymentService;
    }

    @GetMapping("/initiate")
    public String generatePaymentLink(@RequestParam("orderId") String orderId) throws StripeException {
        return iPaymentService.generatePaymentLink(orderId);
    }
}
