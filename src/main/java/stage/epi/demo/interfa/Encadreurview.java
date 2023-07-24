package stage.epi.demo.interfa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stage.epi.demo.modele.Encad_entreprise;

@Repository
public interface Encadreurview extends JpaRepository<Encad_entreprise,Long> {
}
