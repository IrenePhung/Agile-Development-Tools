package lab01.richard.group04.a1;

import java.util.*;

public class OrderSystem {
    public static class MenuData {
        Map<String, String> menu;
        List<String> entree;
        List<String> main;
        List<String> dessert;
        List<String> sides;
        List<String> drinks;
        public Map<String, Double> prices;
        public MenuData() {
            menu = new HashMap<>();
            prices = new HashMap<>();
        }

        MenuData(Map<String, String> menu, List<String> entree, List<String> main, List<String> dessert, List<String> sides, List<String> drinks) {
            this.menu = menu;
            this.entree = entree;
            this.main = main;
            this.dessert = dessert;
            this.sides = sides;
            this.drinks = drinks;

        }
    }

    public static void main(String[] args) {
        MenuData menuData = initializeMenu();

        Map<String, String> menu = menuData.menu;
        List<String> entree = menuData.entree;
        List<String> main = menuData.main;
        List<String> dessert = menuData.dessert;
        List<String> sides = menuData.sides;
        List<String> drinks = menuData.drinks;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Our Menu!");

        // Display menu by category
        displayCategory(menu, entree, "Entree");
        System.out.println();
        displayCategory(menu, main, "Main");
        System.out.println();
        displayCategory(menu, dessert, "Dessert");
        System.out.println();
        displayCategory(menu, sides, "Sides");
        System.out.println();
        displayCategory(menu, drinks, "Drinks");
        System.out.println();

        // Initialize the order cart
        Map<String, Integer> orderCart = new HashMap<>();

        // Loop to handle user input
        while (true) {
            System.out.print("\nPlease select a menu item (or type 'exit' to quit): ");
            String userChoice = scanner.nextLine().trim().toLowerCase(); // Convert to lowercase and trim any extra spaces

            if (userChoice.equalsIgnoreCase("exit")) {
                break;
            }

            // Check if the userChoice is a valid menu item
            if (menu.containsKey(userChoice)) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Add the selected item to the order cart
                addToCart(orderCart, userChoice, quantity);
            } else {
                System.out.println("Invalid choice. Please select a valid menu item.");
            }
        }

        // Display the order cart contents
        displayOrderCart(orderCart, menu);

