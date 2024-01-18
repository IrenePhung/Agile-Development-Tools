package lab01.richard.group04.a1;

import java.util.Scanner;

public class RemoveItems {
    public static void main(String[] args) {
        // Create an instance of the OrderSystem.MenuData class to access the menu data
        OrderSystem.MenuData menuData = OrderSystem.initializeMenu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the current menu
            System.out.println("Current Menu:");
            OrderSystem.displayCategory(menuData.menu, menuData.entree, "Entree");
            OrderSystem.displayCategory(menuData.menu, menuData.main, "Main");
            OrderSystem.displayCategory(menuData.menu, menuData.dessert, "Dessert");
            OrderSystem.displayCategory(menuData.menu, menuData.sides, "Sides");
            OrderSystem.displayCategory(menuData.menu, menuData.drinks, "Drinks");

            // Prompt the user to remove an item


            System.out.print("Enter the category (Entree, Main, Dessert, Sides, or Drinks) from which to remove the item: ");
            String category = scanner.nextLine().trim();

            System.out.print("Enter the name of the item to remove: ");
            String itemNameToRemove = scanner.nextLine().trim();

            // Remove the specified item from the appropriate category in the menu data (case-insensitive)
            switch (category.toLowerCase()) {
                case "entree":
                    menuData.entree.removeIf(item -> item.trim().toLowerCase().equals(itemNameToRemove));
                    break;
                case "main":
                    menuData.main.removeIf(item -> item.trim().toLowerCase().equals(itemNameToRemove));
                    break;
                case "dessert":
                    menuData.dessert.removeIf(item -> item.trim().toLowerCase().equals(itemNameToRemove));
                    break;
                case "sides":
                    menuData.sides.removeIf(item -> item.trim().toLowerCase().equals(itemNameToRemove));
                    break;
                case "drinks":
                    menuData.drinks.removeIf(item -> item.trim().toLowerCase().equals(itemNameToRemove));
                    break;
                default:
                    System.out.println("Invalid category. Item not removed.");
                    break;
            }

            // Remove the item from the menu (case-insensitive)
            menuData.menu.entrySet().removeIf(entry -> entry.getKey().trim().toLowerCase().equals(itemNameToRemove));

            // Display the updated menu
            System.out.println("\nUpdated Menu:");
            OrderSystem.displayCategory(menuData.menu, menuData.entree, "Entree");
            OrderSystem.displayCategory(menuData.menu, menuData.main, "Main");
            OrderSystem.displayCategory(menuData.menu, menuData.dessert, "Dessert");
            OrderSystem.displayCategory(menuData.menu, menuData.sides, "Sides");
            OrderSystem.displayCategory(menuData.menu, menuData.drinks, "Drinks");

            System.out.print("\nDo you want to remove more items? (yes/no): ");
            String removeMoreItems = scanner.nextLine().trim().toLowerCase();

            if (!removeMoreItems.equals("yes")) {
                // Exit the loop if the user does not want to remove more items
                break;
            }


        }
    }
}
