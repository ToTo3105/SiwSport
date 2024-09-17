package it.uniroma3.federazione.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.federazione.model.Squadra;
import it.uniroma3.federazione.repository.SquadraRepository;

@Service
public class SquadraService {
    @Autowired
    private SquadraRepository squadraRepository;
    public Iterable<Squadra> findAll(){
        return squadraRepository.findAll();
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Squadra findById(Long id) {
        return squadraRepository.findById(id).get();
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Squadra save(Squadra squadra) {
        return squadraRepository.save(squadra);
    }
    public void deleteById(Long id) {
        squadraRepository.deleteById(id);
    } 
}
