package com.example.GestionRH_SB.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// Classe fille Manager herite de Employe
@Entity
@Table(name = "managers")
public class Manager extends Employe implements PerformanceEvaluator{
    private double primeAnnuelle;

    // Constructeur par defaut
    public Manager() {
    }

    // Constructeur complet :
    public Manager(String nom, double salaireBase, String projetAffecte, double primeAnnuelle) {
        super(nom,salaireBase, projetAffecte);
        setPrimeAnnuelle(primeAnnuelle);
    }

    // Les setters et les getters :
    public void setPrimeAnnuelle(double primeAnnuelle){
        if(primeAnnuelle >= 0)
            this.primeAnnuelle = primeAnnuelle;
        else
            System.out.println("Le prime annuelle ne peut pas etre negatif!");
    }
    public double getPrimeAnnuelle(){
        return primeAnnuelle;
    }

    // Redefinition de la methode calculerSalaireNet() :
    @Override
    public double calculerSalaireNet(){
        return (getSalaireBase() * 0.75) + getPrimeAnnuelle();
    }

    // Redefinition de la methode abstract evaluerPerformance() de l'interface evaluerPerformance
    @Override
    public int evaluerPerformance(int note) {
        System.out.println("Performance évaluée pour le Manager: " + note);
        return note;
    }
}
