package com.testask.shortenerURL.controller;

import com.testask.shortenerURL.domain.Tag;
import com.testask.shortenerURL.domain.Url;
import com.testask.shortenerURL.repository.UrlRepository;
import com.testask.shortenerURL.service.TagService;
import com.testask.shortenerURL.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UrlController {

    private UrlService urlService;
    private TagService tagService;

    @Autowired
    public UrlController(UrlService urlService, TagService tagService) {
        this.urlService = urlService;
        this.tagService = tagService;
    }

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String getUrls(Model model){
        List<Url> urls = this.urlService.listUrls();
        model.addAttribute("urls", urls);
        return "index";
    }

    @RequestMapping(value= "addUrl", method = RequestMethod.GET)
    public String addUrl(Model model){
        model.addAttribute("url", new Url());
        return "addUrl";
    }

    @RequestMapping(value= "addUrl", method = RequestMethod.POST)
    public String addUrl(@ModelAttribute("url") Url url){
        Tag tag = url.getTag();
        String nameTag = tag.getNameTag();
        Tag tagN = this.tagService.tagByName(nameTag);
        if (tagN != null){
            url.setTag(tagN);
        }else{
            this.tagService.addTag(tag);
        }
        this.urlService.addUrl(url);
        return "redirect:/";
    }

    @RequestMapping(value= "deleteUrl/{id}", method = RequestMethod.GET)
    public String deleteUrl(@PathVariable Long id){
        this.urlService.removeUrl(id);
        return "redirect:/";
    }


}
