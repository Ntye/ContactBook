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
public class Agent extends Contact {
    public Agent(String Code, String Nom, Date DoB, String Address, String Email, String TelNum, int Salaire, String Statut, String Categorie, int Indice, String Occupation){
        super(Code, Nom, DoB, Address, Email, TelNum);
        this.mSalaire = Salaire;
        this.mStatut = Statut;
        this.mCategorie = Categorie;
        this.mIndice = Indice;
        this.mOccupation = Occupation;
    }
    
    public int getSalaire(){
        return this.mSalaire;
    }
    
    public void setSalaire(int Salaire){
        this.mSalaire = Salaire;
    }
    
    public String getStatut(){
        return this.mStatut;
    }
    
    public void setStatut(String Statut){
        this.mStatut = Statut;
    }
    
    public String getCategorie(){
        return this.mCategorie;
    }
    
    public void setCategorie(String Categorie){
        this.mCategorie = Categorie;
    }
    
    public int getIndice(){
        return this.mIndice;
    }
    
    public void setIndice(int Indice){
        this.mIndice = Indice;
    }
    public String getOccupation(){
        return this.mOccupation;
    }
    
    public void setOccupation(String Occupation){
        this.mOccupation = Occupation;
    }
    
    private int mSalaire;
    private String mStatut;
    private String mCategorie;
    private int mIndice;
    private String mOccupation;
}
