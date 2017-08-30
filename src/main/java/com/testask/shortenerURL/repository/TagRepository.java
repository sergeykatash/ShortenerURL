package com.testask.shortenerURL.repository;

import com.testask.shortenerURL.domain.Tag;


public interface TagRepository {

    void addTag(Tag tag);
    Tag tagByName(String nameTag);

}
