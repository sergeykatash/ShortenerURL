package com.testask.shortenerURL.domain;


import javax.persistence.*;

@Entity
@Table(name = "urls")
public class Url {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idLink;

    @Column(name = "url")
    private String url;

    @Column(name = "shorturl")
    private String shortUrl;

    @Column(name = "description")
    private String description;

    public Long getIdLink() {
        return idLink;
    }

    public void setIdLink(Long idLink) {
        this.idLink = idLink;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Url{" +
                "idLink=" + idLink +
                ", url='" + url + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
