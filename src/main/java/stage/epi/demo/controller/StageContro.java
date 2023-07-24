package stage.epi.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.epi.demo.interfa.Enseignantview;
import stage.epi.demo.interfa.Entrepriseview;
import stage.epi.demo.interfa.Etudiantview;
import stage.epi.demo.interfa.Stageview;
import stage.epi.demo.modele.Enseignant;
import stage.epi.demo.modele.Entreprise;
import stage.epi.demo.modele.Etudiant;
import stage.epi.demo.modele.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/stage")
public class StageContro {
    @Autowired
    private Stageview stageview;

    @Autowired
    private Enseignantview enseignantview;
    @Autowired
    private Etudiantview etudiantview;
    @Autowired
    private Entrepriseview entrepriseview;
    @ResponseBody
    @PostMapping("/save/{idprop}")
    public Stage save(@RequestBody Stage stage, @PathVariable Long idprop) {

        for (Enseignant enseignant : enseignantview.findAll()) {
            if (idprop.equals(enseignant.getId_utilisateur())) {
                stage.setEnseignant(enseignantview.getOne(idprop));

            }
        }
        for (Etudiant etudiant : etudiantview.findAll()) {
            if (idprop.equals(etudiant.getId_utilisateur())) {
                stage.setEtudiant(etudiantview.getOne(idprop));

            }
        }
        for (Entreprise entreprise : entrepriseview.findAll()) {
            if (idprop.equals(entreprise.getId_entreprise())) {
                stage.setEntreprise(entrepriseview.getOne(idprop));

            }
        }

        return stageview.save(stage);
    }

    @PutMapping("/modifier/{idstage}")
    public Stage modif(@RequestBody Stage stage, @PathVariable Long idstage) {
        Stage stageanc=stageview.getOne(idstage);
     /*   for (Enseignant enseignant : enseignantview.findAll()) {
            if (idprop.equals(enseignant.getId_utilisateur())) {
                stage.setEnseignant(enseignantview.getOne(idprop));

            }
        }

        for (Etudiant etudiant : etudiantview.findAll()) {
            if (idprop.equals(etudiant.getId_utilisateur())) {
                stage.setEtudiant(etudiantview.getOne(idprop));

            }
        }
        for (Entreprise entreprise : entrepriseview.findAll()) {
            if (idprop.equals(entreprise.getId_entreprise())) {
                stage.setEntreprise(entrepriseview.getOne(idprop));
        }*/
        if(stage.getTheme()==null){
            stage.setTheme(stageanc.getTheme());
        }
        if(stage.getDuree()==null){
            stage.setDuree(stageanc.getDuree());
        }  if(stage.getType()==null){
            stage.setType(stageanc.getType());
        } if(stage.getDate_debut()==null){
            stage.setDate_debut(stageanc.getDate_debut());
        }if(stage.getDate_fin()==null){
            stage.setDate_fin(stageanc.getDate_fin());
        }if(stage.getReference()==null){
            stage.setReference(stageanc.getReference());
        }if(stage.getDescription()==null){
            stage.setDescription(stageanc.getDescription());
        }if(stage.getNote()==null){
            stage.setNote(stageanc.getNote());
        }
        if(stage.getRapport()==null){
            stage.setRapport(stageanc.getRapport());
        }
        if(stage.getSujet()==null){
            stage.setSujet(stageanc.getSujet());
        }

        stage.setId(idstage);
        stageview.saveAndFlush(stage);
        return stage;
    }

    @GetMapping("/getall")
    public List<Stage> getAllStage() {
        return stageview.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public HashMap delete(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            stageview.deleteById(id);
            hashMap.put("etat", "stage supprimee");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "stage non trouvee");
            return hashMap;
        }
    }

    @GetMapping("/effectierstage/{idetudient}/{idstage}")
    public Stage effectierstage(@PathVariable Long idetudient, @PathVariable Long idstage) {
        Stage stage = stageview.getOne(idstage);
        Etudiant etudiant = etudiantview.getOne(idetudient);
        List<Etudiant> list = stage.getEtudiantList();
        System.out.println(list.size());
        System.out.println(list.size()+1);
        if(list.size()==0){
            list.add(0, etudiant);
        }else
            list.add(list.size(), etudiant);


        stage.setEtudiantList(list);
        return stageview.save(stage);

    }
    @GetMapping("/getone/{id}")
    public Stage getoneStage(@PathVariable Long id) {
        return stageview.getOne(id);
    }


    @GetMapping("/getetudiantbystage/{idstage}")
    public List<Etudiant>getetudiantbystage(@PathVariable Long idstage){
       return  stageview.getOne(idstage).getEtudiantList();
    }
/*    @GetMapping("/getstagebyenseignant/{idprop}")
    public List<Stage> getstagebyenseignant( @PathVariable Long idprop) {

        List<Stage> stages = new ArrayList<>();

        try{
        for (Stage stage : stageview.findAll()) {
            if (stage.getEnseignant().getId_utilisateur().equals(idprop)) {
                stages.add(stage);

            }


                }
        return stages;

            }catch (Exception e){

        System.out.println(e.getMessage());
            return null;}
    }*/
/*
    @GetMapping("/getstagebyetudient/{idprop}")
    public List<Stage> getstagebyetudient( @PathVariable Long idprop) {

        List<Stage> stages = new ArrayList<>();

        try{
            for (Stage stage : stageview.findAll()) {
                if  (stage.getEtudiant().getId_utilisateur().equals(idprop)) {

                    stages.add(stage);


                }


            }
            return stages;

        }catch (Exception e){

            System.out.println(e.getMessage());
            return null;}
    }*/



/*@GetMapping("/ajoutfavorie/{idstage}/{idetudiant}")
    private Stage ajoutfavorie(@PathVariable Long idstage,@PathVariable Long idetudiant){
        Stage stage=stageview.getOne(idstage);
    List<Long> list = stage.getIdpreferer();
    System.out.println(list.size());
    System.out.println(list.size()+1);
    if(list.size()==0){
        list.add(0, idetudiant);
    }else
        list.add(list.size(), idetudiant);


    stage.setIdpreferer(list);

    return stage;

}*/
/*    @GetMapping("/allfavoriebyme/{idetudiant}")
    private  List<Stage> allfavoriebyme(@PathVariable Long idetudiant){
        List<Stage> stages = new ArrayList<>();
        for (Stage stage : stageview.findAll()) {
                if  (stage.getIdpreferer().contains(idetudiant)) {

                    stages.add(stage);


                }


            }
            return stages;


        }*/

}
