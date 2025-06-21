package com.plantsync.platform.iam.interfaces.rest.resources;

import java.util.List;

public record SignUpResource(String email, String password, String name, String subscriptionPlan) {
}