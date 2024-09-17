package it.uniroma3.federazione.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Squadra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer annoFondazione;
    private String indirizzoSede;
    @OneToMany(mappedBy = "squadra", cascade = CascadeType.ALL)
    private Set<Giocatore> giocatori;
    @OneToOne(cascade = CascadeType.ALL)
    private Presidente presidente;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getAnnoFondazione() {
        return annoFondazione;
    }
    public void setAnnoFondazione(Integer annoFondazione) {
        this.annoFondazione = annoFondazione;
    }
    public String getIndirizzoSede() {
        return indirizzoSede;
    }
    public void setIndirizzoSede(String indirizzoSede) {
        this.indirizzoSede = indirizzoSede;
    }
    public Set<Giocatore> getGiocatori() {
        return giocatori;
    }
    public void setGiocatori(Set<Giocatore> giocatori) {
        this.giocatori = giocatori;
    }
    public Presidente getPresidente() {
        return presidente;
    }
    public void setPresidente(Presidente presidente) {
        this.presidente = presidente;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((annoFondazione == null) ? 0 : annoFondazione.hashCode());
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
        Squadra other = (Squadra) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (annoFondazione == null) {
            if (other.annoFondazione != null)
                return false;
        } else if (!annoFondazione.equals(other.annoFondazione))
            return false;
        return true;
    }
}
