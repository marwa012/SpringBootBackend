package stage.epi.demo.interfa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stage.epi.demo.modele.Role;

@Repository
public interface IRole extends JpaRepository<Role,Long> {
    public Role findByRoleName(String roleName);
}
