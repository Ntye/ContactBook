/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.util.Date;

/**
 *
 * @author Petite Voisine
 */
public class Enseignant extends Contact {
    public Enseignant(String Code, String Nom, Date DoB, String Address, String Email, String TelNum, String Statut){
        super(Code, Nom, DoB, Address, Email, TelNum);
        this.mStatut = Statut;
    }
    
    public String getStatut(){
        return this.mStatut;
    }
    
    public void setStatut(String Statut){
        this.mStatut = Statut;
    }
    
    private String mStatut;
}
