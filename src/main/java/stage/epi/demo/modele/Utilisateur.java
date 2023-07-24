package stage.epi.demo.modele;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_utilisateur;
    private String nom;
    private String prenom;
    private String tel;
    private String username;
    private String password;
    private String adresse;
    private String email;
  @ManyToMany(fetch =FetchType.EAGER)
    private Collection<Role> roles =new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
  
  
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public Utilisateur(String nom, String prenom, String tel, String username, String password, String adresse, String email, Collection<Role> roles) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.username = username;
        this.password = password;
        this.adresse = adresse;
        this.email = email;
        this.roles = roles;
    }

    public Utilisateur() {
    }
}
