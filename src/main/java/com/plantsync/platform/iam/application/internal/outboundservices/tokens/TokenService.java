package com.plantsync.platform.iam.application.internal.outboundservices.tokens;


/**
 * TokenService interface
 * This interface is used to generate and validate tokens
 */
public interface TokenService {

    /**
     * Generate a token for a given email
     * @param email the email
     * @return String the token
     */
    String generateToken(String email);

    /**
     * Extract the email from a token
     * @param token the token
     * @return String the email
     */
    String getEmailFromToken(String token);

    /**
     * Validate a token
     * @param token the token
     * @return boolean true if the token is valid, false otherwise
     */
    boolean validateToken(String token);
}
