package com.plantsync.platform.iam.interfaces.rest.resources;

import java.util.List;

public record UserResource(Long id, String email, String password) {
}