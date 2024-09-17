package it.uniroma3.federazione.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Amministratore extends Persona{
    
    @OneToOne(mappedBy = "persona")
    private Credenziali credenziali;

    public Credenziali getCredenziali() {
        return credenziali;
    }

    public void setCredenziali(Credenziali credenziali) {
        this.credenziali = credenziali;
    }
}
