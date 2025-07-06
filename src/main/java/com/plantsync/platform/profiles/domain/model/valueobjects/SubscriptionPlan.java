package com.plantsync.platform.profiles.domain.model.valueobjects;

public enum SubscriptionPlan {
    BASIC,
    PREMIUM,
    PRO;

    public static SubscriptionPlan fromString(String value) {
        return switch (value.toLowerCase()) {
            case "free" -> BASIC;

            case "premium" -> PREMIUM;

            case "pro" -> PRO;


            default -> throw new IllegalArgumentException("Invalid subscription plan: " + value);
        };
    }
}
