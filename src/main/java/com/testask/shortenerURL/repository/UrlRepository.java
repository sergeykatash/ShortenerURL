package com.testask.shortenerURL.repository;


import com.testask.shortenerURL.domain.Url;

import java.util.List;

public interface UrlRepository {

    void addUrl(Url url);
    List<Url> listUrls();
    void removeUrl(long id);
    Url getUrlById(long id);
    List<Url> getUrlsByTag(String tag);

    void updateUrl(Url url);
}
