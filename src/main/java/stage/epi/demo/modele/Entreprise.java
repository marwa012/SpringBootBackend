package stage.epi.demo.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Entreprise")

public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entreprise;
    private String nom;
    private String adresse;
    private String email;
    private String tel;
    @OneToMany(mappedBy = "entreprise")
    private List<Encad_entreprise> encadEntreprises;
    @JsonIgnore
    @OneToMany(mappedBy = "entreprise")

    private List<Stage> stages;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(Long id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Encad_entreprise> getEncadEntreprises() {
        return encadEntreprises;
    }

    public void setEncadEntreprises(List<Encad_entreprise> encadEntreprises) {
        this.encadEntreprises = encadEntreprises;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public Entreprise(String nom, String adresse, String email, String tel) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
    }

    public Entreprise() {
    }
}
