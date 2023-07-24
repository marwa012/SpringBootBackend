package stage.epi.demo.modele;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("adminstrateur")
public class Administrateur extends Utilisateur {
    private String fax;

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }


    public Administrateur(String nom, String prenom, String tel, String username, String password, String adresse, String email, List<Role> roles, String fax) {
        super(nom, prenom, tel, username, password, adresse, email, roles);
        this.fax = fax;
    }

    public Administrateur() {
    }
}
