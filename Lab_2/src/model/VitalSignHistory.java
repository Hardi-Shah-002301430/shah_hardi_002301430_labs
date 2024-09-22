/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author hardishah
 */
public class VitalSignHistory {
    ArrayList<VitalSigns> history;
    
    public VitalSignHistory(){
        history = new ArrayList<VitalSigns>();
    }
    
    public VitalSigns addNewVitals(){
        VitalSigns newVs = new VitalSigns();
        history.add(newVs);
        return newVs;
    }
    
    public void removeVitalSign (VitalSigns vs){
        history.remove(vs);
    }
    
    public ArrayList<VitalSigns> getHistory(){
        return history; 
    }
}
