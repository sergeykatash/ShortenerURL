package com.testask.shortenerURL.service;

import com.testask.shortenerURL.domain.Tag;


public interface TagService {

    void addTag(Tag tag);
    Tag tagByName(String nameTag);
}
