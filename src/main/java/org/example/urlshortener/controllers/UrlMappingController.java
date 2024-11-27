package org.example.urlshortener.controllers;

import org.example.urlshortener.dto.ShortenUrlRequest;
import org.example.urlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlMappingController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    public UrlMappingController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }
    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody ShortenUrlRequest request) {
        System.out.println(request.toString());
        System.out.println(request.getLongUrl());
        String shortUrl = urlShortenerService.shortenUrl(request.getLongUrl());
        return ResponseEntity.ok(shortUrl);
    }
}
