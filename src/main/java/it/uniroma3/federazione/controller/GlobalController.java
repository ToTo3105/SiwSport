package it.uniroma3.federazione.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import it.uniroma3.federazione.model.Credenziali;
import it.uniroma3.federazione.service.CredenzialiService;

@ControllerAdvice
public class GlobalController {

    @Autowired
    private CredenzialiService credenzialiService;

    @ModelAttribute("userDetails")
    public UserDetails getUser(){
        UserDetails user = null;
        Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken))
            user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

    @ModelAttribute("userRole")
    public String getUserRole(){
        UserDetails userDetails = getUser();
        String role = null;
        if(userDetails!=null){
            Credenziali credenziali = credenzialiService.findByUsername(userDetails.getUsername());
            role = credenziali.getRuoloUtente().toString();
        }
        return role;
    }
}
