package it.uniroma3.federazione.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.federazione.model.Presidente;
import it.uniroma3.federazione.repository.PresidenteRepository;

@Service
public class PresidenteService {

    @Autowired
    private PresidenteRepository presidenteRepository;
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Presidente save(Presidente presidente){
        return presidenteRepository.save(presidente);
    }
    public boolean existsById(Long id) {
        return presidenteRepository.existsById(id);
    }
}
