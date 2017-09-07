package com.testask.shortenerURL.service;

import com.testask.shortenerURL.domain.Url;
import java.util.List;

/**
 * Service for {@link com.testask.shortenerURL.domain.Url}
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

public interface UrlService {
     void addUrl(Url url);
     List<Url> listUrls();
     void removeUrl(long id);
     Url getUrlByID(long id);
     List<Url> getUrlsByTag(String tag);
     void updateUrl(Url url);
     List<Url> listUserUrls(String currentUserName);
}
