package stage.epi.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.epi.demo.interfa.Encadreurview;
import stage.epi.demo.interfa.Entrepriseview;
import stage.epi.demo.modele.Encad_entreprise;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/encadreur")


public class EncadreurContro {
    @Autowired
    private Encadreurview encadreurview;
    @Autowired
    private Entrepriseview entrepriseview;

    @PostMapping("/save/{idsociete}")
    public Encad_entreprise save(@RequestBody Encad_entreprise encad_entreprise, @PathVariable Long idsociete) {
        encad_entreprise.setEntreprise(entrepriseview.getOne(idsociete));
        return encadreurview.save(encad_entreprise);
    }


    @GetMapping("/all")
    public List<Encad_entreprise> getEncadreurs(){
        return encadreurview.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public HashMap delete(@PathVariable  Long id){
        HashMap<String,String> hashMap=new HashMap<>();
        try{
            encadreurview.deleteById(id);
            hashMap.put("etat","entrprise supprimee");
            return hashMap;
        }
        catch (Exception e){
            hashMap.put("etat","entrprise non trouvee");
            return hashMap;
        }
    }
    @PutMapping("/modifier/{id}/{idsociete}")
    public Encad_entreprise modifierEncad(@RequestBody Encad_entreprise encad_entreprise, @PathVariable  Long id, @PathVariable Long idsociete){
        encad_entreprise.setEntreprise(entrepriseview.getOne(idsociete));
        encad_entreprise.setId_utilisateur(id);
        encadreurview.saveAndFlush(encad_entreprise);
        return encad_entreprise;
    }
}