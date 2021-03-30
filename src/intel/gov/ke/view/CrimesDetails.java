/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intel.gov.ke.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
    
public class CrimesDetails {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    
    //default constructor
    public CrimesDetails(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
}

