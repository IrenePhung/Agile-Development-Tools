package lab01.richard.group04.a1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class OrderSystemTest {

    private OrderSystem.MenuData menuData;
    Map<String, Integer> orderCart;

    @BeforeEach
    public void MenuData() {
        menuData = OrderSystem.initializeMenu();
        orderCart = new HashMap<>();}


    @Test
    public void testAddMenuItem() {
        Map<String, String> menu = new HashMap<>();
        List<String> categoryList = new ArrayList<>();

        OrderSystem.addMenuItem(menu, categoryList, "TestItem", "Test description", "5.00");

        assertTrue(menu.containsKey("testitem"));
        assertEquals("Test description", menu.get("testitem"));
        assertTrue(categoryList.contains("TestItem"));
    }

    @Test
    public void testGetCategoryPrice() {
        assertEquals("8.00", OrderSystem.getCategoryPrice("garlic bread"));
        assertEquals("15.00", OrderSystem.getCategoryPrice("prawns"));
        assertEquals("33.00", OrderSystem.getCategoryPrice("spaghetti bolognese"));
        assertEquals("5.00", OrderSystem.getCategoryPrice("unknown item"));
    }

    @Test
    public void testAddToCart() {
        OrderSystem.addToCart(orderCart, "garlic bread", 2);
        assertTrue(orderCart.containsKey("garlic bread"));
        assertEquals(2, orderCart.get("garlic bread").intValue());

        OrderSystem.addToCart(orderCart, "garlic bread", 3);
        assertEquals(5, orderCart.get("garlic bread").intValue());
    }

    @Test
    public void testOrderProcess() {
        String simulatedUserInput = "Garlic Bread\n"  // Select Garlic Bread
                + "2\n"             // Choose 2 quantity
                + "exit\n"          // Exit the menu selection
                + "yes\n"           // Confirm the order
                + "pickup\n";       // Choose pickup

        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OrderSystem.main(null);

        String output = outContent.toString();
        assertTrue(output.contains("2x garlic bread added to the cart"));
        assertTrue(output.contains("Order Cart Contents:"));
        assertTrue(output.contains("garlic bread - $8.00"));
        assertTrue(output.contains("Quantity: 2"));
        assertTrue(output.contains("Item Total: $16.00"));
        assertTrue(output.contains("Total Amount: $16.00"));
        assertTrue(output.contains("Your order will be ready for pickup."));
    }

    @BeforeEach
    public void setUp() {
        orderCart = new HashMap<>();
    }

    /*@Test
    public void testAddToCartWithNegativeQuantity() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderSystem.addToCart(orderCart, "garlic bread", -2);
        });

        assertTrue(exception.getMessage().contains("Invalid quantity"));
    }

    @Test
    public void testAddToCartWithInvalidItem() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            OrderSystem.addToCart(orderCart, "invalid item", 2);
        });

        assertTrue(exception.getMessage().contains("Item not found"));
    }*/
   




}

