package stage.epi.demo.interfa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stage.epi.demo.modele.Entreprise;

@Repository
public interface Entrepriseview extends JpaRepository<Entreprise,Long> {
   /* @Query("select entrprise from  Entreprise entreprise where entreprise.nom like :x")
    public List<Entreprise> getentreprisebynom (@Param("x") String nom  );*/
}
