package org.example.urlshortener.dto;

import jakarta.validation.constraints.NotBlank;

public class ShortenUrlRequest {

    @NotBlank(message = "URL cannot be blank")
    private String longUrl;

    // Default constructor
    public ShortenUrlRequest() {}

    // Getters and Setters
    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
