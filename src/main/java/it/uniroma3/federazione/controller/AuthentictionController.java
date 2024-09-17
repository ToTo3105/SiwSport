package it.uniroma3.federazione.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.federazione.model.Credenziali;
import it.uniroma3.federazione.model.Presidente;
import it.uniroma3.federazione.model.RuoloUtente;
import it.uniroma3.federazione.service.CredenzialiService;


@Controller
public class AuthentictionController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CredenzialiService credenzialiService;
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/failure")
    public String failure(Model model){
        model.addAttribute("errorLogin", "Username o password errati!");
        return "login";
    }

    @GetMapping("/success")
    public String success(Principal principal,Model model){
        UserDetails userDetails = (UserDetails) ((Authentication)principal).getPrincipal();
        Credenziali credenziali = credenzialiService.findByUsername(userDetails.getUsername());
        if(credenziali.getRuoloUtente().equals(RuoloUtente.PRESIDENTE)){
            Presidente presidente = (Presidente)(credenziali.getPersona());
            if(passwordEncoder.matches(presidente.getCodiceFiscale(), credenziali.getPassword())){
                model.addAttribute("presidente", presidente);
                return "formNewPassword";
            }
        }
        return "redirect:/squadra";
    }

    @PostMapping("/presidente/squadra/{id}/presidente/newPassword")
    public String newPassword(Principal principal, @PathVariable("id")Long id, @RequestParam("password")String password, Model model) {
        UserDetails userDetails = (UserDetails)((Authentication)principal).getPrincipal();
        Credenziali credenziali = credenzialiService.findByUsername(userDetails.getUsername());
        if(password.equals(((Presidente)credenziali.getPersona()).getCodiceFiscale())){
            model.addAttribute("error", "La password deve essere diversa dal codice fiscale");
        }
        credenziali.setPassword(new BCryptPasswordEncoder().encode(password));
        credenzialiService.save(credenziali);
        return "redirect:/squadra";
    }
    
}
