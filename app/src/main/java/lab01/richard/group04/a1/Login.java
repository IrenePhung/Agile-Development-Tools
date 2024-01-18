package lab01.richard.group04.a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> userCredentials = loadCredentialsFromFile("src/main/java/lab01/richard/group04/a1/registration.txt");

        System.out.println("\nWelcome to the Login App!");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (userCredentials.containsKey("admin") && userCredentials.get(username).equals(password)){
            Admin.main(null);

        }
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("\nLogin successful!");
            OrderSystem.main(null);
            
        } else {
            System.out.println("Login failed. Invalid username or password.\n");
            App.main(null);
        }

        scanner.close();
    }

    public static Map<String, String> loadCredentialsFromFile(String fileName) {
        Map<String, String> credentials = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("; ");
                if (parts.length == 4) {
                    String username = parts[2];
                    String password = parts[3];
                    credentials.put(username, password);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while loading credentials.");
            e.printStackTrace();
        }
        return credentials;
    }
}
