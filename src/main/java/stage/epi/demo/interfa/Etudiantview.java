package stage.epi.demo.interfa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stage.epi.demo.modele.Etudiant;

@Repository
public interface Etudiantview extends JpaRepository<Etudiant,Long> {
}
