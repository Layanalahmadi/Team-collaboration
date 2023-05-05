package dentsOasis;

public class Appointment
{
    private String appointmentTime;
    private String appointmentDate;
    
    public Appointment(){
    
    }
    public Appointment(String time, String date){
        appointmentTime = time;
    	appointmentDate = date;
    }
    private String getAppointmentTime(){
        return appointmentTime;
    }
    private void setAppointmentTime(String appointmentTime){
        this.appointmentTime = appointmentTime;
    }
    private String getAppointmentDate(){
        return appointmentDate;
    }
    private void setAppointmentDate(String appointmentDate){
        this.appointmentDate = appointmentDate;
    }
}