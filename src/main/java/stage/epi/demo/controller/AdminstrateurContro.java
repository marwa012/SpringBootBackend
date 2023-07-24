package stage.epi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stage.epi.demo.interfa.Adminstrateurview;
import stage.epi.demo.interfa.Utilisateurview;
import stage.epi.demo.modele.Administrateur;
import stage.epi.demo.modele.Utilisateur;
import stage.epi.demo.service.AccountService;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminstrateurContro {
    @Autowired
    private Adminstrateurview administrateurview;
    @Autowired
    AccountService accountService;
    @Autowired
    Utilisateurview utilsateurview;

    @PostMapping("/save")
    public Administrateur saveadmin(@RequestBody Administrateur administrateur) {
        return accountService.saveAdmin(administrateur);
    }

    @PutMapping("/modifier/{id_ut}")

    public Administrateur modifierAdmin(@RequestBody Administrateur admin, @PathVariable Long id_ut) {

        admin.setId_utilisateur(id_ut);
        administrateurview.saveAndFlush(admin);
        return admin;

    }

    @GetMapping("/getall")
    public List<Administrateur> getAdministaur() {
        return administrateurview.findAll();
    }

    @DeleteMapping("/delete/{id_ut}")
    public HashMap delete(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            administrateurview.deleteById(id);
            hashMap.put("etat", "entrprise supprimee");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "entrprise non trouvee");
            return hashMap;
        }
    }

    @GetMapping("/getprofile")
    public Utilisateur getprofile(Principal p) {
        return utilsateurview.findByUsername(p.getName());
    }

}
