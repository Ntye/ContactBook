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
    private ArrayList<Contact> contacts;
    

    public Repertoire(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the MySQL database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/contact", "root", "PhineasEF");
            // Initialize the database with the provided contacts
            createTablesIfNotExist();
            initializeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTablesIfNotExist() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS etudiant (Code VARCHAR(255), Nom VARCHAR(255), DateNaissance DATE, Address VARCHAR(255), Email VARCHAR(255), TelNumber VARCHAR(255), Cycle VARCHAR(255), Niveau VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS enseignant (Code VARCHAR(255), Nom VARCHAR(255), DateNaissance DATE, Address VARCHAR(255), Email VARCHAR(255), TelNumber VARCHAR(255), Statut VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS agent (Code VARCHAR(255), Nom VARCHAR(255), DateNaissance DATE, Address VARCHAR(255), Email VARCHAR(255), TelNumber VARCHAR(255), Salaire DOUBLE, Statut VARCHAR(255), Categorie VARCHAR(255), IndiceSalaire INT, Occupation VARCHAR(255))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeDatabase() {
        for (Contact contact : contacts) {
            if (contact instanceof Etudiant) {
                addEtudiant((Etudiant) contact);
            } 
            else if (contact instanceof Enseignant) {
                addEnseignant((Enseignant) contact);
            } 
            else if (contact instanceof Agent) {
                addAgent((Agent) contact);
            }
        }
    }

    private void addEtudiant(Etudiant etudiant) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO etudiant (Code, Nom, DateNaissance, Address, Email, TelNumber, Cycle, Niveau) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, etudiant.getCode());
            statement.setString(2, etudiant.getNom());
            statement.setDate(3, new java.sql.Date(etudiant.getDoB().getTime()));
            statement.setString(4, etudiant.getAddress());
            statement.setString(5, etudiant.getEmail());
            statement.setString(6, etudiant.getTelNum());
            statement.setString(7, etudiant.getCycle());
            statement.setString(8, etudiant.getNiveau());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addEnseignant(Enseignant enseignant) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO enseignant (Code, Nom, DateNaissance, Address, Email, TelNumber, Statut) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, enseignant.getCode());
            statement.setString(2, enseignant.getNom());
            statement.setDate(3, new java.sql.Date(enseignant.getDoB().getTime()));
            statement.setString(4, enseignant.getAddress());
            statement.setString(5, enseignant.getEmail());
            statement.setString(6, enseignant.getTelNum());
            statement.setString(7, enseignant.getStatut());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addAgent(Agent agent) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO agent (Code, Nom, DateNaissance, Address, Email, TelNumber, Salaire, Statut, Categorie, IndiceSalaire, Occupation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, agent.getCode());
            statement.setString(2, agent.getNom());
            statement.setDate(3, new java.sql.Date(agent.getDoB().getTime()));
            statement.setString(4, agent.getAddress());
            statement.setString(5, agent.getEmail());
            statement.setString(6, agent.getTelNum());
            statement.setDouble(7, agent.getSalaire());
            statement.setString(8, agent.getStatut());
            statement.setString(9, agent.getCategorie());
            statement.setInt(10, agent.getIndice());
            statement.setString(11, agent.getOccupation());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Contact searchContactByName(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM etudiant WHERE Nom = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractEtudiantFromResultSet(resultSet);
            }

            statement = connection.prepareStatement("SELECT * FROM enseignant WHERE Nom = ?");
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractEnseignantFromResultSet(resultSet);
            }

            statement = connection.prepareStatement("SELECT * FROM agent WHERE Nom = ?");
            statement.setString(1, name);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractAgentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Contact not found
    }

    private Contact extractEtudiantFromResultSet(ResultSet resultSet) throws SQLException {
        return new Etudiant(
                resultSet.getString("Code"),
                resultSet.getString("Nom"),
                resultSet.getDate("DateNaissance"),
                resultSet.getString("Address"),
                resultSet.getString("Email"),
                resultSet.getString("TelNumber"),
                resultSet.getString("Cycle"),
                resultSet.getString("Niveau")
        );
    }

    private Contact extractEnseignantFromResultSet(ResultSet resultSet) throws SQLException {
        return new Enseignant(
                resultSet.getString("Code"),
                resultSet.getString("Nom"),
                resultSet.getDate("DateNaissance"),
                resultSet.getString("Address"),
                resultSet.getString("Email"),
                resultSet.getString("TelNumber"),
                resultSet.getString("Statut")
        );
    }

    private Contact extractAgentFromResultSet(ResultSet resultSet) throws SQLException {
        return new Agent(
                resultSet.getString("Code"),
                resultSet.getString("Nom"),
                resultSet.getDate("DateNaissance"),
                resultSet.getString("Address"),
                resultSet.getString("Email"),
                resultSet.getString("TelNumber"),
                resultSet.getInt("Salaire"),
                resultSet.getString("Statut"),
                resultSet.getString("Categorie"),
                resultSet.getInt("IndiceSalaire"),
                resultSet.getString("Occupation")
        );
    }
    
    public void modifyEtudiant(Etudiant etudiant, String newCode, String newName, Date newDateNaissance, String newAddress, String newEmail, String newTelNumber, String newCycle, String newNiveau) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE etudiant SET Code=?, Nom=?, DateNaissance=?, Address=?, Email=?, TelNumber=?, Cycle=?, Niveau=? WHERE Code=?");
            statement.setString(1, newCode);
            statement.setString(2, newName);
            statement.setDate(3, new java.sql.Date(newDateNaissance.getTime()));
            statement.setString(4, newAddress);
            statement.setString(5, newEmail);
            statement.setString(6, newTelNumber);
            statement.setString(7, newCycle);
            statement.setString(8, newNiveau);
            statement.setString(9, etudiant.getCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyEnseignant(Enseignant enseignant, String newCode, String newName, Date newDateNaissance, String newAddress, String newEmail, String newTelNumber, String newStatut) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE enseignant SET Code=?, Nom=?, DateNaissance=?, Address=?, Email=?, TelNumber=?, Statut=? WHERE Code=?");
            statement.setString(1, newCode);
            statement.setString(2, newName);
            statement.setDate(3, new java.sql.Date(newDateNaissance.getTime()));
            statement.setString(4, newAddress);
            statement.setString(5, newEmail);
            statement.setString(6, newTelNumber);
            statement.setString(7, newStatut);
            statement.setString(8, enseignant.getCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyAgent(Agent agent, String newCode, String newName, Date newDateNaissance, String newAddress, String newEmail, String newTelNumber, int newSalaire, String newStatut, String newCategorie, int newIndiceSalaire, String newOccupation) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE agent SET Code=?, Nom=?, DateNaissance=?, Address=?, Email=?, TelNumber=?, Salaire=?, Statut=?, Categorie=?, IndiceSalaire=?, Occupation=? WHERE Code=?");
            statement.setString(1, newCode);
            statement.setString(2, newName);
            statement.setDate(3, new java.sql.Date(newDateNaissance.getTime()));
            statement.setString(4, newAddress);
            statement.setString(5, newEmail);
            statement.setString(6, newTelNumber);
            statement.setInt(7, newSalaire);
            statement.setString(8, newStatut);
            statement.setString(9, newCategorie);
            statement.setInt(10, newIndiceSalaire);
            statement.setString(11, newOccupation);
            statement.setString(12, agent.getCode());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
