package com.testask.shortenerURL.repository;

import com.testask.shortenerURL.domain.Tag;

/**
 * Repository for {@link com.testask.shortenerURL.domain.Tag}
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

public interface TagRepository {

    void addTag(Tag tag);
    Tag tagByName(String nameTag);

}
