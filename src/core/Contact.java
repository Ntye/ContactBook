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
public class Contact {
    public Contact(String Code, String Nom, Date DoB, String Address, String Email, String TelNum){
        this.mAddress = Address;
        this.mCode = Code;
        this.mDoB = DoB;
        this.mEmail = Email;
        this.mNom = Nom;
        this.mTelNum = TelNum;
    }
    
    public String getCode(){
        return this.mCode;
    }
    
    public void setCode(String Code){
        this.mCode = Code;
    }
    
    public String getNom(){
        return this.mNom;
    }
    
    public void setNom(String Nom){
        this.mNom = Nom;
    }
    
    public Date getDoB(){
        return this.mDoB;
    }
    
    public void setDoB(Date DoB){
        this.mDoB = DoB;
    }
    
    public String getAddress(){
        return this.mAddress;
    }
    
    public void setAddress(String Address){
        this.mAddress = Address;
    }
    
    public String getEmail(){
        return this.mAddress;
    }
    
    public void setEmail(String Email){
        this.mEmail = Email;
    }
    
    public String getTelNum(){
        return this.mTelNum;
    }
    
    public void setTelNum(String TelNum){
        this.mTelNum = TelNum;
    }
    
    protected String mCode;
    protected String mNom;
    protected Date mDoB;
    protected String mAddress;
    protected String mEmail;
    protected String mTelNum;
    
    
    
}
