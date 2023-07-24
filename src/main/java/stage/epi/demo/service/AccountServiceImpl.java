package stage.epi.demo.service;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stage.epi.demo.interfa.*;
import stage.epi.demo.modele.*;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private Utilisateurview utilisateurview;
    private Adminstrateurview adminstrateurview;
   private Etudiantview etudiantview;
   private Enseignantview enseignantview;
    private IRole iRole;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(Utilisateurview utilisateurview, IRole iRole, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.utilisateurview = utilisateurview;
        this.iRole= iRole;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        Utilisateur user=utilisateurview.findByUsername(etudiant.getUsername());
        if(user!=null) throw new RuntimeException("User already exists");
           /* if(!admin.getPassword().equals(admin.getConfirmedPassword())) throw new RuntimeException("Please confirm your password");*/
        Etudiant appUser=new Etudiant();
        appUser.setUsername(etudiant.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(etudiant.getPassword()));
          /*  appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(admin.getConfirmedPassword()));*/
        appUser.setNom(etudiant.getNom());
        appUser.setPrenom(etudiant.getPrenom());
        appUser.setEmail(etudiant.getEmail());
appUser.setDate_naiss(etudiant.getDate_naiss());
appUser.setNationalite(etudiant.getNationalite());
        appUser.setAdresse(etudiant.getAdresse());
        appUser.setNiveau(etudiant.getNiveau());
        appUser.setSpecialite(etudiant.getSpecialite());
        appUser.setPhoto(etudiant.getPhoto());
        appUser.setTel(etudiant.getTel());

        utilisateurview.save(appUser);
        addRoleToUser(etudiant.getUsername(),"etudiant");
        return appUser;
    }

    @Override
    public Administrateur saveAdmin(Administrateur admin) {
        Utilisateur user=utilisateurview.findByUsername(admin.getUsername());
            if(user!=null) throw new RuntimeException("User already exists");
           /* if(!admin.getPassword().equals(admin.getConfirmedPassword())) throw new RuntimeException("Please confirm your password");*/
        Administrateur appUser=new Administrateur();
            appUser.setUsername(admin.getUsername());
            appUser.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
          /*  appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(admin.getConfirmedPassword()));*/
            appUser.setNom(admin.getNom());
            appUser.setPrenom(admin.getPrenom());
            appUser.setEmail(admin.getEmail());
            appUser.setFax(admin.getFax());
        appUser.setAdresse(admin.getAdresse());
        appUser.setTel(admin.getTel());

        utilisateurview.save(appUser);
            addRoleToUser(admin.getUsername(),"ADMIN");
            return appUser;
        }

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        Utilisateur user=utilisateurview.findByUsername(enseignant.getUsername());
        if(user!=null) throw new RuntimeException("User already exists");
           /* if(!admin.getPassword().equals(admin.getConfirmedPassword())) throw new RuntimeException("Please confirm your password");*/
        Enseignant appUser=new Enseignant();
        appUser.setUsername(enseignant.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(enseignant.getPassword()));
          /*  appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(admin.getConfirmedPassword()));*/
        appUser.setNom(enseignant.getNom());
        appUser.setPrenom(enseignant.getPrenom());
        appUser.setEmail(enseignant.getEmail());
        appUser.setDepartement(enseignant.getDepartement());
        appUser.setPhoto(enseignant.getPhoto());
        appUser.setSpecialite(enseignant.getSpecialite());
        appUser.setDepartement(enseignant.getDepartement());
        appUser.setAdresse(enseignant.getAdresse());
        appUser.setPhoto(enseignant.getPhoto());
        appUser.setTel(enseignant.getTel());

        utilisateurview.save(appUser);
        addRoleToUser(enseignant.getUsername(),"enseignant");
        return appUser;
    }


    @Override
    public Role save(Role role) {
        return iRole.save(role);
    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return utilisateurview.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Utilisateur appUser=utilisateurview.findByUsername(username);
        Role appRole=iRole.findByRoleName(roleName);
        appUser.getRoles().add(appRole);
    }
}
