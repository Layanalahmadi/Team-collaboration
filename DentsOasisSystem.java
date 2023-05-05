package dentsOasis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DentsOasisSystem
{
    public static void main(String[] args)
    {
                Scanner scanner = new Scanner(System.in);
                List<Dentist> dentists = new ArrayList<>();
                List<Patient> patients = new ArrayList<>();
        
        
                System.out.println("********* Welcome to the DentsOasis *********");
                System.out.println();
                System.out.println("Dentist or patient?");
                System.out.println("1. Dentist");
                System.out.println("2. Patient");
                System.out.println("3. Exit");
                int input = scanner.nextInt();

                switch (input) {
                    case 1:
                        System.out.println("\n*** DENTIST PAGE ***");
                        System.out.println("*** Choose the following ***");
                        System.out.println("1. Login");
                        System.out.println("2. Register");
                        System.out.println("3. Exit");
                        
                        int select = scanner.nextInt();
                        scanner.nextLine();
                        switch (select) {
                            case 1:
                               if(loginDentist()!=true)
                                   System.out.println("not found");
                               else {
                                System.out.println("\n*** DENTIST PAGE ***");
                                System.out.println("*** Choose the following ***");
                                System.out.println("1. Edit information");
                                System.out.println("2. View appointments");
                                System.out.println("3. Exit");

                                int choice = scanner.nextInt();
                                scanner.nextLine();

                                switch (choice) {
                                    case 1:
                                        System.out.println("1. Edit Dentist Details");

                                        System.out.print("Enter specialty: ");
                                        String specialty = scanner.nextLine();
                                        
                                        System.out.print("Enter Qualifications: ");
                                        String Qualifications = scanner.nextLine();
                                        
                                        System.out.print("Enter Experience: ");
                                        String Experience = scanner.nextLine();
                                       
                                        System.out.print("Enter city: ");
                                        String city = scanner.nextLine();
                                       
                                        
                                        // Create a new Doctor object and add it to the ArrayList
                                        Dentist dentist = new Dentist(specialty,Qualifications, Experience, city);
                                        dentists.add(dentist);

                                    case 3:
                                        break;

                                    default:
                                        System.out.println("Try again");
                                }
                                
                            }                               
                                break;
                            case 2:
                            	registerDentist();
                                break;
                            case 3:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Try again");
                                break;     
                        }
                        break;
                    case 2:
                    	System.out.println("\n*** PATIENT PAGE ***");
                        System.out.println("*** Choose the following ***");
                        System.out.println("1. Login");
                        System.out.println("2. Register");
                        System.out.println("3. Exit");
                        select = scanner.nextInt();
                        scanner.nextLine();
                        switch (select) {
                            case 1:
                                if(loginPatient()!=true) 
                                    System.out.println("not found");

                                else {

                                System.out.println("\n*** PATIENT MENU ***");
                                System.out.println("1. Search for Dentist");
                                System.out.println("2. View Dentist Details");
                                System.out.println("3. Provide Review for a Dentist");
                                System.out.println("4. Book an Appointment");
                                System.out.println("5. Exit");
                                System.out.print("Enter your choice: ");
                                int choice = scanner.nextInt();
                                scanner.nextLine();

                                switch (choice) {
                                case 1:
                                    System.out.print("Enter city: ");
                                    String city = scanner.nextLine();
                                    System.out.print("Enter specialty: ");
                                    String specialty = scanner.nextLine();

                                    List<Dentist> searchResults = searchDentist(dentists, city, specialty);
                                    if (searchResults.size() == 0) {
                                        System.out.println("No dentists found in " + city + " with " + specialty + " specialization.");
                                    } else {
                                        System.out.println("Search Results:");
                                        System.out.println("ID\tDentist Name\tSpecialty\tQualifications\tExperience");
                                        for (int i = 0; i < searchResults.size(); i++) {
                                            Dentist dentist = searchResults.get(i);
                                            System.out.println(i+1 + "\t" + dentist.getName() + "\t" + dentist.getSpecialty() + "\t" +
                                                    dentist.getQualification() + "\t" + dentist.getExperience());
                                        }
                                    }
                                    break; // add this break statement
                                   
                                    default:
                                        System.out.println("Try again");
                                }
                            }
                                break;
                            case 2:
                            	patients.add(registerPatient());
                                break;
                            case 3:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Try again");
                                break;
                        
                        }
                }
                
                
}

    public static List<Dentist> searchDentist(List<Dentist> dentists, String city, String specialty) {
        List<Dentist> results = new ArrayList<>();
                
        for (Dentist dentist : dentists) {
            if (dentist.getCity().equals(city) && dentist.getSpecialty().equals(specialty)) {
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
     
       public static boolean loginDentist() {
           Scanner keyboard = new Scanner(System.in);
		   Dentist dentist = new Dentist();

    	   System.out.println("\n**** Login for Dentist **** ");
		   System.out.println("Enter Username :");
		    dentist.setUsername(keyboard.nextLine()); 
		   System.out.println("Enter Password : ");
		    dentist.setPassword(keyboard.nextLine()); 
       
        	try {
        	Scanner scan = new Scanner(new FileReader("dentist.txt"));
        	while (scan.hasNextLine()) {
        	String line = scan.nextLine();
        	String[] details = line.split(",");
        	if (details[0].equals(dentist.getUsername()) && details[1].equals(dentist.getPassword())) {
        	return true;
        	
        } 
       }
      }
        	catch (FileNotFoundException e) {
        	e.printStackTrace();
        	}
        	
        	
        	return false;
       }
       
       public static void registerDentist()  {
     	  Scanner keyboard = new Scanner(System.in);
          Dentist dentist = new Dentist();
          
          
     	   System.out.println("\n**** Register for Dentist **** ");
     	   
     	   
     	       System.out.println("Enter your username : ");
     	          dentist.setUsername(keyboard.nextLine()); 
			   if (isValidUsername(dentist.getUsername()) != true) {
				 System.out.println("Please Try again ");
	 			   System.out.println("Enter valid username : ");
	 			  dentist.setUsername(keyboard.nextLine()); 
			   }
			   System.out.println("Enter your password : ");
			   dentist.setPassword(keyboard.nextLine()); 
			   
			   
			 if (isValidPassword(dentist.getPassword()) != true) {
				 System.out.println("Please Try again ");
	 			 System.out.println("Should contains numbers, special character,  and length between 8 to 10 ");
	 			   System.out.println("Enter valid password : ");
	 			  dentist.setPassword(keyboard.nextLine()); 
			   }
			 
			   System.out.println("Enter your mobile : ");
			   dentist.setPhoneNumber(keyboard.nextLine()); 
			   
			 if (isValidPhoneeNumber(dentist.getPhoneNumber()) != true) {
				 System.out.println("Please Try again ");
	 			   System.out.println("Enter valid phone number : ");
	 			  dentist.setPhoneNumber(keyboard.nextLine()); 
			   }
			   System.out.println("Enter your email : ");
			   dentist.setEmail(keyboard.nextLine()); 
			 if (isValidEmail(dentist.getEmail()) != true) {
				 System.out.println("Please Try again ");
	 			   System.out.println("Enter valid email : ");
	 			  dentist.setEmail(keyboard.nextLine()); 
			   }
			   
			   System.out.println("Enter your City : ");
			   dentist.setCity(keyboard.nextLine()); 
			   
			   System.out.println("Enter your Specialty : ");
			   dentist.setSpecialty(keyboard.nextLine()); 
			   
			   System.out.println("Enter your Qualifications : ");
			   dentist.setDentistQualification(keyboard.nextLine()); 
 		  
			   System.out.println("Enter your Experience : ");
			   dentist.setExperience(keyboard.nextLine()); 
 		  
				
				
 		  try {
        	   FileWriter write = new FileWriter("dentist.txt");
		    	PrintWriter print = new PrintWriter(write);
		    	print.print(dentist.getUsername()+ "," +  dentist.getPassword() + "," + dentist.getPhoneNumber()
	             +"," + dentist.getEmail() + "," + dentist.getCity()+ "," + dentist.getSpecialty() + "," + dentist.getQualification()+ "," + dentist.getExperience() +  ",\n");
	 			   System.out.println(" Successful registration ");

		    	print.close();
           }
			 catch (IOException e) {
				e.printStackTrace();
			}
      
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
 	        	   FileWriter write = new FileWriter("patient.txt");
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