package it.uniroma3.federazione.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.federazione.model.Contratto;
import it.uniroma3.federazione.model.Credenziali;
import it.uniroma3.federazione.model.Giocatore;
import it.uniroma3.federazione.model.Presidente;
import it.uniroma3.federazione.model.Squadra;
import it.uniroma3.federazione.service.CredenzialiService;
import it.uniroma3.federazione.service.GiocatoreService;
import it.uniroma3.federazione.service.SquadraService;




@Controller
public class GiocatoreController {

    @Autowired
    private CredenzialiService credenzialiService;
    @Autowired
    private GiocatoreService giocatoreService;
    @Autowired
    private SquadraService squadraService;

    @GetMapping("squadra/{idSquadra}/giocatore/{idGiocatore}")
    public String mostraGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, Model model) {
        model.addAttribute("squadra", squadraService.findById(idSquadra));
        model.addAttribute("giocatore", giocatoreService.findById(idGiocatore));
        Squadra squadra = squadraService.findById(idSquadra);
        Presidente presidente = squadra.getPresidente();
        if(presidente!=null){
            Credenziali credenziali = credenzialiService.findByPersona(presidente);
            if(credenziali!=null)
                model.addAttribute("usernamePresidente", credenziali.getUsername());
        }
        return "giocatore";
    }

    @GetMapping("/presidente/squadra/{id}/newGiocatore")
    public String getFormNewGiocatore(@PathVariable("id")Long id, Model model) {
        model.addAttribute("squadra", squadraService.findById(id));
        model.addAttribute("giocatore", new Giocatore());
        model.addAttribute("contratto", new Contratto());
        return "formNewGiocatore";
    }
    @PostMapping("/presidente/squadra/{id}/newGiocatore")
    public String newGiocatore(@PathVariable("id")Long id, @ModelAttribute("giocatore")Giocatore giocatore, @ModelAttribute("contratto")Contratto contratto) {
        giocatore.setContratto(contratto);
        giocatore.setSquadra(squadraService.findById(id));
        giocatore = giocatoreService.save(giocatore);
        return "redirect:/squadra/"+id+"/giocatore/"+giocatore.getId();
    }

    @GetMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newNome")
    public String getFormNewNomeGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, Model model) {
        model.addAttribute("squadra", squadraService.findById(idSquadra));
        model.addAttribute("giocatore", giocatoreService.findById(idGiocatore));
        return "formNewNomeGiocatore";
    }
    @PostMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newNome")
    public String newNomeGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, @RequestParam("nome")String nome) {
        Giocatore giocatore = giocatoreService.findById(idGiocatore);
        giocatore.setNome(nome);
        giocatoreService.save(giocatore);
        return "redirect:/squadra/"+idSquadra+"/giocatore/"+idGiocatore;
    }
    
    @GetMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newCognome")
    public String getFormNewCognomeGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, Model model) {
        model.addAttribute("squadra", squadraService.findById(idSquadra));
        model.addAttribute("giocatore", giocatoreService.findById(idGiocatore));
        return "formNewCognomeGiocatore";
    }
    @PostMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newCognome")
    public String newCognomeGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, @RequestParam("cognome")String cognome) {
        Giocatore giocatore = giocatoreService.findById(idGiocatore);
        giocatore.setCognome(cognome);
        giocatoreService.save(giocatore);
        return "redirect:/squadra/"+idSquadra+"/giocatore/"+idGiocatore;
    }
    
    @GetMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newDataNascita")
    public String getFormNewDataNascitaGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, Model model) {
        model.addAttribute("squadra", squadraService.findById(idSquadra));
        model.addAttribute("giocatore", giocatoreService.findById(idGiocatore));
        return "formNewDataNascitaGiocatore";
    }
    @PostMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newDataNascita")
    public String newDataNascitaGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, @RequestParam("dataNascita")LocalDate dataNascita) {
        Giocatore giocatore = giocatoreService.findById(idGiocatore);
        giocatore.setDataNascita(dataNascita);
        giocatoreService.save(giocatore);
        return "redirect:/squadra/"+idSquadra+"/giocatore/"+idGiocatore;
    }

    @GetMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newLuogoNascita")
    public String getFormNewLuogoaNascitaGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, Model model) {
        model.addAttribute("squadra", squadraService.findById(idSquadra));
        model.addAttribute("giocatore", giocatoreService.findById(idGiocatore));
        return "formNewLuogoNascitaGiocatore";
    }
    @PostMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newLuogoNascita")
    public String newLuogoNascitaGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, @RequestParam("luogoNascita")String luogoNascita) {
        Giocatore giocatore = giocatoreService.findById(idGiocatore);
        giocatore.setLuogoNascita(luogoNascita);
        giocatoreService.save(giocatore);
        return "redirect:/squadra/"+idSquadra+"/giocatore/"+idGiocatore;
    }

    @GetMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newInizioContratto")
    public String getFormNewInizioContrattoGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, Model model) {
        model.addAttribute("squadra", squadraService.findById(idSquadra));
        model.addAttribute("giocatore", giocatoreService.findById(idGiocatore));
        return "formNewInizioContrattoGiocatore";
    }
    @PostMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newInizioContratto")
    public String newInizioContrattoGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, @RequestParam("inizioContratto")LocalDate inizioContratto) {
        Giocatore giocatore = giocatoreService.findById(idGiocatore);
        giocatore.getContratto().setInizio(inizioContratto);
        giocatoreService.save(giocatore);
        return "redirect:/squadra/"+idSquadra+"/giocatore/"+idGiocatore;
    }

    @GetMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newFineContratto")
    public String getFormNewFineContrattoGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, Model model) {
        model.addAttribute("squadra", squadraService.findById(idSquadra));
        model.addAttribute("giocatore", giocatoreService.findById(idGiocatore));
        return "formNewFineContrattoGiocatore";
    }
    @PostMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/newFineContratto")
    public String newFineContrattoGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore, @RequestParam("fineContratto")LocalDate fineContratto) {
        Giocatore giocatore = giocatoreService.findById(idGiocatore);
        giocatore.getContratto().setFine(fineContratto);
        giocatoreService.save(giocatore);
        return "redirect:/squadra/"+idSquadra+"/giocatore/"+idGiocatore;
    }

    @PostMapping("/presidente/squadra/{idSquadra}/giocatore/{idGiocatore}/elimina")
    public String eliminaGiocatore(@PathVariable("idSquadra")Long idSquadra, @PathVariable("idGiocatore")Long idGiocatore) {
        giocatoreService.deleteById(idGiocatore);
        return "redirect:/squadra/"+idSquadra;
    }
    
    
}