        if (confirmOrder(scanner, menu, orderCart)) {
            System.out.println("Thank you for confirming!");
            handleDeliveryOrPickup(scanner);

        }
    }

    // Helper method to add a menu item to the appropriate category list
    public static void addMenuItem(Map<String, String> menu, List<String> categoryList, String itemName, String description, String price) {
        menu.put(itemName.toLowerCase(), description);
        categoryList.add(itemName); // Keep item name as-is in the list
    }

    // Helper method to display items in a specific category with price and description
    public static void displayCategory(Map<String, String> menu, List<String> categoryList, String categoryName) {
        System.out.println(categoryName + ":");
        for (String item : categoryList) {
            String itemName = item.toLowerCase();
            String description = menu.get(itemName);
            String price = getCategoryPrice(itemName);

            System.out.println(item + " - $" + price);
            System.out.println("   " + description);
        }
    }

    public static MenuData initializeMenu() {
        Map<String, String> menu = new HashMap<>();
        List<String> entree = new ArrayList<>();
        List<String> main = new ArrayList<>();
        List<String> dessert = new ArrayList<>();
        List<String> sides = new ArrayList<>();
        List<String> drinks = new ArrayList<>();

        addMenuItem(menu, entree, "Garlic Bread", "A classic appetizer featuring slices of toasted bread infused with garlic and butter, often served with a sprinkle of parsley.", "8.00");
        addMenuItem(menu, entree, "Prawns", "Succulent prawns cooked to perfection, usually served with a choice of dipping sauces.", "15.00");
        addMenuItem(menu, entree, "French Fries", "Crispy and golden potato fries that are a beloved side dish.", "8.00");
        addMenuItem(menu, main, "Spaghetti Bolognese", "A classic Italian pasta dish consisting of al dente spaghetti noodles topped with a rich and savory meat sauce.", "33.00");
        addMenuItem(menu, main, "Chicken Ravioli", "Delicate pockets of pasta filled with a savory mixture of ground chicken, herbs, and sometimes cheese.", "36.00");
        addMenuItem(menu, main, "Tomato Boscaiola", "An Italian pasta dish featuring pasta served with a sauce made from tomatoes, mushrooms, and often pancetta or bacon.", "33.00");
        addMenuItem(menu, dessert, "Gelato", "A smooth and creamy Italian-style ice cream with a rich flavor.", "8.00");
        addMenuItem(menu, dessert, "Banoffee Pie", "A dessert pie that consists of a crumbly biscuit or pastry crust layered with sliced bananas, toffee or caramel sauce, and a generous topping of whipped cream.", "12.00");
        addMenuItem(menu, dessert, "Tiramisu", "A classic Italian dessert made from layers of coffee-soaked ladyfingers and mascarpone cheese, dusted with cocoa powder.", "16.00");
        addMenuItem(menu, sides, "Italian Potatoes", "A simple and versatile side dish that is a comforting addition to any meal.", "8.00");
        addMenuItem(menu, sides, "Broccolini", "A tender and sweeter variant of broccoli, sautéed with garlic and olive oil.", "8.00");
        addMenuItem(menu, sides, "Salad", "A fresh and crisp combination of mixed greens, vegetables, with an oil and vinegar dressing.", "8.00");
        addMenuItem(menu, drinks, "Soft Drink", "Pick your choice of Coke, Pepsi, Sprite, or Fanta.", "5.00");
        addMenuItem(menu, drinks, "Limoncello", "Limoncello is a vibrant and aromatic lemon liqueur that captures the essence of sun-ripened Italian lemons in every sip.", "15.00");
        addMenuItem(menu, drinks, "Italian Red Wine", "Crafted with a blend of red grape varieties, it embodies the essence of red wine enjoyment.", "20.00");


        return new MenuData(menu, entree, main, dessert, sides, drinks);
    }



    // Define method to get the price for a menu item
    public static String getCategoryPrice(String item) {
        switch (item.toLowerCase()) {
            case "garlic bread":
            case "french fries":
            case "gelato":
            case "italian potatoes":
            case "broccolini":
            case "salad":
                return "8.00";
            case "prawns":
            case "soft drink":
            case "limoncello":
                return "15.00";
            case "spaghetti bolognese":
            case "tomato boscaiola":
                return "33.00";
            case "chicken ravioli":
                return "36.00";
            case "banoffee pie":
                return "12.00";
            case "tiramisu":
                return "16.00";
            case "italian red wine":
                return "20.00";
            default:
                return "5.00"; // Default price for unknown items
        }

    }

    // Helper method to add an item to the order cart
    public static void addToCart(Map<String, Integer> orderCart, String itemName, int quantity) {
        if (orderCart.containsKey(itemName)) {
            int currentQuantity = orderCart.get(itemName);
            orderCart.put(itemName, currentQuantity + quantity);
        } else {
            orderCart.put(itemName, quantity);
        }
        System.out.println(quantity + "x " + itemName + " added to the cart");
    }

    // Helper method to display the order cart contents
    private static void displayOrderCart(Map<String, Integer> orderCart, Map<String, String> menu) {
        System.out.println("Order Cart Contents:");
        double totalAmount = 0.0;

        for (Map.Entry<String, Integer> entry : orderCart.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            String description = menu.get(itemName);
            String price = getCategoryPrice(itemName);

            double itemPrice = Double.parseDouble(price);
            double itemTotal = itemPrice * quantity;
            totalAmount += itemTotal;

            System.out.println(itemName + " - $" + price);
            //System.out.println("   " + description);
            System.out.println("   Quantity: " + quantity);
            System.out.println("   Item Total: $" + String.format("%.2f", itemTotal));
            System.out.println();
        }

        System.out.println("Total Amount: $" + String.format("%.2f", totalAmount));
    }
    //adjust items/quantities
    private static boolean confirmOrder(Scanner scanner, Map<String, String> menu, Map<String, Integer> orderCart) {
        while (true) {
            System.out.println("\nConfirm your order (yes/no): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if ("yes".equals(confirmation)) {
                return true;
            }

            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add dishes");
            System.out.println("2. Remove dishes");
            System.out.println("3. Change quantity");
            System.out.println("Enter your choice (1/2/3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1: // Add dishes
                    System.out.print("\nPlease select a menu item to add: ");
                    String itemToAdd = scanner.nextLine().trim().toLowerCase();
                    if (menu.containsKey(itemToAdd)) {
                        System.out.print("Enter quantity: ");
                        int quantityToAdd = scanner.nextInt();
                        scanner.nextLine();
                        addToCart(orderCart, itemToAdd, quantityToAdd);
                    } else {
                        System.out.println("Invalid choice. Please select a valid menu item.");
                    }
                    break;

                case 2: // Remove dishes
                    System.out.print("\nPlease select a menu item to remove: ");
                    String itemToRemove = scanner.nextLine().trim().toLowerCase();
                    if (orderCart.containsKey(itemToRemove)) {
                        orderCart.remove(itemToRemove);
                        System.out.println(itemToRemove + " removed from the cart");
                    } else {
                        System.out.println("Item not found in the cart.");
                    }
                    break;

                case 3: // Change quantity
                    System.out.print("\nPlease select a menu item to change quantity: ");
                    String itemToChange = scanner.nextLine().trim().toLowerCase();
                    if (orderCart.containsKey(itemToChange)) {
                        System.out.print("Enter new quantity: ");
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine();
                        if (newQuantity <= 0) {
                            orderCart.remove(itemToChange);
                            System.out.println(itemToChange + " removed from the cart");
                        } else {
                            orderCart.put(itemToChange, newQuantity);
                            System.out.println("Quantity of " + itemToChange + " updated to " + newQuantity);
                        }
                    } else {
                        System.out.println("Item not found in the cart.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            System.out.println("Your order has now been updated.");
            displayOrderCart(orderCart, menu);
        }
    }
    private static void handleDeliveryOrPickup(Scanner scanner) {
        while (true) {
            System.out.println("\nWould you like to pickup or use the delivery service? (pickup/delivery): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if ("pickup".equals(choice)) {
                System.out.println("Your order will be ready for pickup. Thank you for ordering with us.");
                break;
            } else if ("delivery".equals(choice)) {
                System.out.println("Your order will be delivered. Thank you for ordering with us.");
                break;
            } else {
                System.out.println("Invalid choice. Please choose either 'pickup' or 'delivery'.");
            }
        }
    }



}
