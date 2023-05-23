package dentsOasis;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Appointment {

    private String appointmentTime;
    private String appointmentDate;
    private static int number;
    private Dentist dentist;
    public Patient patient;
  
    
    public Appointment() {     
    	

    }
    
    public Appointment(String Time, String Date ) { 
    	appointmentTime = Time;
    	appointmentDate = Date;

    }
    
    public Appointment(int number, String Time, String Date )
    { 
    	this.number = number;
    	appointmentTime = Time;
    	appointmentDate = Date;

    }
    
    public Appointment(Dentist dentist, String patientName, String Time, String Date) {
        this.dentist = dentist;
        Time = appointmentTime;
        Date = appointmentDate;

    }
  
    public Dentist getDentist() {
        return dentist;
    }


    public String getAppointmentTime() {
		return appointmentTime;
	}

    public String getAppointmentDate() {
		return appointmentDate;
	}
    private static int getNumber() {
		return number;
	}
    
    public static void promptUserToChooseAppointment(ArrayList<Dentist> dentists)
    {
    	    Scanner scanner = new Scanner(System.in);

    	    // prompt the user for the dentist's name
    	    System.out.print("\nPlease enter your dentist's name: ");
    	    String input = scanner.nextLine();
    	    
    	    // search for the desired dentist
    	    Dentist dentist = null;
    	    for (Dentist currentDentist : dentists) {
    	        if (currentDentist.getName().equalsIgnoreCase(input)) {
    	            dentist = currentDentist;
    	            break;
    	        }
    	    }
    	    
    	    if (dentist != null) {
    	    System.out.println("\n>>Appointments for " + dentist.getName() + ":");
    	    ArrayList<Appointment> appointments = dentist.getAppointments();
    	    
    	    // display the appointments
    	    int count = 1;
    	    for (Appointment appointment : appointments)
            {
    	        System.out.println(count + ". Date: " + appointment.getAppointmentDate() + 
    	                           "   Time: " + appointment.getAppointmentTime());
    	        count++;
    	    }

    	    // prompt the user to select an appointment
    	    System.out.print("Please enter the number of the appointment you want to select: ");
    	    int selectedAppointment = scanner.nextInt();

    	    if (selectedAppointment > 0 && selectedAppointment <= appointments.size())
            {
    	        // the user selected a valid appointment
    	        System.out.println("\n>> Appointment is done, get well soon \n" + 
    	        		"Your appointment will be on " +    
    	        		appointments.get(selectedAppointment - 1).toString());
                printAppointmentToFile();
                
    	    } else {
    	        // the user entered an invalid appointment number
    	        System.out.println("Invalid appointment number.");
    	    }
            
    	} else {
    	    // the desired dentist was not found
    	    System.out.println("Dentist not found.");
            } 
    
    } // end method 
    
    public static void printAppointmentToFile()
    {
        try {
            FileWriter writeAppointment = new FileWriter("patient.txt", true);
            PrintWriter print2 = new PrintWriter(writeAppointment);
                
            //print2.print("");
                
            print2.close();
            
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public String toString() {
        return  appointmentDate.toString() + " At " + appointmentTime.toString();
    }	
}
