package com.plantsync.platform.billing.interfaces.rest.resources;

public record CreatePaymentSessionResource(
        Long userId,
        String subscriptionPlan
) {}
