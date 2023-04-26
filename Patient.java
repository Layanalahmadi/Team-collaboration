package sprint1;

/**
 *
 * @author Hp
 */
public class Patient {
    
    private int patient_ID;
    private String patient_name;
    private String patient_mobile;
    private String patient_email;
    private String patient_username;
    private String patient_password;
    private String patient_address;
    
    public Patient(){
        this.patient_ID = 0;
        this.patient_name = "";
        this.patient_mobile = "";
        this.patient_email = "";
        this.patient_username = "";
        this.patient_password = "";
        this.patient_address = "";
    }
    public Patient(int id, String name, String mobile, String email, 
            String username, String password, String address){
        this.patient_ID = id;
        this.patient_name = name;
        this.patient_mobile = mobile;
        this.patient_email = email;
        this.patient_username = username;
        this.patient_password = password;
        this.patient_address = address;
    }
    // getter and setter
    public int getId(){
        return patient_ID;
    }
    public void setId(int id){
        this.patient_ID = id;
    }
    public String getName(){
        return patient_name;
    }
    public void setName(String name){
        this.patient_name = name;
    }
    public String getMobile(){
        return patient_mobile;
    }
    public void setMobile(String mobile){
        this.patient_mobile = mobile;
    }
    public String getEmail(){
        return patient_email;
    }
    public void setEmail(String email){
        this.patient_email = email;
    }
    public String getUsername(){
        return patient_username;
    }
    public void setUsername(String username){
        this.patient_username = username;
    }
    public String getPassword(){
        return patient_password;
    }
    public void setPassword(String password){
        this.patient_password = password;
    }
    public String getAddress(){
        return patient_address;
    }
    public void setAddress(String address){
        this.patient_address = address;
    }
    
}