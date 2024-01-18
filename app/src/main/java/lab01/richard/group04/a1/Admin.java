package lab01.richard.group04.a1;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class Admin {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (true){
        System.out.println("1. Order from restaurant\n");
        System.out.println("2. Add to Menu \n");
        System.out.println ("3. Delete from Menu \n ");
        System.out.println("4. Edit existing Menu \n");
        System.out.println("5. Total numbers of orders processed \n");
        System.out.println("6. Order History \n");
        System.out.println("7. Exit \n");
        System.out.print(" PICK YOUR CHOICE:");
        
        String choice = scanner.nextLine().toLowerCase();
        // Scanner scanner = new Scanner(System.in);
        // String choice = scanner.nextLine().toLowerCase();
        if ("order from restaurant".equalsIgnoreCase(choice) || "1".equalsIgnoreCase(choice)) {
            MenuCategories.main(null);
        }
        if ("add to menu".equalsIgnoreCase(choice) || "2".equalsIgnoreCase(choice)) {
            AddItems.main(null);
        }
        if ("delete from menu".equalsIgnoreCase(choice) || "3".equalsIgnoreCase(choice)){
            RemoveItems.main(null);
        }
        if ("edit existing menu".equalsIgnoreCase(choice) || "4".equalsIgnoreCase(choice)){
            ExistingMenu.main(null);
        }
        if ("total numbers of orders processed".equalsIgnoreCase(choice) || "5".equalsIgnoreCase(choice)){
            int totalOrders = totalOrders(null);
            System.out.println(totalOrders);
        }
        if ("order history".equalsIgnoreCase(choice) || "6".equalsIgnoreCase(choice)){
            orderHistory(null);
        }
        if ("exit".equalsIgnoreCase(choice) || "7".equalsIgnoreCase(choice)) {
            // close terminal
            scanner.close();
            break;
        }
    }

    }

    public static int totalOrders(String args[]){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/lab01/richard/group04/a1/orders.txt"))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // Return -1 to indicate an error
        }
    }
   
    public static void orderHistory(String[] args) {
        System.out.println("\n ORDER HISTORY\n");
        String fileName = "src/main/java/lab01/richard/group04/a1/orders.txt"; 
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void viewUserProfile(String[] args) {
        String fileName = "src/main/java/lab01/richard/group04/a1/registration.txt"; 
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteUserProfile(String user) {
        Map<String, String> userCredentials = loadCredentialsFromFile("src/main/java/lab01/richard/group04/a1/registration.txt");
      
        if (userCredentials.containsKey(user) ) {
            userCredentials.remove(user);
            
        } else {
            System.out.println("User not found.");
        }
           
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
