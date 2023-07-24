package stage.epi.demo.interfa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stage.epi.demo.modele.Administrateur;

@Repository
public interface Adminstrateurview extends JpaRepository<Administrateur,Long> {
}
