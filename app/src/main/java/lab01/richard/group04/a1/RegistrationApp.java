package lab01.richard.group04.a1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Registration App!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Create a formatted string with the registration details
        String registrationInfo = String.format("%s; %s; %s; %s%n",
        name, email, username, password);

        // Save the registration details to a file
        String fileName = "src/main/java/lab01/richard/group04/a1/registration.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(registrationInfo);
            System.out.println("Registration Successfull");
        } catch (IOException e) {
            System.err.println("An error occurred while saving the registration details.");
            e.printStackTrace();
        }
        App.main(null);
        // scanner.close();
    }
}

