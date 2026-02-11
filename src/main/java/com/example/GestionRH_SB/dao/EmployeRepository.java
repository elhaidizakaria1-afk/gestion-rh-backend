package com.example.GestionRH_SB.dao;

import com.example.GestionRH_SB.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, String> {
    // Spring génère tout seul : save(), findAll(), deleteById(), etc.
    // Communique avec la base de donnees
}
