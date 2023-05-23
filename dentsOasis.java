package dentsOasis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class dentsOasis
{

    public static void main(String[] args) throws IOException
    {
                Scanner scanner = new Scanner(System.in);
                
                ArrayList<Dentist> dentists = new ArrayList<>();

                Dentist dentist1 = new Dentist("Layan", "0548402813", "layan@gmail.com" , "Makkah", "Orthodontist", "10 years", "phd");
                dentists.add(dentist1);
                Dentist dentist2 = new Dentist("Lama", "0547392023", "lama@gmail.com" , "Jeddah", "Periodontist", "7years", "master");
                dentists.add(dentist2);
                Dentist dentist3 = new Dentist("Raghad", "0585729224", "raghad@gmail.com" , "Riyadh", "Endodontist", "5 years", "bachelor");
                dentists.add(dentist3);
                Dentist dentist4 = new Dentist("Mohammed", "0543839112", "moha@gmail.com" , "Makkah", "Orthodontist", "20 years", "phd");
                dentists.add(dentist4);
                
                
                Appointment appointment1 = new Appointment(1, "10:00 AM", "2023-05-01");
                Appointment appointment2 = new Appointment(2, "11:00 AM", "2023-05-01");
                dentist1.addAppointment(appointment1);
                dentist1.addAppointment(appointment2);     

                
                
                Appointment appointment3 = new Appointment("10:00 AM", "2023-05-01");
                Appointment appointment4 = new Appointment("11:00 AM", "2023-05-01");
                dentist4.addAppointment(appointment3);
                dentist4.addAppointment(appointment4);     
                
                
                Appointment appointment5 = new Appointment("10:00 AM", "2023-05-01");
                Appointment appointment6 = new Appointment("11:00 AM", "2023-05-01");
                dentist3.addAppointment(appointment5);
                dentist3.addAppointment(appointment6);     
                
                
                Appointment appointment7 = new Appointment("10:00 AM", "2023-05-01");
                Appointment appointment8 = new Appointment("11:00 AM", "2023-05-01");
                dentist2.addAppointment(appointment7);
                dentist2.addAppointment(appointment8);   

           
                System.out.println("\n\t********* Welcome to the DentsOasis *********");
                System.out.println();
                
                    	System.out.println("\n    *** PATIENT PAGE ***");
                        System.out.println("*** Choose the following ***");
                        System.out.println("1. Login");
                        System.out.println("2. Register");
                        System.out.println("3. Exit");
                        System.out.print(">> Enter your choice: ");
                        int select;
                        select = scanner.nextInt();
                        scanner.nextLine();
                        
                        switch (select) {
                            case 1:
                                if(loginPatient()!=true) 
                                    System.out.println("not found");

                                else 
                                {
                                    while(true)
                                    {
                                System.out.println("\n    *** PATIENT MENU ***");
                                System.out.println("1. Search for Dentist and Book an Appointment");
                                System.out.println("2. Cancel appointments");
                                System.out.println("3. Provide Review for a Dentist");
                                System.out.println("4. Exit");
                                System.out.print(">> Enter your choice: ");
                                int choice = scanner.nextInt();
                                scanner.nextLine();

                                switch (choice) 
                                {
                                case 1:
                                    
                                    System.out.print("\nEnter city: ");
                                    String city = scanner.nextLine();
                                    
                                    System.out.print("Enter specialty: ");
                                    String specialty = scanner.nextLine();
                                    
                                    //call search method
                                    List<Dentist> searchResults = searchDents(city, specialty, dentists);
                                    
                                    if (searchResults.isEmpty()) 
                                    {
                                        System.out.println("Not found.");
                                        return;
                                    }

                                    // display the search results
                                    System.out.print("\n>> Search results:");
                                    
                                    for (int i = 0; i < searchResults.size(); i++) {
                                        System.out.println();
                                        Dentist dentist = searchResults.get(i);
                                        System.out.println((i + 1) + ". " + dentist.getName() + " - " + dentist.getSpecialty() + " - " + dentist.getCity());
                                        
                                      
                                    }
                                    //Ask the user to book an appointment
                                    System.out.println("\nBook an appointment? Yes or No ");
                                    String in = scanner.nextLine();

                                    if (in.equalsIgnoreCase("yes")) {
                                     Appointment.promptUserToChooseAppointment(dentists);
                                    }
                                    break; // add this break statement
                                case 2:
                                    System.out.println("Cancel Appointment ");

                                	
                                	break; 
                                	
                                case 3:
                                    System.out.println("Review Dentist ");

                                	break;
    
                                case 4:
                                    System.exit(0);
                                    break;
                                default:
                                        System.out.println("Try again");
                                }
                            } // end while
                                } // end else
                                break;
                            case 2:
                            	registerPatient();
                                break;
                            case 3:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Try again");
                                break;
                        
                        
                                }
    
                }// end main
                
                

    public static ArrayList<Dentist> searchDents(String city, String specialty, ArrayList<Dentist> dentists) throws IOException {
    	ArrayList<Dentist> results = new ArrayList<>();

    	for (Dentist dentist : dentists) {
    	    if (dentist.getCity().equalsIgnoreCase(city) && dentist.getSpecialty().equalsIgnoreCase(specialty)) {
    	        results.add(dentist);
    	    }
    	}

    	return results;
       
    }
    
    public static boolean loginPatient() {
          Scanner keyboard = new Scanner(System.in);
 		  Patient patient = new Patient();

         
    	   System.out.println("\n**** Login for Patient **** ");
		   System.out.println("Enter Username :");
		    patient.setUsername(keyboard.nextLine()); 
		   System.out.println("Enter Password : ");
		   patient.setPassword(keyboard.nextLine()); 
		   
    	try {
    	Scanner scan = new Scanner(new FileReader("patient.txt"));
    	while (scan.hasNextLine()) {
    	String line = scan.nextLine();
    	String[] details = line.split(",");
    	if (details[0].equals(patient.getUsername()) && details[1].equals(patient.getPassword())) {
    	return true;
    } 
   }
  }
    	catch (FileNotFoundException e) {
    	e.printStackTrace();
    	}
    	return false;
    	}
     
       
       public static Patient registerPatient()  {   
      	      Scanner keyboard = new Scanner(System.in);
     		  Patient patient = new Patient();
      
     		  
         	   System.out.println("\n**** Register for Patient **** ");
 			   
 			 
 	 			   System.out.println("Enter your username : ");
 	 			   patient.setUsername(keyboard.nextLine()); 
 	 			   if (isValidUsername(patient.getUsername()) != true) {
 	 				 System.out.println("Please Try again ");
 	 	 			   System.out.println("Enter valid username : ");
 	 	 			   patient.setUsername(keyboard.nextLine()); 
 	 			   }
 	 			   System.out.println("Enter your password : ");
 	 			   patient.setPassword(keyboard.nextLine()); 
 	 			   
 	 			   
 	 			 if (isValidPassword(patient.getPassword()) != true) {
 	 				 System.out.println("Please Try again ");
 	 	 			   System.out.println("Enter valid password : ");
 	 	 				 System.out.println("Should contains numbers, special character,  and length between 8 to 10 ");

 	 	 			   patient.setPassword(keyboard.nextLine()); 
 	 			   }
 	 			 
 	 			   System.out.println("Enter your mobile : ");
 	 			   patient.setPhoneNumber(keyboard.nextLine()); 
 	 			   
 	 			 if (isValidPhoneeNumber(patient.getPhoneNumber()) != true) {
 	 				 System.out.println("Please Try again ");
 	 	 			   System.out.println("Enter valid phone number : ");
 	 	 			   patient.setPhoneNumber(keyboard.nextLine()); 
 	 			   }
 	 			   System.out.println("Enter your email : ");
 	 			   patient.setEmail(keyboard.nextLine()); 
 	 			 if (isValidEmail(patient.getEmail()) != true) {
 	 				 System.out.println("Please Try again ");
 	 	 			   System.out.println("Enter valid email : ");
 	 	 			   patient.setEmail(keyboard.nextLine()); 
 	 			   }
 	 			   
 	 			   System.out.println("Enter your city : ");
 	 			   patient.setCity(keyboard.nextLine()); 
 			 
 	           try {
 	        	   FileWriter write = new FileWriter("patient.txt", true);
 			    	PrintWriter print = new PrintWriter(write);
 			    	print.print(patient.getUsername()+ "," +  patient.getPassword() + "," + patient.getPhoneNumber()
 		             +"," + patient.getEmail() + "," + patient.getCity()+ ",\n");
  	 			   System.out.println(" Successful registration ");

 			    	print.close();
 	           }
 				 catch (IOException e) {
 					e.printStackTrace();
 				}
     	
			       return patient;

     		  
      }
       public static boolean isValidUsername(String username) {
    	    String pattern = "^[a-zA-Z0-9]{4,20}$";
    	    return username.matches(pattern);
    	}
       public static boolean isValidPassword(String password) {
    	    boolean hasNumber = password.matches(".*\\d.*");
    	    boolean hasSpecialChar = !password.matches("[a-zA-Z0-9 ]*");
    	    boolean isValidLength = password.length() >= 8 && password.length() <= 10;
    	    return hasNumber && hasSpecialChar && isValidLength;
    	}
       public static boolean isValidPhoneeNumber(String mobileNumber) {
    	    String pattern ="^((\\+|00)966\\s?|0)(5[0-9]{1}|5[5-9]{1}|5[3-4]{1}|59{1}|56{1}|54{1}|53{1})\\s?[0-9]{3}\\s?[0-9]{4}$";
    	    return mobileNumber.matches(pattern);
    	}
       
       public static boolean isValidEmail(String email) {
    	    String pattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    	    return email.matches(pattern);
    	}
}
