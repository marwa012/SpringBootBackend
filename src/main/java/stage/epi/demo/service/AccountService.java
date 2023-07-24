package stage.epi.demo.service;


import stage.epi.demo.modele.*;

public interface AccountService {
    Etudiant saveEtudiant(Etudiant etudiant);

    Administrateur saveAdmin(Administrateur administrateur);
    Enseignant saveEnseignant(Enseignant enseignant);


    Role save(Role role);
    Utilisateur loadUserByUsername(String username);
     void addRoleToUser(String username, String roleName);

}
