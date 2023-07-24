package stage.epi.demo.interfa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stage.epi.demo.modele.Enseignant;

@Repository
public interface Enseignantview extends JpaRepository<Enseignant,Long> {
}
