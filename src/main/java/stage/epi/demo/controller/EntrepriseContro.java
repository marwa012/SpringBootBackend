package stage.epi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.epi.demo.interfa.Encadreurview;
import stage.epi.demo.interfa.Entrepriseview;
import stage.epi.demo.interfa.Stageview;
import stage.epi.demo.modele.Enseignant;
import stage.epi.demo.modele.Entreprise;
import stage.epi.demo.modele.Stage;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/entreprise")
public class EntrepriseContro {
    @Autowired
    private Entrepriseview entrepriseview;
    @Autowired
    private Encadreurview encadreurview;
    @Autowired
    private Stageview stageview;
    @PostMapping("/save")
    public Entreprise saveEntreprise(@RequestBody Entreprise entreprise){
        return entrepriseview.save(entreprise);

    }
    @GetMapping("/all")
    public List<Entreprise> getallentreprise(){
        return entrepriseview.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public HashMap delete(@PathVariable  Long id){
        HashMap<String,String> hashMap=new HashMap<>();
        try{
            Entreprise entreprise = entrepriseview.getOne(id);
            for (Stage stage : entreprise.getStages()) {
                stageview.delete(stage);

            }
            entrepriseview.deleteById(id);
          hashMap.put("etat","entrprise supprimee");
          return hashMap;
        }
        catch (Exception e){
            hashMap.put("etat","entrprise non trouvee");
            return hashMap;
        }
    }
    @PutMapping("/modifier/{id}")
    public Entreprise modifierEntreprise(@RequestBody Entreprise entreprise, @PathVariable  Long id){
        entreprise.setId_entreprise(id);
        Entreprise entrepriseanc=entrepriseview.getOne(id);
        if(entreprise.getNom()==null){
            entreprise.setNom(entrepriseanc.getNom());
        }if(entreprise.getAdresse()==null){
            entreprise.setAdresse(entrepriseanc.getAdresse());
        }if(entreprise.getTel()==null){
            entreprise.setTel(entrepriseanc.getTel());
        }if(entreprise.getEmail()==null){
            entreprise.setEmail(entrepriseanc.getEmail());
        }
        entreprise.setId_entreprise(id);
        entrepriseview.saveAndFlush(entreprise);
        return entreprise;
    }

}
