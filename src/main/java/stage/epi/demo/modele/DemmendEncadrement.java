package stage.epi.demo.modele;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

public class DemmendEncadrement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt =new Date();
    private String etat;
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;
    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public DemmendEncadrement(Date createdAt, String etat) {
        this.createdAt = new Date();
        this.etat = etat;
    }

    public DemmendEncadrement() {
    }
}
