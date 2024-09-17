package it.uniroma3.federazione.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Contratto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate inizio;
    private LocalDate fine;
    @Enumerated(EnumType.STRING)
    private RuoloGiocatore ruolo;
    @OneToOne(mappedBy = "contratto")
    private Giocatore giocatore;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getInizio() {
        return inizio;
    }
    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }
    public LocalDate getFine() {
        return fine;
    }
    public void setFine(LocalDate fine) {
        this.fine = fine;
    }
    public RuoloGiocatore getRuolo() {
        return ruolo;
    }
    public void setRuolo(RuoloGiocatore ruolo) {
        this.ruolo = ruolo;
    }
    public Giocatore getGiocatore() {
        return giocatore;
    }
    public void setGiocatore(Giocatore giocatore) {
        this.giocatore = giocatore;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((inizio == null) ? 0 : inizio.hashCode());
        result = prime * result + ((fine == null) ? 0 : fine.hashCode());
        result = prime * result + ((ruolo == null) ? 0 : ruolo.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contratto other = (Contratto) obj;
        if (inizio == null) {
            if (other.inizio != null)
                return false;
        } else if (!inizio.equals(other.inizio))
            return false;
        if (fine == null) {
            if (other.fine != null)
                return false;
        } else if (!fine.equals(other.fine))
            return false;
        if (ruolo != other.ruolo)
            return false;
        return true;
    }
}
