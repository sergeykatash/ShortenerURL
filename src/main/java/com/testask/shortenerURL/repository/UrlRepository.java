package com.testask.shortenerURL.repository;

import com.testask.shortenerURL.domain.Url;

import java.util.List;

/**
 * Repository for {@link com.testask.shortenerURL.domain.Url}
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

public interface UrlRepository {

    void addUrl(Url url);
    List<Url> listUrls();
    void removeUrl(long id);
    Url getUrlById(long id);
    List<Url> getUrlsByTag(String tag);
    void updateUrl(Url url);
    List<Url> listUserUrls(String currentUserName);
}
