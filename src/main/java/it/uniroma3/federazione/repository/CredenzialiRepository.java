package it.uniroma3.federazione.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.federazione.model.Credenziali;
import it.uniroma3.federazione.model.Persona;


@Repository
public interface CredenzialiRepository extends CrudRepository<Credenziali, Long>{
    public Optional<Credenziali> findByUsername(String username);
    public Optional<Credenziali> findByPersona(Persona persona);
}
