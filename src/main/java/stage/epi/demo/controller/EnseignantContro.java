package stage.epi.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.epi.demo.interfa.Demmendview;
import stage.epi.demo.interfa.Enseignantview;
import stage.epi.demo.interfa.Stageview;
import stage.epi.demo.modele.DemmendEncadrement;
import stage.epi.demo.modele.Enseignant;
import stage.epi.demo.modele.Stage;
import stage.epi.demo.service.AccountService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/enseignant")
public class EnseignantContro {
    @Autowired
    private Enseignantview enseignantview;
    @Autowired
    AccountService accountService;
    @Autowired
    private Stageview stageview;
    @Autowired
    private Demmendview demmendview;

    @PostMapping("/save")
    public Enseignant saveenseignant(@RequestBody Enseignant enseignant) {
        return accountService.saveEnseignant(enseignant);
    }

    @PutMapping("/modifier/{id_ut}")

    public Enseignant modifierEnseignant(@RequestBody Enseignant ensei, @PathVariable Long id_ut) {

        Enseignant enseignattanc=enseignantview.getOne(id_ut);
        if(ensei.getDepartement()==null){
            ensei.setDepartement(enseignattanc.getDepartement());
        }
        if(ensei.getSpecialite()==null){
            ensei.setSpecialite(enseignattanc.getSpecialite());
        }  if(ensei.getPhoto()==null){
            ensei.setPhoto(enseignattanc.getPhoto());
        } if(ensei.getNom()==null){
            ensei.setNom(enseignattanc.getNom());
        }if(ensei.getAdresse()==null){
            ensei.setAdresse(enseignattanc.getAdresse());
        }if(ensei.getPrenom()==null){
            ensei.setPrenom(enseignattanc.getPrenom());
        }if(ensei.getTel()==null){
            ensei.setTel(enseignattanc.getTel());
        }if(ensei.getEmail()==null){
            ensei.setEmail(enseignattanc.getEmail());
        }
        ensei.setId_utilisateur(id_ut);
        ensei.setPassword(ensei.getPassword());
        ensei.setRoles(enseignattanc.getRoles());
        enseignantview.saveAndFlush(ensei);
        return ensei;

    }

    @GetMapping("/getall")
    public List<Enseignant> geteEnseignant() {
        return enseignantview.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public HashMap delete(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Enseignant enseignant = enseignantview.getOne(id);
            for (Stage stage : enseignant.getStages()) {
                stageview.delete(stage);

            }
            enseignantview.deleteById(id);
            hashMap.put("etat", "enseignant supprimee");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "enseignant non trouvee");
            return hashMap;
        }
    }

   // @GetMapping("getdemandebyenseingt/{id}")
   // private List<DemmendEncadrement> getdemmend(@PathVariable Long id) {
    //    return demmendview.demmendbyensenignt(Double.parseDouble(id));
   // }
}
