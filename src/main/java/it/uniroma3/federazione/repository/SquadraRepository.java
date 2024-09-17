package it.uniroma3.federazione.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.federazione.model.Squadra;

@Repository
public interface SquadraRepository extends CrudRepository<Squadra, Long> {

}
