/**Utilisateur**/
package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Tars implements Serializable {
    private Long id;

    private String name;

    private Fiche fiche;

    public Tars() {
    }

    public Tars(String name, Fiche fiche) {
        this.name = name;
        this.fiche = fiche;
    }

    public Tars(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JsonIgnore
    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }

    @Override
    public String toString() {
        return "Tars [id=" + id + ", name=" + name + ", tableau="
                + fiche.getName() + "]";
    }

}
