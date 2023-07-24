package stage.epi.demo.modele;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("etudiant")
public class Etudiant extends Utilisateur {
    private Date date_naiss;
    private String niveau;
    private String nationalite;
    private String specialite;
    private String photo;

    @ManyToMany(mappedBy = "etudiantList")
    @JsonIgnore
    private List<Stage> stageList;


    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<Stage> stage;


    @ManyToOne
    private Enseignant enseignant;
    @ManyToOne
    private Encad_entreprise encad_entreprise;

    public Date getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Stage> stageList) {
        this.stageList = stageList;
    }

    public List<Stage> getStage() {
        return stage;
    }

    public void setStage(List<Stage> stage) {
        this.stage = stage;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Encad_entreprise getEncad_entreprise() {
        return encad_entreprise;
    }

    public void setEncad_entreprise(Encad_entreprise encad_entreprise) {
        this.encad_entreprise = encad_entreprise;
    }

    public Etudiant(String nom, String prenom, String tel, String username, String password, String adresse, String email, Collection<Role> roles, Date date_naiss, String niveau, String nationalite, String specialite, String photo) {
        super(nom, prenom, tel, username, password, adresse, email, roles);
        this.date_naiss = date_naiss;
        this.niveau = niveau;
        this.nationalite = nationalite;
        this.specialite = specialite;
        this.photo = photo;

    }

    public Etudiant() {
    }
}
