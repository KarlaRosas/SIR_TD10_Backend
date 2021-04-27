/**Section**/
package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section implements Serializable {
    private long id;

    private String name;

    private Tableau tableau;

    private List<Fiche> fiches;

    public Section() {
    }

    public Section(String name, Tableau tableau) {
        this.name = name;
        this.tableau = tableau;
    }

    public Section(String name) {
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
    public Tableau getTableau() {
        return tableau;
    }

    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }

    @OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }



    @Override
    public String toString() {
        return "Section [id=" + id + ", name=" + name + ", tableau="
                + tableau.getName() + "]";
    }

}
