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
    
    public void ajoutEtudiant(Etudiant etudiant){this.etudiants.add(etudiant);}
    
    public void ajoutEnseignant(Enseignant enseignant){this.enseignants.add(enseignant);}
    
    public void ajoutAgent(Agent agent){this.agents.add(agent);}
    
    public void delEtudiant(Etudiant etudiant){this.etudiants.remove(etudiant);}
    
    public void delEnseignant(Enseignant enseignant){this.enseignants.remove(enseignant);}
    
    public void delAgent(Agent agent){this.agents.remove(agent);}
    
    public int findContact(ArrayList<Contact> contacts, String code){
        for(Contact contact: contacts){
            if(!code.equals(contact.mCode)) return contacts.indexOf(contact);
        }
        return -1;
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
        }
    }
    
    public void updateEtudiant(Etudiant pers, int modify, String change) throws ParseException{
        if(modify < 7) updateContact(pers, modify, change);
        else{
            switch (modify) {
                case 7 -> pers.setCycle(change);
                case 8 -> pers.setNiveau(change);
            }    
        }
    }
    
    public void updateEnseignant(Enseignant pers, int modify, String change) throws ParseException{
        if(modify < 7) updateContact(pers, modify, change);
        else pers.setStatut(change); 
    }
    
    public void updateAgent(Agent pers, int modify, String change) throws ParseException{
        if(modify < 7) updateContact(pers, modify, change);
        else{
            switch (modify) {
                case 7 -> {
                    int e = Integer.parseInt(change);
                    pers.setSalaire(e);
                }
                case 8 -> pers.setStatut(change);
                case 9 -> pers.setCategorie(change);
                case 10 -> {
                    int e = Integer.parseInt(change);
                    pers.setIndice(e);
                }
                case 11 -> pers.setOccupation(change);
            }    
        }
    }

    public void deleteEtudiant(ArrayList<Etudiant> etudiants, int index){etudiants.remove(index);}
    
    public void deleteEnseignant(ArrayList<Enseignant> enseignants, int index){enseignants.remove(index);}
    
    public void deleteAgent(ArrayList<Agent> agents, int index){agents.remove(index);}
}
