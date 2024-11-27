package org.example.urlshortener.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="url_mapping")
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="long_url", nullable = false)
    private String longUrl;

    @Column(name="short_url", nullable = false, unique = true)
    private String shortUrl;

    @Column(name="created_at")
    private LocalDateTime createdTimeStamp;
    @Column(name = "access_count")
    private Integer accessCount = 0;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public LocalDateTime getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Integer getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }
}
