package com.example.GestionRH_SB.ws;

import com.example.GestionRH_SB.entity.Employe;
import com.example.GestionRH_SB.entity.Manager;
import com.example.GestionRH_SB.entity.Stagiaire;
import com.example.GestionRH_SB.entity.Technicien;
import com.example.GestionRH_SB.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    @Autowired
    private EmployeService service;

    // Case 1 : Afficher tous les employés
    @GetMapping("afficherTout")
    public List<Employe> afficherTout() {
        return service.afficherEmploes();
    }

    // Case 2 : POST : Ajouter (Employe, Manager, Technicien, Stagiaire)
    @PostMapping("/ajouterManager")
    public void ajouter(@RequestBody Manager m) {
        service.ajouterEmploye(m);
    }
    @PostMapping("/ajouterTechnicien")
    public void ajouter(@RequestBody Technicien t) {
        service.ajouterEmploye(t);
    }
    @PostMapping("/ajouterStagiaire")
    public void ajouter(@RequestBody Stagiaire s) {
        service.ajouterEmploye(s);
    }

    // Case 3 : PUT : Évaluer un employé (Modifie sa note/prime)
    @PutMapping("/{id}/evaluer")
    public String evaluer(@PathVariable String id, @RequestParam int note) {
        return service.noterEmploye(id, note);
    }

    // Case 4 : DELETE : Supprimer un employé
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.supprimerEmploye(id);
    }
}