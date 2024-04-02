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
    
    

    public Repertoire(ArrayList<Etudiant> etudiants) {
        
    }
    
    public Repertoire(ArrayList<Enseignant> enseignants) {
        
    }
    
    public Repertoire(ArrayList<Agent> agents) {
        
    }
    
    
}
