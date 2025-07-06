package com.plantsync.platform.billing.interfaces;

import com.plantsync.platform.billing.application.internal.commandservices.CreatePaymentSessionCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final CreatePaymentSessionCommandService commandService;

    public PaymentController(CreatePaymentSessionCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping("/create-session")
    public ResponseEntity<Map<String, String>> createSession() throws StripeException {
        String url = commandService.createSession();
        return ResponseEntity.ok(Map.of("url", url));
    }
}
