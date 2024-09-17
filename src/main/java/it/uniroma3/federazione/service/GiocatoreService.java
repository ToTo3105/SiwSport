package it.uniroma3.federazione.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.federazione.model.Giocatore;
import it.uniroma3.federazione.repository.GiocatoreRepository;

@Service
public class GiocatoreService {
    @Autowired
    private GiocatoreRepository giocatoreRepository;
    public Giocatore findById(Long id){
        return giocatoreRepository.findById(id).get();
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Giocatore save(Giocatore giocatore) {
        return giocatoreRepository.save(giocatore);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteById(Long id) {
        giocatoreRepository.deleteById(id);
    }
}
