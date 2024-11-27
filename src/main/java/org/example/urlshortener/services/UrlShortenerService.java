package org.example.urlshortener.services;

import org.example.urlshortener.models.UrlMapping;
import org.example.urlshortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.example.urlshortener.utils.HashGenerator.generateShortUrl;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlMappingRepository urlMappingRepository;

    public UrlShortenerService(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    public String shortenUrl(String longUrl) {

        System.out.println("In UrlShortenerService.shortenUrl");
        Optional<UrlMapping> urlMapping = urlMappingRepository.getUrlMappingByLongUrl(longUrl);

        if(urlMapping.isPresent()) {
            String shortUrl = urlMapping.get().getShortUrl();
            System.out.println("short url: " + "http://" + "bet.ly/" + shortUrl);
            return shortUrl;
        }
        String newShortUrl = generateShortUrl(longUrl);
        UrlMapping newUrlMapping = new UrlMapping();
        newUrlMapping.setLongUrl(longUrl);
        newUrlMapping.setShortUrl(newShortUrl);
        newUrlMapping.setCreatedTimeStamp(LocalDateTime.now());
        urlMappingRepository.save(newUrlMapping);
        System.out.println("Generated New short url: " + newShortUrl);
        return "http://" + "bet.ly/" + newShortUrl;
    }

    public String getLongUrl(String shortUrl) {
        List<UrlMapping> urlMappingList =  urlMappingRepository.getUrlMappingByShortUrl(shortUrl);

        System.out.println(urlMappingList.toString());
        System.out.println(urlMappingList.size());
        return urlMappingList.get(0).getLongUrl();
    }

}
