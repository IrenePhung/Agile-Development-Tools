
package lab01.richard.group04.a1;

import java.util.HashMap;
import java.util.Map;

public class OrderCart {
    private final Map<String, Integer> cart;

    // create cart
    public OrderCart() {
        cart = new HashMap<>();
    }

    // add menu items to cart
    public void addItem(String menuItem, int quantity) {
        if (cart.containsKey(menuItem)) {
            int currentQuantity = cart.get(menuItem);
            cart.put(menuItem, currentQuantity + quantity);
        } else {
            cart.put(menuItem, quantity);
        }
        System.out.println(quantity + "x " + menuItem + " added to the cart");
    }

    // display items
    public void displayCart() {
        System.out.println("Order Cart Contents: ");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        OrderCart cart = new OrderCart();

        // add items to cart
        cart.addItem("Hamburger", 2);
        cart.displayCart();
    }

}