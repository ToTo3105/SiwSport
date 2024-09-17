package it.uniroma3.federazione.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Presidente extends Persona {

    private String codiceFiscale;
    @OneToOne(mappedBy = "presidente")
    private Squadra squadra;
    public Squadra getSquadra() {
        return squadra;
    }
    public void setSquadra(Squadra squadra) {
        this.squadra = squadra;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale.toUpperCase();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Presidente other = (Presidente) obj;
        if (codiceFiscale == null) {
            if (other.codiceFiscale != null)
                return false;
        } else if (!codiceFiscale.equals(other.codiceFiscale))
            return false;
        return true;
    }
    
}
