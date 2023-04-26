package sprint1;

/**
 *
 * @author Hp
 */

import java.util.Scanner;

public class Sprint1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the patient ID: ");
        int id = input.nextInt();
        System.out.print("Enter the patient name: ");
        String name = input.next();
        System.out.print("Enter the patient mobile: ");
        String mobile = input.next();
        System.out.print("Enter the patient email: ");
        String email = input.next();
        System.out.print("Enter the patient username: ");
        String username = input.next();
        System.out.print("Enter the patient password: ");
        String password = input.next();
        System.out.print("Enter the patient address: ");
        String address = input.next();
        
        Patient patient = new Patient(id,name,mobile,email,username,password,address);
    } 
}