/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author Petite Voisine
 */
public class Repertoire {
    private Connection connection;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<Enseignant> enseignants;
    private ArrayList<Agent> agents;
    ArrayList<Contact> contacts;
    
    

    public Repertoire(ArrayList<Etudiant> etudiants, ArrayList<Enseignant> enseignants, ArrayList<Agent> agents) {
        this.etudiants = etudiants;
        this.enseignants = enseignants;
        this.agents = agents;
    }
    
    public void ajoutEtudiant(Etudiant etudiant){
        this.etudiants.add(etudiant);
    }
    
    public void ajoutEnseignant(Enseignant enseignant){
        this.enseignants.add(enseignant);
    }
    
    public void ajoutAgent(Agent agent){
        this.agents.add(agent);
    }
    
    public void delEtudiant(Etudiant etudiant){
        this.etudiants.remove(etudiant);
    }
    
    public void delEnseignant(Enseignant enseignant){
        this.enseignants.remove(enseignant);
    }
    
    public void delAgent(Agent agent){
        this.agents.remove(agent);
    }
    
    public void findEtudiant(Etudiant etudiant){
        if(contacts.indexOf(etudiant) >= 0){
            System.out.println("Ce contact existe bien dans la liste de contacts");
            System.out.println("Son index dans la liste est: "+ this.contacts.indexOf(pers));
        }else{
            System.out.println("Désolé, ce contact n'existe pas dans la liste de contacts");
        }
    }
    
    public void findEnseignant(Enseignant enseignant){
        if(contacts.indexOf(enseignant) >= 0){
            System.out.println("Ce contact existe bien dans la liste de contacts");
            System.out.println("Son index dans la liste est: "+ this.contacts.indexOf(pers));
        }else{
            System.out.println("Désolé, ce contact n'existe pas dans la liste de contacts");
        }
    }
    
    public void findAgent(Agent agent){
        if(contacts.indexOf(agent) >= 0){
            System.out.println("Ce contact existe bien dans la liste de contacts");
            System.out.println("Son index dans la liste est: "+ this.contacts.indexOf(pers));
        }else{
            System.out.println("Désolé, ce contact n'existe pas dans la liste de contacts");
        }
    }
    
    public void updateContact(Contact pers, int modify, String change) throws ParseException{
        switch (modify) {
            case 1 -> pers.setCode(change);
            case 2 -> pers.setNom(change);
            case 3 -> {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(change);
                pers.setDoB(date);
            }
            case 4 -> pers.setAddress(change);
            case 5 -> pers.setEmail(change);
            case 6 -> pers.setTelNum(change);
//            case 7:
//                pers.setCycle(change);
//                break;
//            case 7:
//                pers.setNiveau(change);
//                break;
//            case 7:
//                pers.setCycle(change);
//                break;   
//            case 7:
//                pers.setNiveau(change);
//                break;  
                
        }
    }
    
    public void updateEtudiant(Etudiant pers, int modify, String change) throws ParseException{
        if(modify < 7) {
            updateContact(pers, modify, change);
            return;
        }
        else{
            switch (modify) {
            case 1 -> pers.setCycle(change);
            case 2 -> pers.setNiveau(change);
            }    
        }
    }
//        if (modify == 7){
//            int change;
//            System.out.println("Veuillez entrer le nouveau niveau");
//            sc.nextLine();
//            change = sc.nextInt();
//            Etudiant e = (Etudiant)pers;
//            e.setNiveau(change);
//        }
//        if (modify == 8){
//            String change;
//            Integer choix;
//            System.out.println("S'agit-il d'un enseignant(0) ou d'un agent(1) ?");
//            choix = sc.nextInt();
//            if (choix == 0){
//                System.out.println("Veuillez entrer le nouveau statut");
//                sc.nextLine();
//                change = sc.nextLine();
//                Enseignant e = (Enseignant)pers;
//                e.setStatut(change);
//            }else {
//                System.out.println("Veuillez entrer le nouveau statut");
//                sc.nextLine();
//                change = sc.nextLine();
//                Agent a = (Agent)pers;
//                a.setStatut(change);
//            }
//        }
//        if (modify == 9){
//            Integer change;
//            System.out.println("Veuillez entrer le nouveau salaire");
//            Agent a = (Agent)pers;
//            change = sc.nextInt();
//            a.setSalaire(change);
//        }
//        if (modify == 10){
//            String change;
//            System.out.println("Veuillez entrer la nouvelle catégorie");
//            Agent a = (Agent)pers;
//            sc.nextLine();
//            change = sc.nextLine();
//            a.setCategorie(change);
//        }
//        if (modify == 11){
//            Integer change;
//            System.out.println("Veuillez entrer le nouvel indice du salaire");
//            Agent a = (Agent)pers;
//            change = sc.nextInt();
//            a.setIndiceSalaire(change);
//        }
//        if (modify == 12){
//            String change;
//            System.out.println("Veuillez entrer la nouvelle occupation");
//            Agent a = (Agent)pers;
//            sc.nextLine();
//            change = sc.nextLine();
//            a.setOccupation(change);
//        }
//         
//    }
}
