package intel.gov.ke.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
public class TargetDetails {
    private final StringProperty firstname;
    private final StringProperty middlename;
    private final StringProperty surname;
    private final StringProperty idno;
    private final StringProperty workplace;
    private final StringProperty homeplace;
    private final StringProperty criminalrecord;
    
    //default constructor
    public TargetDetails(String firstname, String middlename, String surname, String idno, String workplace, String homeplace, String criminalrecord){
        this.firstname = new SimpleStringProperty(firstname);
        this.middlename = new SimpleStringProperty(middlename);
        this.surname = new SimpleStringProperty(surname);
        this.idno = new SimpleStringProperty(idno);
        this.workplace = new SimpleStringProperty(workplace);
        this.homeplace = new SimpleStringProperty(homeplace);
        this.criminalrecord = new SimpleStringProperty(criminalrecord);
    }
    
    //gets
    public String getFirstname(){
        return firstname.get();
    }
    public String getMiddlename(){
        return middlename.get();
    }
    public String getSurname(){
        return surname.get();
    }
    public String getIdno(){
        return idno.get();
    }
    public String getWorkplace(){
        return workplace.get();
    }
    public String getHomeplace(){
        return homeplace.get();
    }
    public String getCriminalrecord(){
        return criminalrecord.get();
    }
    
    //sets
    public void setFirstname(String value){
        firstname.set(value);
    }
    public void setMiddlename(String value){
        middlename.set(value);
    }
    public void setSurname(String value){
        surname.set(value);
    }
    public void setIdno(String value){
        idno.set(value);
    }
    public void setWorkplace(String value){
        workplace.set(value);
    }
    public void setHomeplace(String value){
        homeplace.set(value);
    }
    public void setCriminalrecord(String value){
        criminalrecord.set(value);
    }
    
    //Property values
    public StringProperty firstnameProperty(){
        return firstname;
    }
    public StringProperty middlenameProperty(){
        return middlename;
    }
    public StringProperty surnameProperty(){
        return surname;
    }
    public StringProperty idnoProperty(){
        return idno;
    }
    public StringProperty workplaceProperty(){
        return workplace;
    }
    public StringProperty homeplaceProperty(){
        return homeplace;
    }
    public StringProperty criminalrecordProperty(){
        return criminalrecord;
    }
}
