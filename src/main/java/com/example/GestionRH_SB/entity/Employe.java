package com.example.GestionRH_SB.entity;

import jakarta.persistence.*;

// Classe abstraite
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employes")
public abstract class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private double salaireBase;
    private String projetAffecte; // Remplace HashMap d'affectation

    // constructeur par defaut
    public Employe() {
    }

    // Constructeur complet :
    public Employe(String nom, double salaireBase, String projetAffecte) {
        setNom(nom);
        setSalaireBase(salaireBase);
        setProjetAffecte(projetAffecte);
    }

    // Les setters et les getters :
    public void setNom(String nom){
        if(nom != null && !nom.trim().isEmpty())
            this.nom = nom;
        else
            System.out.println("Nom ne peut pas etre vide!");
    }
    public String getNom(){
        return nom;
    }

    public void setSalaireBase(double salaireBase){
        if(salaireBase >= 0)
            this.salaireBase = salaireBase;
        else
            System.out.println("Salaire ne peut pas etre negatif!");
    }

    public double getSalaireBase() {
        return salaireBase;
    }

    public void setProjetAffecte(String projetAffecte){
        if(projetAffecte != null && !projetAffecte.trim().isEmpty())
            this.projetAffecte = projetAffecte;
        else
            System.out.println("Projet affecter ne peut pas etre vide!");
    }

    public String getProjetAffecte(){
        return projetAffecte;
    }

    // Methode abstraite calculerSalaireNet() :
    public abstract double calculerSalaireNet();

    // Redefinition de toString() pour l'affichage
    @Override
    public String toString() {
        return getClass().getSimpleName() +" | ID: " + id + " | Nom: " + nom + " | Salaire Net: " + calculerSalaireNet() + " DH";
    }
}
