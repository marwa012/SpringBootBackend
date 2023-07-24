package stage.epi.demo.interfa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stage.epi.demo.modele.Stage;

@Repository
public interface Stageview extends JpaRepository<Stage,Long> {

}
