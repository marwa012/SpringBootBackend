package stage.epi.demo.modele;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Stage")

public class Stage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theme;
    private String duree;
    private String type;
    private String date_debut;
    private String date_fin;
    private String reference;
    private String description;
    private String note;
    private String rapport;
    private String sujet;
   /* private List<Long> idpreferer = new ArrayList<>();*/



    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;



    @ManyToMany(fetch =FetchType.LAZY)
    @JoinTable(name = "stage_effectuee",
            joinColumns =
            @JoinColumn(name = "stage_id"),
            inverseJoinColumns =
            @JoinColumn(name = "etud_id"))
    private List<Etudiant> etudiantList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    @JsonIgnore

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

   /* public List<Long> getIdpreferer() {
        return idpreferer;
    }

    public void setIdpreferer(List<Long> idpreferer) {
        this.idpreferer = idpreferer;
    }*/

    public Stage(String theme, String duree, String type, String date_debut, String date_fin, String reference, String description, String note, String rapport, String sujet) {
        this.theme = theme;
        this.duree = duree;
        this.type = type;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.reference = reference;
        this.description = description;
        this.note = note;
        this.rapport = rapport;
        this.sujet = sujet;
    }

    public Stage() {
    }
}
