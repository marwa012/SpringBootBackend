package stage.epi.demo.modele;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue("Encadreur")
public class Encad_entreprise extends Utilisateur {

    private String statut;
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;
    @OneToMany(mappedBy = "encad_entreprise")
    private List<Etudiant> etudiants;


    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }


    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }


    public Encad_entreprise(String nom, String prenom, String tel, String username, String password, String adresse, String email, Collection<Role> roles, String statut) {
        super(nom, prenom, tel, username, password, adresse, email, roles);
        this.statut = statut;


    }

    public Encad_entreprise() {
    }
}
