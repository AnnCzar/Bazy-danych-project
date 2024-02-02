package org.example.demo5.zpo;

import org.example.demo5.User;
import org.example.demo5.zpo.uzytkow;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class uzytkowTest {

    @Test
    void testGetters() {
        // Create a user instance for testing
        uzytkow user = new uzytkow("JohnDoe", "Male", 75.5, 180.0, 25, "Moderate", "LoseWeight");

        // Test getters
        assertEquals("JohnDoe", user.getUserName());
        assertEquals("Male", user.getSex());
        assertEquals(75.5, user.getWeight(), 0.01); // Allowing a small delta for double comparison
        assertEquals(180.0, user.getHeight(), 0.01);
        assertEquals(25, user.getAge());
        assertEquals("Moderate", user.getAvgActivity());
        assertEquals("LoseWeight", user.getGoal());
    }

    @Test
    void testAddUser() {
        // Create a user instance for testing
        uzytkow user = new uzytkow("TestUser", "Female", 60.0, 160.0, 30, "High", "MaintainWeight");

        // Create a temporary user for testing (not adding to CSV file)
        User tempUser = new User("TempUser", "Other", 70.0, 170.0, 28, "Low", "BuildMuscle");

        // Add the temporary user to CSV file
        user.addUser(tempUser);

        // TODO: Verify the content of the CSV file or check if the file has been updated
        // (Depending on your actual implementation, this may involve reading the CSV file and checking its content)
    }
}
