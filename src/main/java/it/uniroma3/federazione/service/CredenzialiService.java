package it.uniroma3.federazione.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.federazione.model.Credenziali;
import it.uniroma3.federazione.model.Persona;
import it.uniroma3.federazione.repository.CredenzialiRepository;

@Service
public class CredenzialiService {
    @Autowired
    private CredenzialiRepository credenzialiRepository;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Credenziali save(Credenziali credenziali){
        return credenzialiRepository.save(credenziali);
    }
    public Credenziali findByUsername(String username) {
        return credenzialiRepository.findByUsername(username).get();
    }

    public Credenziali findByPersona(Persona persona){
        return credenzialiRepository.findByPersona(persona).get();
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteById(Long id) {
        credenzialiRepository.deleteById(id);
    }
}
