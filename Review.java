package dentsOasis;

public class Review
{
    private Dentist dentist;
    private Patient patient;
    private String comments;
    private int rate;
    
    public Review() {
    	
    }
    public Review(Dentist dentist, Patient patient, int rating, String comments){
        this.setDentist(dentist);
        this.setPatient(patient);
        this.setRate(rating);
        this.setComments(comments);
    }

    public Dentist getDentist(){
        return dentist; 
    }
    public void setDentist(Dentist dentist){
        this.dentist = dentist;
    }
    public Patient getPatient(){
        return patient;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    public String getComments(){
        return comments;
    }
    public void setComments(String comments){
        this.comments = comments;
    }
    public int getRate(){
        return rate;
    }
    public void setRate(int rate){
        this.rate = rate;
    }
}