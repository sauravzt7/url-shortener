package org.example.urlshortener.dto;

public class ShortenUrlResponse {

    private String shortUrl;

    // Default constructor
    public ShortenUrlResponse() {}

    // Constructor
    public ShortenUrlResponse(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    // Getters and Setters
    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

}
