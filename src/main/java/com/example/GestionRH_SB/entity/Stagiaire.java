package com.example.GestionRH_SB.entity;

import jakarta.persistence.Entity;

// Class fille Stagiaire herite de Employe
@Entity
public class Stagiaire extends Employe {
    // Le stagiaire a un montant fixe (forfait), on utilise salaireBase comme montant du forfait

    // Consturcteur par defaut
    public Stagiaire() {
    }

    // Constructeur complet :
    public Stagiaire(String nom, double montantForfait,  String projetAffecte) {
        super(nom, montantForfait,projetAffecte);
    }

    // Redefinition de la methode calculerSalaireNet() :
    @Override
    public double calculerSalaireNet(){
        return getSalaireBase();
    }
}
