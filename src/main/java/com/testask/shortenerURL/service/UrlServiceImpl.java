package com.testask.shortenerURL.service;

import com.testask.shortenerURL.domain.Tag;
import com.testask.shortenerURL.domain.Url;
import com.testask.shortenerURL.domain.User;
import com.testask.shortenerURL.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Implementation of {@link UrlService} interface.
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

@Service
@Transactional
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Override
    public void addUrl(Url url) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext().getAuthentication()
                .getPrincipal();
        String currentUserName = userDetails.getUsername();
        User user = this.userService.getUser(currentUserName);
        url.setUser(user);
        addTagToUrl(url);
        this.urlRepository.addUrl(url);
    }

    @Override
    public List<Url> listUrls() {
        return urlRepository.listUrls();
    }

    @Override
    public void removeUrl(long id) {
        urlRepository.removeUrl(id);
    }

    @Override
    public Url getUrlByID(long id) {
         return urlRepository.getUrlById(id);
    }

    @Override
    public List<Url> getUrlsByTag(String nameTag) {
        return urlRepository.getUrlsByTag(nameTag);
    }

    @Override
    public void updateUrl(Url url) {
        addTagToUrl(url);
        this.urlRepository.updateUrl(url);
    }

    @Override
    public List<Url> listUserUrls(String currentUserName) {
        return urlRepository.listUserUrls(currentUserName);
    }

    private void addTagToUrl(Url url){
        Tag tag = url.getTag();
        String nameTag = tag.getNameTag();
        Tag tagN = this.tagService.tagByName(nameTag);
        if (tagN != null){
            url.setTag(tagN);
        }else{
            this.tagService.addTag(tag);
        }
    }

}
