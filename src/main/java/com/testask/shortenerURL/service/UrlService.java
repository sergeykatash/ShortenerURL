package com.testask.shortenerURL.service;

import com.testask.shortenerURL.domain.Url;

import java.util.List;

/**
 * Created by user on 30.08.2017.
 */
public interface UrlService {
     void addUrl(Url url);
     List<Url> listUrls();
     void removeUrl(long id);
}
