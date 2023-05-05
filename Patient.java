package dentsOasis;

public class Patient extends User
{
    public Patient(){
    
    }
    public Patient(String Specialist,String experience, String qualification, String name, 
            String phoneNumber, String email, String username, String password, String City){
        
        super(name, phoneNumber, email, username,  password,  City);
    }
    
    public void bookAppointment(){
    
    }	
}