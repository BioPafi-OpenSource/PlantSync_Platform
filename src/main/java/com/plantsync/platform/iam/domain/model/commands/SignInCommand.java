package com.plantsync.platform.iam.domain.model.commands;


/**
 * Sign in command
 * <p>
 *     This class represents the command to sign in a user.
 * </p>
 * @param username the email of the user
 * @param password the password of the user
 *
 */
public record SignInCommand(String username, String password) {
}