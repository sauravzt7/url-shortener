package org.example.urlshortener.controllers;

import jakarta.transaction.Transactional;
import org.example.urlshortener.repository.UrlMappingRepository;
import org.example.urlshortener.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class UrlRedirectController {

    @Autowired
    private UrlShortenerService urlShortenerService;
    @Autowired
    private UrlMappingRepository urlMappingRepository;

    public UrlRedirectController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> getUrl(@PathVariable String shortUrl) {
        System.out.println("In getUrl");
        System.out.println(shortUrl);
        // Basic validation to ignore requests like "favicon.ico"
        String longUrl = urlShortenerService.getLongUrl(shortUrl);
//        incrementAccessCount(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longUrl)).build();
    }

    @Async
    @Transactional
    public void incrementAccessCount(String shortUrl) {
        urlMappingRepository.findByShortUrl(shortUrl).ifPresent(urlMapping -> {
            urlMapping.setAccessCount(urlMapping.getAccessCount() + 1);
            urlMappingRepository.save(urlMapping);
        });
    }

}
