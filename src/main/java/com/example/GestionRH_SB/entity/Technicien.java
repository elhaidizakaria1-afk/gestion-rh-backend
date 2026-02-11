package com.example.GestionRH_SB.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// Class fille Technicien herite de Employe
@Entity
@Table(name = "technicien")
public class Technicien extends Employe implements PerformanceEvaluator{
    private double indemniteRisque;
    private double note;

    // Consructeur par defaut
    public Technicien() {
    }

    // Constructeur complet :
    public Technicien(String nom, double salaireBase, String projetAffecte, double indemniteRisque){
        super(nom,salaireBase, projetAffecte);
        setIndemniteRisque(indemniteRisque);
    }

    // Les setters et les getters :
    public void setIndemniteRisque(double indemniteRisque){
        if(indemniteRisque >= 0)
            this.indemniteRisque = indemniteRisque;
        else
            System.out.println("L'indemnite risque ne peut pas etre negatif!");
    }
    public double getIndemniteRisque(){
        return indemniteRisque;
    }

    // Redefinition de la methode calculerSalaireNet() :
    @Override
    public double calculerSalaireNet(){
        return (getSalaireBase() * 0.75) + getIndemniteRisque();
    }

    // Redefinition de la methode abstract evaluerPerformance() de l'interface evaluerPerformance
    @Override
    public int evaluerPerformance(int note) {
        System.out.println("Performance évaluée pour le Technicien: " + note);
        return note;
    }
}
