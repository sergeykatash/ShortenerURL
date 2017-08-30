package com.testask.shortenerURL.controller;

import com.testask.shortenerURL.domain.Url;
import com.testask.shortenerURL.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UrlController {

    private UrlRepository urlRepository;

    @Autowired
    public UrlController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String getUrls(Model model){
        List<Url> urls = this.urlRepository.listUrls();
        model.addAttribute("urls", urls);
        return "index";
    }
}
