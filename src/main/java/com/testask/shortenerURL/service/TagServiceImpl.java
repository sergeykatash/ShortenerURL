package com.testask.shortenerURL.service;


import com.testask.shortenerURL.domain.Tag;
import com.testask.shortenerURL.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public void addTag(Tag tag) {
        this.tagRepository.addTag(tag);
    }

    @Override
    public Tag tagByName(String nameTag) {
        return this.tagRepository.tagByName(nameTag);
    }
}
