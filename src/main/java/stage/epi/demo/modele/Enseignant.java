package stage.epi.demo.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("enseignat")
public class Enseignant extends Utilisateur {
    private String specialite;
    private String departement;
    private String photo;


   @OneToMany(mappedBy = "enseignant")
   @JsonIgnore
    private List<Stage> stages;

    @OneToMany(mappedBy = "enseignant")
    private List<Etudiant> etudiants;


    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Enseignant(String nom, String prenom, String tel, String username, String password, String adresse, String email, Collection<Role> roles, String specialite, String departement, String photo) {
        super(nom, prenom, tel, username, password, adresse, email, roles);
        this.specialite = specialite;
        this.departement = departement;
        this.photo = photo;
    }

    public Enseignant() {
    }
}
