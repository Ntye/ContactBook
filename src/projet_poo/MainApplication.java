/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_poo;

import core.*;
import java.util.Date;
/**
 *
 * @author Petite Voisine
 */
public class MainApplication {
    public static void main(String[] args) {
        Etudiant etudiant = new Etudiant("E001", "John Doe", new Date(), "123 Main St", "john@example.com", "123456789", "Bachelor", "Year 1");

        // Example modification of an Enseignant
        Enseignant enseignant = new Enseignant("T001", "Alice Johnson", new Date(), "789 Oak St", "alice@example.com", "987654321", "Permanent");

        // Example modification of an Agent
        Agent agent = new Agent("A001", "Eva Green", new Date(), "456 Cedar St", "eva@example.com", "456123789", 50000, "Temporary", "Category A", 3, "Secretary");
        
    }
}
