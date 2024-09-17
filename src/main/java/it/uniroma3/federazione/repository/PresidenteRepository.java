package it.uniroma3.federazione.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.federazione.model.Presidente;

@Repository
public interface PresidenteRepository extends CrudRepository<Presidente, Long> {

}
