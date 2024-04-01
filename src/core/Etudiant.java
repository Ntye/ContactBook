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
public class Etudiant extends Contact{
    public Etudiant(String Code, String Nom, Date DoB, String Address, String Email, String TelNum, String Cycle, String Niveau){
        super(Code, Nom, DoB, Address, Email, TelNum);
        this.mCycle = Cycle;
        this.mNiveau = Niveau;
    }
    
    public String getCycle(){
        return this.mCycle;
    }
    
    public void setCycle(String Cycle){
        this.mCycle = Cycle;
    }
    
    public String getNiveau(){
        return this.mNiveau;
    }
    
    public void setNiveau(String Niveau){
        this.mNiveau = Niveau;
    }
    
    private String mCycle;
    private String mNiveau;
}
