package it.uniroma3.federazione.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.federazione.model.Credenziali;
import it.uniroma3.federazione.model.Presidente;
import it.uniroma3.federazione.model.Squadra;
import it.uniroma3.federazione.service.CredenzialiService;
import it.uniroma3.federazione.service.SquadraService;

@Controller
public class SquadraController {

    @Autowired
    private SquadraService squadraService;
    @Autowired
    private CredenzialiService credenzialiService;
    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/squadra";
    }

    @GetMapping("/squadra")
    public String mostraSquadre(Model model) {
        model.addAttribute("squadre", squadraService.findAll());
        return "squadre";
    }

    @GetMapping("/squadra/{id}")
    public String mostraSquadra(@PathVariable("id")Long id, Model model) {
        Squadra squadra = squadraService.findById(id);
        model.addAttribute("squadra", squadra);
        Presidente presidente = squadra.getPresidente();
        if(presidente!=null){
            Credenziali credenziali = credenzialiService.findByPersona(presidente);
            if(credenziali!=null)
                model.addAttribute("usernamePresidente", credenziali.getUsername());
        }
        return "squadra";
    }

    @GetMapping("/amministratore/squadra/newSquadra")
    public String formNewSquadra(Model model) {
        model.addAttribute("squadra", new Squadra());
        return "formNewSquadra";
    }
    @PostMapping("/amministratore/squadra/newSquadra")
    public String newSquadra(@ModelAttribute("squadra") Squadra squadra) {
        squadraService.save(squadra);
        return "redirect:/squadra/"+squadra.getId();
    }

    @PostMapping("/amministratore/squadra/{id}/elimina")
    public String eliminaSquadra(@PathVariable("id")Long id) {
        Squadra squadra = squadraService.findById(id);
        Presidente presidente = squadra.getPresidente();
        if(presidente!=null){
            Credenziali credenziali = credenzialiService.findByPersona(presidente);
            credenzialiService.deleteById(credenziali.getId());
        }
        squadraService.deleteById(id);
        return "redirect:/squadra";
    }

    @GetMapping("/amministratore/squadra/{id}/newNome")
    public String getFormNewNomeSquadra(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        return "formNewNomeSquadra";
    }
    @PostMapping("/amministratore/squadra/{id}/newNome")
    public String newNomeSquadra(@PathVariable("id")Long id, @RequestParam("nome")String nome){
        Squadra squadra = squadraService.findById(id);
        squadra.setNome(nome);
        squadraService.save(squadra);
        return "redirect:/squadra/"+squadra.getId();
    }

    @GetMapping("/amministratore/squadra/{id}/newIndirizzoSede")
    public String getFormNewIndirizzoSede(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        return "formNewIndirizzoSede";
    }
    @PostMapping("/amministratore/squadra/{id}/newIndirizzoSede")
    public String newIndirizzoSede(@PathVariable("id")Long id, @RequestParam("indirizzoSede")String indirizzoSede){
        Squadra squadra = squadraService.findById(id);
        squadra.setIndirizzoSede(indirizzoSede);
        squadraService.save(squadra);
        return "redirect:/squadra/"+squadra.getId();
    }

    @GetMapping("/amministratore/squadra/{id}/newAnnoFondazione")
    public String getFormNewAnnoFondazione(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        return "formNewAnnoFondazione";
    }

    @PostMapping("/amministratore/squadra/{id}/newAnnoFondazione")
    public String newAnnoFondazione(@PathVariable("id")Long id, @RequestParam("annoFondazione")Integer annoFondazione){
        Squadra squadra = squadraService.findById(id);
        squadra.setAnnoFondazione(annoFondazione);
        squadraService.save(squadra);
        return "redirect:/squadra/"+squadra.getId();
    }
    
}
