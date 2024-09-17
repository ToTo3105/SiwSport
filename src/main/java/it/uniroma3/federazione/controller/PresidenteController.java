package it.uniroma3.federazione.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.federazione.model.Credenziali;
import it.uniroma3.federazione.model.Presidente;
import it.uniroma3.federazione.model.RuoloUtente;
import it.uniroma3.federazione.model.Squadra;
import it.uniroma3.federazione.service.CredenzialiService;
import it.uniroma3.federazione.service.PresidenteService;
import it.uniroma3.federazione.service.SquadraService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PresidenteController {

    @Autowired
    private PresidenteService presidenteService;

    @Autowired 
    private SquadraService squadraService;
    @Autowired
    private CredenzialiService credenzialiService;

    @GetMapping("/squadra/{id}/presidente")
    public String getMethodName(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        model.addAttribute("presidente", squadraService.findById(id).getPresidente());
        return "presidente";
    }

    @GetMapping("/amministratore/squadra/{id}/presidente/newNome")
    public String getFormNewNome(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        return "formNewNomePresidente";
    }
    @PostMapping("/amministratore/squadra/{id}/presidente/newNome")
    public String newNome(@PathVariable("id")Long id, @RequestParam("nome")String nome) {
        Presidente presidente = squadraService.findById(id).getPresidente();
        presidente.setNome(nome);
        presidenteService.save(presidente);
        return "redirect:/squadra/"+id+"/presidente";
    }

    @GetMapping("/amministratore/squadra/{id}/presidente/newCognome")
    public String getFormNewCognome(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        return "formNewCognomePresidente";
    }
    @PostMapping("/amministratore/squadra/{id}/presidente/newCognome")
    public String newCognome(@PathVariable("id")Long id, @RequestParam("cognome")String cognome) {
        Presidente presidente = squadraService.findById(id).getPresidente();
        presidente.setCognome(cognome);
        presidenteService.save(presidente);
        return "redirect:/squadra/"+id+"/presidente";
    }

    @GetMapping("/amministratore/squadra/{id}/presidente/newDataNascita")
    public String getFormNewDataNascita(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        return "formNewDataNascitaPresidente";
    }
    @PostMapping("/amministratore/squadra/{id}/presidente/newDataNascita")
    public String newDataNascita(@PathVariable("id")Long id, @RequestParam("dataNascita")LocalDate dataNascita) {
        Presidente presidente = squadraService.findById(id).getPresidente();
        presidente.setDataNascita(dataNascita);
        presidenteService.save(presidente);
        return "redirect:/squadra/"+id+"/presidente";
    }

    @GetMapping("/amministratore/squadra/{id}/presidente/newLuogoNascita")
    public String getFormNewLuogoNascita(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        return "formNewLuogoNascitaPresidente";
    }
    @PostMapping("/amministratore/squadra/{id}/presidente/newLuogoNascita")
    public String newLuogoNascita(@PathVariable("id")Long id, @RequestParam("luogoNascita")String luogoNascita) {
        Presidente presidente = squadraService.findById(id).getPresidente();
        presidente.setLuogoNascita(luogoNascita);
        presidenteService.save(presidente);
        return "redirect:/squadra/"+id+"/presidente";
    }

    @GetMapping("/amministratore/squadra/{id}/presidente/newCodiceFiscale")
    public String getFormNewCodiceFiscale(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        return "formNewCodiceFiscale";
    }
    @PostMapping("/amministratore/squadra/{id}/presidente/newCodiceFiscale")
    public String newCodiceFiscale(@PathVariable("id")Long id, @RequestParam("codiceFiscale")String codiceFiscale) {
        Presidente presidente = squadraService.findById(id).getPresidente();
        presidente.setCodiceFiscale(codiceFiscale);
        presidenteService.save(presidente);
        return "redirect:/squadra/"+id+"/presidente";
    }

    @GetMapping("/amministratore/squadra/{id}/newPresidente")
    public String getFormNewPresidente(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        model.addAttribute("presidente", new Presidente());
        return "formNewPresidente";
    }
    @PostMapping("/amministratore/squadra/{id}/newPresidente")
    public String newPresidente(@PathVariable("id")Long id, @ModelAttribute("presidente")Presidente presidente){
        Squadra squadra = squadraService.findById(id);
        squadra.setPresidente(presidente);
        squadraService.save(squadra);
        Credenziali credenziali = new Credenziali();
        credenziali.setUsername((presidente.getNome().toLowerCase())+"."+(presidente.getCognome().toLowerCase()));
        credenziali.setPassword(new BCryptPasswordEncoder().encode(presidente.getCodiceFiscale().toUpperCase()));
        credenziali.setRuoloUtente(RuoloUtente.PRESIDENTE);
        credenziali.setPersona(squadra.getPresidente());
        credenzialiService.save(credenziali);
        return "redirect:/squadra/"+id+"/presidente";
    }
    
}
