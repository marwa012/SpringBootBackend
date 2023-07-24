package stage.epi.demo.controller;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.epi.demo.interfa.Demmendview;
import stage.epi.demo.interfa.Enseignantview;
import stage.epi.demo.interfa.Etudiantview;
import stage.epi.demo.interfa.Stageview;
import stage.epi.demo.modele.DemmendEncadrement;
import stage.epi.demo.modele.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/demmend")
public class DemmandeControl {
    @Autowired
    private Demmendview demmendview;
    @Autowired
    private Stageview stageview;

    @Autowired
    private Enseignantview enseignantview;
    @Autowired
    private Etudiantview etudiantview;

    @PostMapping("/save/{idetudiant}/{idenseigant}/{idstage}")
    public DemmendEncadrement save(@RequestBody DemmendEncadrement demmend,
                                   @PathVariable Long idetudiant,
                                   @PathVariable Long idenseigant,
                                   @PathVariable Long idstage) {
        demmend.setEnseignant(enseignantview.getOne(idenseigant));
        demmend.setEtudiant(etudiantview.getOne(idetudiant));
        demmend.setStage(stageview.getOne(idstage));
        demmend.setEtat("enatande");
        return demmendview.save(demmend);
    }

    @PutMapping("/modif/{id}/{idetudiant}/{idenseigant}/{idstage}")
    public DemmendEncadrement modif(@RequestBody DemmendEncadrement demmend,
                                    @PathVariable Long idetudiant,
                                    @PathVariable Long idenseigant,
                                    @PathVariable Long idstage, @PathVariable Long id) {
        demmend.setId(id);
        demmend.setEtat(demmend.getEtat());
        demmend.setEnseignant(enseignantview.getOne(idenseigant));
        demmend.setEtudiant(etudiantview.getOne(idetudiant));
        demmend.setStage(stageview.getOne(idstage));
        return demmendview.save(demmend);
    }

    @DeleteMapping("/delete/{id_ut}")
    public HashMap delete(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            demmendview.deleteById(id);
            hashMap.put("etat", "DemmendEncadrement supprimee");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "DemmendEncadrement non trouvee");
            return hashMap;
        }
    }

    @GetMapping("/accept/{iddemmend}")
    public DemmendEncadrement acceptencadrement(@PathVariable Long iddemmend) {
        DemmendEncadrement demmendEncadrement = demmendview.getOne(iddemmend);
        demmendEncadrement.setEtat("acepter");
        return demmendview.save(demmendEncadrement);
    }

    @GetMapping("/refuser/{iddemmend}")
    public DemmendEncadrement refuserncadrement(@PathVariable Long iddemmend) {
        DemmendEncadrement demmendEncadrement = demmendview.getOne(iddemmend);
        demmendEncadrement.setEtat("refuser");
        return demmendview.save(demmendEncadrement);
    }

    @GetMapping("/allenattent/{idensegnat}")
    public List<DemmendEncadrement> listdemandeenatente(@PathVariable Long idensegnat) {
        List<DemmendEncadrement> demmendEncadrement = new ArrayList<>();
        for (DemmendEncadrement encadrement : demmendview.findAll()) {
            if (encadrement.getEtat().equals("enatande")&& encadrement.getEnseignant().getId_utilisateur().equals(idensegnat))
            {
                demmendEncadrement.add(encadrement);


            }

        }
        return demmendEncadrement;
    }

    @GetMapping("/alldemande/{idensegnat}")
    public List<DemmendEncadrement> listdemande(@PathVariable Long idensegnat) {
        List<DemmendEncadrement> demmendEncadrement = new ArrayList<>();
        for (DemmendEncadrement encadrement : demmendview.findAll()) {
            if (encadrement.getEnseignant().getId_utilisateur().equals(idensegnat))
            {
                demmendEncadrement.add(encadrement);


            }

        }
        return demmendEncadrement;
    }
    @GetMapping("/getone/{id}")
    public DemmendEncadrement getoneDemande(@PathVariable Long id) {
        return demmendview.getOne(id);
    }
    @GetMapping("/alldemandeetudiant/{idetudiant}")
    public List<DemmendEncadrement> listdemandeetudiant(@PathVariable Long idetudiant) {
        List<DemmendEncadrement> demmendEncadrement = new ArrayList<>();
        for (DemmendEncadrement encadrement : demmendview.findAll()) {
            if (encadrement.getEtudiant().getId_utilisateur().equals(idetudiant))
            {
                demmendEncadrement.add(encadrement);


            }

        }
        return demmendEncadrement;
    }

}
