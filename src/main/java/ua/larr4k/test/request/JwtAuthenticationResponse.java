package ua.larr4k.test.request;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";


    public JwtAuthenticationResponse(String jwt) {
        this.accessToken = jwt;
    }
}