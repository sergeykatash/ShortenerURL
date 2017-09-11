package com.testask.shortenerURL.controller;

import com.testask.shortenerURL.domain.Role;
import com.testask.shortenerURL.domain.Tag;
import com.testask.shortenerURL.domain.Url;
import com.testask.shortenerURL.domain.User;
import com.testask.shortenerURL.service.TagService;
import com.testask.shortenerURL.service.UrlService;
import com.testask.shortenerURL.service.UserService;
import com.testask.shortenerURL.validator.UrlValidator;
import com.testask.shortenerURL.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller.
 *
 * @author Sergey Katashevich
 * @version 1.0
 */

import java.util.List;

@Controller
public class UrlController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UrlValidator urlValidator;

    @Autowired
    private UrlService urlService;

    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String getUrls(Model model){
        model.addAttribute("urls", this.urlService.listUrls());
        return "index";
    }

    @RequestMapping(value= "signup", method = RequestMethod.GET)
    public String getUserUrls(Model model){
        String currentUserName =((UserDetails) SecurityContextHolder.
                getContext().getAuthentication().
                getPrincipal()).getUsername();
        List<Url> urls = this.urlService.listUserUrls(currentUserName);
        model.addAttribute("urls", urls);
        return "signup";
    }

    @RequestMapping(value= "addUrl", method = RequestMethod.GET)
    public String addUrl(Model model){
        model.addAttribute("url", new Url());
        return "addUrl";
    }

    @RequestMapping(value= "addUrl", method = RequestMethod.POST)
    public String addUrl(@ModelAttribute("url") Url url, BindingResult bindingResult){
        urlValidator.validate(url, bindingResult);
        if (bindingResult.hasErrors()){
            return "addUrl";
        }
        this.urlService.addUrl(url);
        return "redirect:/signup";
    }

    @RequestMapping(value= "deleteUrl/{id}", method = RequestMethod.GET)
    public String deleteUrl(@PathVariable Long id){
        this.urlService.removeUrl(id);
        return "redirect:/signup";
    }

    @RequestMapping(value = "/getUrl{id}", method = RequestMethod.GET)
    public String getUrl(@PathVariable Long id, Model model) {
        model.addAttribute("urlById", this.urlService.getUrlByID(id));
        return "urlById";
    }

    @RequestMapping(value = "/tagByName/{nameTag}", method = RequestMethod.GET)
    public String getUrlsByTag(@PathVariable String nameTag, Model model) {
        model.addAttribute("urls", this.urlService.getUrlsByTag(nameTag));
        return "tagByName";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        return "signin";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addNewUserPost(@ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()){
            return "registration";
        }
        user.setRole(Role.ROLE_USER);
        this.userService.addUser(user);
        return "signin";
    }

    @RequestMapping(value = "editUrl/{id}", method = RequestMethod.GET)
    public String editUrl(@PathVariable Long id, Model model) {
        model.addAttribute("url", this.urlService.getUrlByID(id));
        return "editUrl";
    }

    @RequestMapping(value= "/edit", method = RequestMethod.POST)
    public String editUrl(@ModelAttribute("url") Url url){
        this.urlService.updateUrl(url);
        return "redirect:/signup";
    }

}
