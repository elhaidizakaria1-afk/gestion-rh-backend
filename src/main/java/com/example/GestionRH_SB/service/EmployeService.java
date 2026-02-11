package com.example.GestionRH_SB.service;

import com.example.GestionRH_SB.dao.EmployeRepository;
import com.example.GestionRH_SB.entity.Employe;
import com.example.GestionRH_SB.entity.PerformanceEvaluator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository repository;

    // 1. Ajout d'un employe a la BDD
    public void ajouterEmploye(Employe e) {
        // Au lieu de listeEmploye.add(e), on fait :
        repository.save(e);
        System.out.println("--> Employé " + e.getNom() + " sauvegardé en BDD !");
    }

    // 2. Noter un employe dans BDD
    @Transactional
    public String noterEmploye(String id, int note) {

        // 1. Recherche de l'employé
        Employe emp = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employé introuvable"));

        // 2. Vérification de l'interface
        if (!(emp instanceof PerformanceEvaluator evaluator)) {
            return "Cet employé (Stagiaire) ne peut pas être évalué.";
        }

        // 3. Evaluation
        int resultat = evaluator.evaluerPerformance(note);

        // 4. Sauvegarde en base
        repository.save(emp);

        return "Note de " + resultat +
                " enregistrée pour " + emp.getNom();
    }

    // 3. Afficher les employes existant dans BDD
    public List<Employe> afficherEmploes(){
        List<Employe> list = repository.findAll();
        if(list.isEmpty())
            System.out.println("Aucun Employe dans la BDD.");
        else{
            System.out.println("--- Liste des Employes ---");
            for(Employe e : list){
                System.out.println(e.toString());
            }
        }
        return list;
    }

    // 4. Supprimer un employe dans BDD
    public void supprimerEmploye(String id) {
        repository.deleteById(id);
    }
}
