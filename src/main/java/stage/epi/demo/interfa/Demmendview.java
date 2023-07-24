package stage.epi.demo.interfa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stage.epi.demo.modele.DemmendEncadrement;

import java.util.List;

@Repository
public interface Demmendview extends JpaRepository<DemmendEncadrement, Long> {
    //@Query("select  m from DemmendEncadrement where m.enseignant.id_utilisateur = x")
    //public List<DemmendEncadrement> demmendbyensenignt(@Param("x") Long id);
}
