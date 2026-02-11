package com.example.GestionRH_SB;

import com.example.GestionRH_SB.dao.EmployeRepository;
import com.example.GestionRH_SB.entity.Employe;
import com.example.GestionRH_SB.entity.Manager;
import com.example.GestionRH_SB.entity.Stagiaire;
import com.example.GestionRH_SB.entity.Technicien;
import com.example.GestionRH_SB.service.EmployeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class GestionRhSbApplication {

	public static void main(String[] args) {
        ApplicationContext ioc_container = SpringApplication.run(GestionRhSbApplication.class, args);
        EmployeRepository repository = ioc_container.getBean(EmployeRepository.class);

        EmployeService service = ioc_container.getBean(EmployeService.class);

//        Employe m1 = new Manager("Zakaria", 3500,"Projet RH", 500);
//        Employe m2 = new Technicien( "Hiba", 4000,"Projet SI", 500);
//        Employe m3 = new Stagiaire("Maria", 2000, "Projet POO");
//        service.ajouterEmploye(m1);
//        service.ajouterEmploye(m2);
//        service.ajouterEmploye(m3);
	}
}
