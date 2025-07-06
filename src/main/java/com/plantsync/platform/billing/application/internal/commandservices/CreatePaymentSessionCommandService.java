package com.plantsync.platform.billing.application.internal.commandservices;

import com.plantsync.platform.billing.infrastructure.providers.StripePaymentProvider;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class CreatePaymentSessionCommandService {

    private final StripePaymentProvider paymentProvider;

    public CreatePaymentSessionCommandService(StripePaymentProvider paymentProvider) {
        this.paymentProvider = paymentProvider;
    }

    public String createSession() throws StripeException {

        return paymentProvider.createCheckoutSession(
                1000L, // $10.00 USD
                "http://localhost:4200/payment-success",
                "http://localhost:4200/payment-cancel"
        );
    }
}
