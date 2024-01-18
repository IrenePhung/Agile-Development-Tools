package lab01.richard.group04.a1;

import java.util.Scanner;

class AddItems {
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

            // Prompt the user to add an item
            System.out.print("Enter the category (Entree, Main, Dessert, Sides, or Drinks) to add the item: ");
            String category = scanner.nextLine().trim();

            System.out.print("Enter the name of the item to add: ");
            String itemNameToAdd = scanner.nextLine().trim();

            System.out.print("Enter the description of the item: ");
            String itemDescriptionToAdd = scanner.nextLine().trim();

            double itemPriceToAdd = 0.0;
            boolean validPrice = false;
            while (!validPrice) {
                System.out.print("Enter the price of the item: ");
                try {
                    itemPriceToAdd = Double.parseDouble(scanner.nextLine().trim());
                    validPrice = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price format. Please enter a valid number.");
                }
            }

            // Add the specified item to the appropriate category in the menu data
            switch (category.toLowerCase()) {
                case "entree":
                    menuData.entree.add(itemNameToAdd);
                    break;
                case "main":
                    menuData.main.add(itemNameToAdd);
                    break;
                case "dessert":
                    menuData.dessert.add(itemNameToAdd);
                    break;
                case "sides":
                    menuData.sides.add(itemNameToAdd);
                    break;
                case "drinks":
                    menuData.drinks.add(itemNameToAdd);
                    break;
                default:
                    System.out.println("Invalid category. Item not added.");
                    break;
            }

            // Add the item to the menu
            menuData.menu.put(itemNameToAdd.toLowerCase(), itemDescriptionToAdd);

            // Display the updated menu
            System.out.println("\nUpdated Menu:");
            OrderSystem.displayCategory(menuData.menu, menuData.entree, "Entree");
            OrderSystem.displayCategory(menuData.menu, menuData.main, "Main");
            OrderSystem.displayCategory(menuData.menu, menuData.dessert, "Dessert");
            OrderSystem.displayCategory(menuData.menu, menuData.sides, "Sides");
            OrderSystem.displayCategory(menuData.menu, menuData.drinks, "Drinks");

            System.out.print("\nDo you want to add more items? (yes/no): ");
            String addMoreItems = scanner.nextLine().trim().toLowerCase();

            if (!addMoreItems.equals("yes")) {
                // Exit the loop if the user does not want to add more items
                break;
            }
        }
        // scanner.close(); // Close the scanner when done
    }

}