package dentsOasis;

public class Dentist extends User
{
    private String dentistSpecialty;
    private String dentistExperience;
    private String dentistQualification;
    
    public Dentist(){
    
    }
    public Dentist(String Specialty,String qualification, String experience, String city){
        
        super(city);
	dentistSpecialty = Specialty;
	dentistQualification = qualification;
	dentistExperience = experience;
    }
    public Dentist(String Specialty,String experience, String qualification, String name, String phoneNumber,
            String email, String username, String password, String city){
        
        super(name, phoneNumber, email, username,  password,  city);
	dentistSpecialty = Specialty;
	dentistExperience  = experience;
	dentistQualification= qualification;
    }
    
    public String getSpecialty(){
        return dentistSpecialty;
    }
    public void setSpecialty(String dentistSpecialty ){
        this.dentistSpecialty = dentistSpecialty;
    }
    public String getExperience(){
        return dentistExperience;
    }
    public void setExperience(String experience){
        this.dentistExperience = experience;
    }
    public String getQualification(){
        return dentistQualification;
    }
    public void setDentistQualification(String dentistQualification){
        this.dentistQualification = dentistQualification;
    }
    
    public void createProfile(){
        
    }
    public void editProfile(){
        
    }	
}