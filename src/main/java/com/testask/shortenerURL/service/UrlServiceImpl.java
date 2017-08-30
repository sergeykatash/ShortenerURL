package com.testask.shortenerURL.service;

import com.testask.shortenerURL.domain.Url;
import com.testask.shortenerURL.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public void addUrl(Url url) {
        urlRepository.addUrl(url);
    }

    @Override
    public List<Url> listUrls() {
        return urlRepository.listUrls();
    }

    @Override
    public void removeUrl(long id) {
        urlRepository.removeUrl(id);
    }
}
