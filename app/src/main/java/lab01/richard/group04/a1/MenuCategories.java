package lab01.richard.group04.a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MenuCategories {
    public static void main(String[] args) {
        // Create a map to store menu items and their descriptions
        Map<String, String> menu = new HashMap<>();
        List<String> entree = new ArrayList<>();
        List<String> main = new ArrayList<>();
        List<String> dessert = new ArrayList<>();
        List<String> sides = new ArrayList<>();
        List<String> drinks = new ArrayList<>();

        // Populate the menu and category lists
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

        // Create a scanner for user input
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

        // Loop to handle user input

    }

    // Helper method to add a menu item to the appropriate category list
    private static void addMenuItem(Map<String, String> menu, List<String> categoryList, String itemName, String description, String price) {
        menu.put(itemName.toLowerCase(), description);
        categoryList.add(itemName); // Keep item name as-is in the list
    }

    // Helper method to display items in a specific category with price and description
    private static void displayCategory(Map<String, String> menu, List<String> categoryList, String categoryName) {
        System.out.println(categoryName + ":");
        for (String item : categoryList) {
// <<<<<<< HEAD
            System.out.println(item + " - " + getCategoryPrice(item.toLowerCase()) + "\n" ); // Convert item name to lowercase when getting price
// =======
            String itemName = item.toLowerCase();
            String description = menu.get(itemName);
            String price = getCategoryPrice(itemName);

            System.out.println(item + " - $" + price);
            System.out.println("   " + description);
// >>>>>>> 155738f3c563591b44d2858c459e1d0c725aa8cc
        }
        System.out.print("\n");
    }

    // Define method to get the price for a menu item
    private static String getCategoryPrice(String item) {
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
}