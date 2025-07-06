package com.plantsync.platform.iam.interfaces.rest.resources;


import java.util.List;

public record SignUpResource(
        String name,
        String email,
        String password,
        String subscriptionPlan
) {}
