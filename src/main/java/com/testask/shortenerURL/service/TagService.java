package com.testask.shortenerURL.service;

import com.testask.shortenerURL.domain.Tag;

/**
 * Service for {@link com.testask.shortenerURL.domain.Tag}
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

public interface TagService {

    void addTag(Tag tag);
    Tag tagByName(String nameTag);
}
