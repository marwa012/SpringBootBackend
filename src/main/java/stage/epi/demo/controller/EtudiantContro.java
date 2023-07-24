package stage.epi.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import stage.epi.demo.interfa.Etudiantview;
import stage.epi.demo.interfa.Stageview;
import stage.epi.demo.modele.Etudiant;
import stage.epi.demo.modele.Stage;
import stage.epi.demo.service.AccountService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantContro {
    @Autowired
    private Etudiantview etudiantview;
    @Autowired
    AccountService accountService;
    @Autowired
    private Stageview stageview;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/save")
    public Etudiant saveetudiant(@RequestBody Etudiant etudiant) {
        return accountService.saveEtudiant(etudiant);
    }

    @PutMapping("/modifier/{id_ut}")
    public Etudiant modifierEtudiant(@RequestBody Etudiant etud, @PathVariable Long id_ut) {
Etudiant etudiantanc=etudiantview.getOne(id_ut);
        etud.setId_utilisateur(id_ut);
        if(etud.getDate_naiss()==null){
            etud.setDate_naiss(etudiantanc.getDate_naiss());
        }
        if(etud.getNationalite()==null){
            etud.setNationalite(etudiantanc.getNationalite());
        } if(etud.getNiveau()==null){
            etud.setNiveau(etudiantanc.getNiveau());
        } if(etud.getPhoto()==null){
            etud.setPhoto(etudiantanc.getPhoto());
        } if(etud.getSpecialite()==null){
            etud.setSpecialite(etudiantanc.getSpecialite());
        } if(etud.getNom()==null){
            etud.setNom(etudiantanc.getNom());
        }if(etud.getAdresse()==null){
            etud.setAdresse(etudiantanc.getAdresse());
        }if(etud.getPrenom()==null){
            etud.setPrenom(etudiantanc.getPrenom());
        }if(etud.getTel()==null){
            etud.setTel(etudiantanc.getTel());
        }if(etud.getEmail()==null){
            etud.setEmail(etudiantanc.getEmail());
        }
        etud.setPassword(etud.getPassword());
     etud.setRoles(etudiantanc.getRoles());
        etudiantview.saveAndFlush(etud);
        return etud;
    }

    @GetMapping("/getall")
    public List<Etudiant> geteEtudiant() {
        return etudiantview.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public HashMap delete(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Etudiant etudiant = etudiantview.getOne(id);
            for (Stage stage : etudiant.getStage()) {
                stageview.delete(stage);

            }
            etudiantview.deleteById(id);
            hashMap.put("etat", "etudiant supprimee");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "etudiant non trouvee");
            return hashMap;
        }
    }

    @GetMapping("/allstageproposerbyetudient/{idetudiant}")
    public List<Stage> allstagebyetudient(@PathVariable Long idetudiant) {
        Etudiant etudiant = etudiantview.getOne(idetudiant);
        return etudiant.getStage();
    }

}
