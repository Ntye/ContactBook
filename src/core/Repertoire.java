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
import java.util.Date;


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
    
    public void updateContact(Contact pers) throws ParseException{
        Scanner sc = new Scanner(System.in);
        Integer modify;
        System.out.println("Que voulez-vous modifier à propos de ce contact ?");
        System.out.println("Le code ? (0)");
        System.out.println("Le nom ? (1)");
        System.out.println("La date de naissance ? (2)");
        System.out.println("L'adresse ? (3)");
        System.out.println("L'email ? (4)");
        System.out.println("Le numéro de téléphone ? (5)");
        System.out.println("Le cycle ? (6)");
        System.out.println("Le niveau ? (7)");
        System.out.println("Le statut ? (8)");
        System.out.println("Le salaire ? (9)");
        System.out.println("La catégorie ? (10)");
        System.out.println("L'indice de salaire ? (11)");
        System.out.println("L'occupation ? (12)");
        modify = sc.nextInt();
        if (modify == 0){
            String change;
            System.out.println("Veuillez entrer le nouveau code");
            sc.nextLine();
            change = sc.nextLine();
            pers.setCode(change);
        }
        if (modify == 1) {
            String change;
            System.out.println("Veuillez entrer le nouveau nom");
            sc.nextLine();
            change = sc.nextLine();
            pers.setNom(change);
        }
        if (modify == 2) {
            String change;
            System.out.println("Veuillez entrer la nouvelle date de naissance au format (dd/MM/yyyy)");
            sc.nextLine();
            change = sc.nextLine();
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(change);
            pers.setDateDeNaissance(date);
        }
        if (modify == 3){
            String change;
            System.out.println("Veuillez entrer la nouvelle adresse");
            sc.nextLine();
            change = sc.nextLine();
            pers.setAddress(change);
        }
        if (modify == 4){
            String change;
            System.out.println("Veuillez entrer la nouvelle adresse email");
            sc.nextLine();
            change = sc.nextLine();
            pers.setEmail(change);
        }
        if (modify == 5){
            String change;
            System.out.println("Veuillez entrer le nouveau numéro de téléphone");
            sc.nextLine();
            change = sc.nextLine();
            pers.setTelNumber(change);
        }
        if (modify == 6){
            String change;
            System.out.println("Veuillez entrer le nouveau cycle");
            sc.nextLine();
            change = sc.nextLine();
            Etudiant e = (Etudiant)pers;
            e.setCycle(change);
        }
        if (modify == 7){
            int change;
            System.out.println("Veuillez entrer le nouveau niveau");
            sc.nextLine();
            change = sc.nextInt();
            Etudiant e = (Etudiant)pers;
            e.setNiveau(change);
        }
        if (modify == 8){
            String change;
            Integer choix;
            System.out.println("S'agit-il d'un enseignant(0) ou d'un agent(1) ?");
            choix = sc.nextInt();
            if (choix == 0){
                System.out.println("Veuillez entrer le nouveau statut");
                sc.nextLine();
                change = sc.nextLine();
                Enseignant e = (Enseignant)pers;
                e.setStatut(change);
            }else {
                System.out.println("Veuillez entrer le nouveau statut");
                sc.nextLine();
                change = sc.nextLine();
                Agent a = (Agent)pers;
                a.setStatut(change);
            }
        }
        if (modify == 9){
            Integer change;
            System.out.println("Veuillez entrer le nouveau salaire");
            Agent a = (Agent)pers;
            change = sc.nextInt();
            a.setSalaire(change);
        }
        if (modify == 10){
            String change;
            System.out.println("Veuillez entrer la nouvelle catégorie");
            Agent a = (Agent)pers;
            sc.nextLine();
            change = sc.nextLine();
            a.setCategorie(change);
        }
        if (modify == 11){
            Integer change;
            System.out.println("Veuillez entrer le nouvel indice du salaire");
            Agent a = (Agent)pers;
            change = sc.nextInt();
            a.setIndiceSalaire(change);
        }
        if (modify == 12){
            String change;
            System.out.println("Veuillez entrer la nouvelle occupation");
            Agent a = (Agent)pers;
            sc.nextLine();
            change = sc.nextLine();
            a.setOccupation(change);
        }
         
    }
}
