package lab01.richard.group04.a1;

import java.util.*;

public class ExistingMenu extends OrderSystem {

    public static void main(String[] args) {
        MenuData menuData = initializeMenu();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Existing Menu Editor!");

        while (true) {
            System.out.println("\nWhat would you like to modify?");
            System.out.println("1. Item Name");
            System.out.println("2. Price");
            System.out.println("3. Description");
            System.out.println("4. Show Menu");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1/2/3/4/5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    modifyItemName(menuData);
                    break;
                case 2:
                    modifyPrice(menuData);
                    break;
                case 3:
                    modifyDescription(menuData);
                    break;
                case 4:
                    displayUpdatedMenu(menuData);
                    break;
                case 5:
                    System.out.println("Exiting the Existing Menu Editor.");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    // Modify a category name
    private static void modifyCategory(MenuData menuData) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category name you want to change: ");
        String oldCategoryName = scanner.nextLine().trim();

        // Check if the old category name exists
        if (isCategoryNameValid(oldCategoryName)) {
            System.out.print("Enter the new category name: ");
            String newCategoryName = scanner.nextLine().trim();

            // Rename the category
            if ("entree".equalsIgnoreCase(oldCategoryName)) {
                replaceListElement(menuData.entree, "Entree", newCategoryName);
            } else if ("main".equalsIgnoreCase(oldCategoryName)) {
                replaceListElement(menuData.main, "Main", newCategoryName);
            } else if ("dessert".equalsIgnoreCase(oldCategoryName)) {
                replaceListElement(menuData.dessert, "Dessert", newCategoryName);
            } else if ("sides".equalsIgnoreCase(oldCategoryName)) {
                replaceListElement(menuData.sides, "Sides", newCategoryName);
            } else if ("drinks".equalsIgnoreCase(oldCategoryName)) {
                replaceListElement(menuData.drinks, "Drinks", newCategoryName);
            }

            System.out.println("Category name changed successfully.");
        } else {
            System.out.println("Category not found.");
        }
    }
    // Check if the old category name is valid
    public static boolean isCategoryNameValid(String categoryName) {
        return "entree".equalsIgnoreCase(categoryName) ||
                "main".equalsIgnoreCase(categoryName) ||
                "dessert".equalsIgnoreCase(categoryName) ||
                "sides".equalsIgnoreCase(categoryName) ||
                "drinks".equalsIgnoreCase(categoryName);
    }

    // Helper method to replace an element in a list
    private static void replaceListElement(List<String> list, String oldElement, String newElement) {
        for (int i = 0; i < list.size(); i++) {
            if (oldElement.equalsIgnoreCase(list.get(i))) {
                list.set(i, newElement);
            }
        }
    }


    // Display the updated menu
    private static void displayUpdatedMenu(MenuData menuData) {
        System.out.println("Updated Menu:");
        displayCategory(menuData.entree, "Entree", menuData);
        displayCategory(menuData.main, "Main", menuData);
        displayCategory(menuData.dessert, "Dessert", menuData);
        displayCategory(menuData.sides, "Sides", menuData);
        displayCategory(menuData.drinks, "Drinks", menuData);
    }

    // Display items within a category
    private static void displayCategory(List<String> category, String categoryName, MenuData menuData) {
        System.out.println(categoryName + ":");

        for (String itemName : category) {
            String description = menuData.menu.get(itemName.toLowerCase());
            String price = menuData.menu.get(itemName.toLowerCase() + " - price");

            // Nếu giá không có trong menuData.menu, lấy từ OrderSystem
            if (price == null) {
                price = OrderSystem.getCategoryPrice(itemName); // giả định bạn có một hàm như thế này
            }

            System.out.println(itemName + " - " + price);
            System.out.println("   " + description);
        }
    }


    private static void modifyItemName(MenuData menuData) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the item name you want to change: ");
        String oldItemName = scanner.nextLine().trim();

        // Check if the old item name exists
        if (isItemNameValid(oldItemName, menuData)) {
            System.out.print("Enter the new item name: ");
            String newItemName = scanner.nextLine().trim();

            // Change the item name and update the description
            updateItemNameAndDescription(menuData, oldItemName, newItemName);

            System.out.println("Item name changed successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }
    public static boolean isItemNameValid(String itemName, MenuData menuData) {
        return menuData.menu.containsKey(itemName.toLowerCase());
    }

    // Update the item name and description
    private static void updateItemNameAndDescription(MenuData menuData, String oldItemName, String newItemName) {
        String oldItemDescription = menuData.menu.get(oldItemName.toLowerCase());
        String oldPrice = menuData.menu.get(oldItemName.toLowerCase() + " - price");

        if (oldItemDescription != null) {
            menuData.menu.put(newItemName.toLowerCase(), oldItemDescription);
        }
        if (oldPrice != null) {
            menuData.menu.put(newItemName.toLowerCase() + " - price", oldPrice);
        }

        for (List<String> categoryList : Arrays.asList(menuData.entree, menuData.main, menuData.dessert, menuData.sides, menuData.drinks)) {
            for (int i = 0; i < categoryList.size(); i++) {
                if (oldItemName.equalsIgnoreCase(categoryList.get(i))) {
                    categoryList.set(i, newItemName);
                }
            }
        }
    }




    private static void modifyDescription(MenuData menuData) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the item name for which you want to change the description: ");
        String itemName = scanner.nextLine().trim().toLowerCase();

        if (menuData.menu.containsKey(itemName)) {
            System.out.print("Enter the new description: ");
            String newDescription = scanner.nextLine().trim();

            // Update the description in menuData.menu
            menuData.menu.put(itemName, newDescription);

            System.out.println("Description changed successfully.");
        } else {
            System.out.println("Item not found in the menu.");
        }
    }

    // Modify the price of an item
    private static void modifyPrice(MenuData menuData) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the item name you want to change the price for: ");
        String itemName = scanner.nextLine().trim().toLowerCase();

        // Check if the item name exists
        if (menuData.menu.containsKey(itemName)) {
            System.out.print("Enter the new price (leave blank to keep the current price): ");
            String newPrice = scanner.nextLine().trim();

            // If newPrice is not empty, update the price
            if (!newPrice.isEmpty()) {
                // Update the price in menuData.menu
                menuData.menu.put(itemName.toLowerCase() + " - price", "$" + newPrice);

                System.out.println("Price updated successfully.");
            } else {
                System.out.println("Price unchanged.");
            }
        } else {
            System.out.println("Item not found.");
        }
    }

}