package electricitybillingsystem2;

import org.junit.Before;
import org.junit.Test;
import java.awt.event.ActionEvent;
import java.sql.*;

import static org.junit.Assert.*;

public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        login = new Login(); // Initialize the Login window
    }

    @Test
    public void testComponentsInitialization() {
        // Test if all components are initialized correctly
        assertNotNull("Username field should be initialized", login.username);
        assertNotNull("Password field should be initialized", login.password);
        assertNotNull("Login in Choice should be initialized", login.logginin);
        assertNotNull("Login button should be initialized", login.login);
        assertNotNull("Cancel button should be initialized", login.cancel);
        assertNotNull("Signup button should be initialized", login.signup);
    }

    @Test
    public void testValidLogin() {
        try {
            // Insert a dummy user into the database for testing
            Conn connection = new Conn();
            String insertQuery = "INSERT INTO login (username, password, user, meter_no) VALUES ('testUser', 'testPass', 'Admin', '12345')";
            connection.s.executeUpdate(insertQuery);

            // Simulate user input for valid login
            login.username.setText("testUser");
            login.password.setText("testPass");
            login.logginin.select("Admin");

            // Simulate login button click
            login.actionPerformed(new ActionEvent(login.login, ActionEvent.ACTION_PERFORMED, null));

            // Assert that the login window is not visible (assumes successful login)
            assertFalse("Login window should close on successful login", login.isVisible());

            // Cleanup test data from the database
            String deleteQuery = "DELETE FROM login WHERE username = 'testUser'";
            connection.s.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            fail("SQL Exception during valid login test: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidLogin() {
        // Simulate invalid user input
        login.username.setText("wrongUser");
        login.password.setText("wrongPass");
        login.logginin.select("Admin");

        // Simulate login button click
        login.actionPerformed(new ActionEvent(login.login, ActionEvent.ACTION_PERFORMED, null));

        // Assert that the username and password fields are cleared
        assertEquals("Username field should be cleared after invalid login", "", login.username.getText());
        assertEquals("Password field should be cleared after invalid login", "", new String(login.password.getPassword()));

        // Assert that the login window remains visible
        assertTrue("Login window should remain visible after invalid login", login.isVisible());
    }

    @Test
    public void testCancelButtonAction() {
        // Simulate cancel button click
        login.actionPerformed(new ActionEvent(login.cancel, ActionEvent.ACTION_PERFORMED, null));

        // Assert that the login window is closed
        assertFalse("Login window should close when cancel button is clicked", login.isVisible());
    }

    @Test
    public void testSignupButtonAction() {
        // Simulate signup button click
        login.actionPerformed(new ActionEvent(login.signup, ActionEvent.ACTION_PERFORMED, null));

        // Assert that the login window is closed
        assertFalse("Login window should close when signup button is clicked", login.isVisible());
        // Additional checks can be added if `Signup` creates a visible window
    }
}
