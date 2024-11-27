package org.example.urlshortener.repository;

import org.example.urlshortener.models.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    List<UrlMapping> getUrlMappingById(Long id);
    List<UrlMapping> getUrlMappingByShortUrl(String shortUrl);
    Optional<UrlMapping> getUrlMappingByLongUrl(String longUrl);
    Optional<UrlMapping> findByShortUrl(String shortUrl);
}
