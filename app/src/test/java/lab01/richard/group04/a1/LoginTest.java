package lab01.richard.group04.a1;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach; // Import this for @AfterEach



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private static final String TEST_CREDENTIALS_FILE = "test_credentials.txt";

    @BeforeEach
    void setUp() {
        // Create a test credentials file with sample user data
        createTestCredentialsFile();
    }


    @Test
    void testLoadCredentialsFromFileWithEmptyFile() {
        // Arrange
        String emptyFile = "empty_credentials.txt";
        createEmptyFile(emptyFile);

        // Act
        Map<String, String> userCredentials = Login.loadCredentialsFromFile(emptyFile);

        // Assert
        assertNotNull(userCredentials);
        assertTrue(userCredentials.isEmpty());
    }

    @Test
    void testLoadCredentialsFromFileWithMalformedData() {
        // Arrange
        String malformedFile = "malformed_credentials.txt";
        createMalformedFile(malformedFile);

        // Act
        Map<String, String> userCredentials = Login.loadCredentialsFromFile(malformedFile);

        // Assert
        assertNotNull(userCredentials);
        assertTrue(userCredentials.isEmpty());
    }

    private void createTestCredentialsFile() {
        try (FileWriter writer = new FileWriter(TEST_CREDENTIALS_FILE)) {
            // Sample user data
            writer.write("User Name 1; user1; password1\n");
            writer.write("User Name 2; user2; password2\n");
            writer.write("Admin User; admin; adminpass\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmptyFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Empty file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createMalformedFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Malformed data without semicolon
            writer.write("User Name 1 user1 password1\n");
            writer.write("User Name 2 user2 password2\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    static void tearDown() {
        // Clean up the test credentials file after tests
        File testFile = new File(TEST_CREDENTIALS_FILE);
        if (testFile.exists() && testFile.isFile()) {
            testFile.delete();
        }
    }
}
