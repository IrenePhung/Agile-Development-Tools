package lab01.richard.group04.a1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.StandardOpenOption;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final Path ordersFilePath = Paths.get("src/main/java/lab01/richard/group04/a1/orders.txt");
    private final Path registrationFilePath = Paths.get("src/main/java/lab01/richard/group04/a1/registration.txt");

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Test the totalOrders() method by comparing the returned number
     * of orders with the actual number of lines in the 'orders.txt' file.
     */
    @Test
    public void testTotalOrders() throws IOException {
        List<String> lines = Files.readAllLines(ordersFilePath, StandardCharsets.UTF_8);
        int expected = lines.size();

        int actual = Admin.totalOrders(null);

        assertEquals(expected, actual);
    }

    /**
     * Test the orderHistory() method by comparing the printed output
     * to the actual content of the 'orders.txt' file.
     */

    /**
     * Test the viewUserProfile() method by comparing the printed output
     * to the actual content of the 'registration.txt' file.
     */
    @Test
    public void testViewUserProfile() throws IOException {
        List<String> expectedLines = Files.readAllLines(registrationFilePath, StandardCharsets.UTF_8);
        StringBuilder expectedOutput = new StringBuilder();
        for (String line : expectedLines) {
            expectedOutput.append(line).append(System.lineSeparator());
        }

        Admin.viewUserProfile(null);

        assertEquals(expectedOutput.toString(), outContent.toString());
    }
    /**
     * Test for Empty Files: Check the behavior of totalOrders when orders.txt is empty.
     */
    @Test
    public void testTotalOrdersWithEmptyFile() throws IOException {
        // Ensure the file is empty for this test
        Files.write(ordersFilePath, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);

        int actual = Admin.totalOrders(null);
        assertEquals(0, actual, "Expected zero orders for an empty file");
    }
    /**
     * Test the behavior of deleteUserProfile by simulating user deletion.
     */
    @Test
    public void testDeleteUserProfile() throws IOException {
        String user = "testUser";
        Admin.deleteUserProfile(user);

        List<String> updatedLines = Files.readAllLines(registrationFilePath, StandardCharsets.UTF_8);

        // Assert that the user no longer exists in the file
        assertFalse(updatedLines.stream().anyMatch(line -> line.contains(user)), "Expected user to be deleted");
    }






}
