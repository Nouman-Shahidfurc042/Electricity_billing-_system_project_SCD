///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package electricitybillingsystem2;
//
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import javax.swing.*;
//import java.awt.event.*;
//
//public class SignupTest {
//    private Signup signupInstance;
//    private JTextField usernameField;
//    private JTextField nameField;
//    private JPasswordField passwordField;
//
//    @Before
//    public void setUp() {
//        signupInstance = new Signup();
//        usernameField = signupInstance.username;
//        nameField = signupInstance.name;
//        passwordField = signupInstance.password;
//    }
//
//    // Test for validateUsername method
//    @Test
//    public void testValidateUsername() {
//        // Test valid username
//        usernameField.setText("validUsername");
//        signupInstance.validateUsername();
//        assertFalse("Username warning should not be visible", signupInstance.usernameWarning.isVisible());
//
//        // Test invalid username (too short)
//        usernameField.setText("ab");
//        signupInstance.validateUsername();
//        assertTrue("Username warning should be visible", signupInstance.usernameWarning.isVisible());
//
//        // Test invalid username (too long)
//        usernameField.setText("thisIsAVeryLongUsernameThatExceedsTheLimit");
//        signupInstance.validateUsername();
//        assertTrue("Username warning should be visible", signupInstance.usernameWarning.isVisible());
//    }
//
//    // Test for validatePassword method
//    @Test
//    public void testValidatePassword() {
//        // Test valid password
//        passwordField.setText("Valid1Password!");
//        signupInstance.validatePassword();
//        assertFalse("Password warning should not be visible", signupInstance.passwordWarning.isVisible());
//
//        // Test invalid password (too short)
//        passwordField.setText("short");
//        signupInstance.validatePassword();
//        assertTrue("Password warning should be visible", signupInstance.passwordWarning.isVisible());
//
//        // Test invalid password (missing uppercase letter)
//        passwordField.setText("validpassword1!");
//        signupInstance.validatePassword();
//        assertTrue("Password warning should be visible", signupInstance.passwordWarning.isVisible());
//
//        // Test invalid password (missing special character)
//        passwordField.setText("ValidPassword1");
//        signupInstance.validatePassword();
//        assertTrue("Password warning should be visible", signupInstance.passwordWarning.isVisible());
//    }
//
//    // Test for actionPerformed method (Create button)
//
//@Test
//public void testActionPerformedCreateButton() {
//    // Set valid values for the fields
//    usernameField.setText("validUsername");
//    nameField.setText("Valid Name");
//    passwordField.setText("Valid1Password!");
//
//    // Explicitly validate the fields before simulating the Create button click
//    signupInstance.validateUsername();
//    signupInstance.validateName();
//    signupInstance.validatePassword();
//
//    // Simulate clicking the "Create" button
//    ActionEvent ae = new ActionEvent(signupInstance.create, ActionEvent.ACTION_PERFORMED, "Create");
//    signupInstance.actionPerformed(ae);
//
//    // Assert that the validation warnings should not be visible after the button action
//    assertFalse("Username warning should not be visible", signupInstance.usernameWarning.isVisible());
//    assertFalse("Password warning should not be visible", signupInstance.passwordWarning.isVisible());
//    assertFalse("Name warning should not be visible", signupInstance.nameWarning.isVisible());
//}
//
//    // Test for actionPerformed method (Back button)
//    @Test
//    public void testActionPerformedBackButton() {
//        // Simulate clicking the "Back" button
//        ActionEvent ae = new ActionEvent(signupInstance.back, ActionEvent.ACTION_PERFORMED, "Back");
//        signupInstance.actionPerformed(ae);
//
//        // Assert that the "Back" action hides the current window and opens the login window
//        assertFalse("Signup frame should be closed", signupInstance.isVisible());
//    }
//
//    // Test for the main method
//    @Test
//    public void testMain() {
//        try {
//            Signup.main(null); // Ensure it doesn't throw exceptions or errors
//        } catch (Exception e) {
//            fail("Main method should not throw any exception: " + e.getMessage());
//        }
//    }
//}


package electricitybillingsystem2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SignupTest {
    private Signup signupInstance;
    private JTextField usernameField;
    private JTextField nameField;
    private JPasswordField passwordField;

    @Before
    public void setUp() {
        signupInstance = new Signup();
        usernameField = signupInstance.username;
        nameField = signupInstance.name;
        passwordField = signupInstance.password;
    }

    // Test for validateUsername method
    @Test
    public void testValidateUsername() {
        // Test valid username
        usernameField.setText("validUsername");
        signupInstance.validateUsername();
        assertFalse("Username warning should not be visible", signupInstance.usernameWarning.isVisible());

        // Test invalid username (too short)
        usernameField.setText("ab");
        signupInstance.validateUsername();
        assertTrue("Username warning should be visible", signupInstance.usernameWarning.isVisible());

        // Test invalid username (too long)
        usernameField.setText("thisIsAVeryLongUsernameThatExceedsTheLimit");
        signupInstance.validateUsername();
        assertTrue("Username warning should be visible", signupInstance.usernameWarning.isVisible());
    }

    // Test for validatePassword method
    @Test
    public void testValidatePassword() {
        // Test valid password
        passwordField.setText("Valid1Password!");
        signupInstance.validatePassword();
        assertFalse("Password warning should not be visible", signupInstance.passwordWarning.isVisible());

        // Test invalid password (too short)
        passwordField.setText("short");
        signupInstance.validatePassword();
        assertTrue("Password warning should be visible", signupInstance.passwordWarning.isVisible());

        // Test invalid password (missing uppercase letter)
        passwordField.setText("validpassword1!");
        signupInstance.validatePassword();
        assertTrue("Password warning should be visible", signupInstance.passwordWarning.isVisible());

        // Test invalid password (missing special character)
        passwordField.setText("ValidPassword1");
        signupInstance.validatePassword();
        assertTrue("Password warning should be visible", signupInstance.passwordWarning.isVisible());
    }

    // Test for actionPerformed method (Create button)
    @Test
    public void testActionPerformedCreateButton() {
        // Set valid values for the fields
        usernameField.setText("validUsername");
        nameField.setText("Valid Name");
        passwordField.setText("Valid1Password!");

        // Explicitly validate the fields before simulating the Create button click
        signupInstance.validateUsername();
        signupInstance.validateName();
        signupInstance.validatePassword();

        // Simulate clicking the "Create" button
        ActionEvent ae = new ActionEvent(signupInstance.create, ActionEvent.ACTION_PERFORMED, "Create");
        signupInstance.actionPerformed(ae);

        // Assert that the validation warnings should not be visible after the button action
        assertFalse("Username warning should not be visible", signupInstance.usernameWarning.isVisible());
        assertFalse("Password warning should not be visible", signupInstance.passwordWarning.isVisible());
        assertFalse("Name warning should not be visible", signupInstance.nameWarning.isVisible());

        // Verify that the new user is inserted into the database
        try {
            Conn connection = new Conn();
            String query = "SELECT * FROM login WHERE username = 'validUsername'";
            ResultSet rs = connection.s.executeQuery(query);
            assertTrue("New user should be created in the database", rs.next());

            // Clean up the test user from the database
            String deleteQuery = "DELETE FROM login WHERE username = 'validUsername'";
            connection.s.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            fail("SQL Exception during testActionPerformedCreateButton: " + e.getMessage());
        }
    }

    // Test for actionPerformed method (Back button)
    @Test
    public void testActionPerformedBackButton() {
        // Simulate clicking the "Back" button
        ActionEvent ae = new ActionEvent(signupInstance.back, ActionEvent.ACTION_PERFORMED, "Back");
        signupInstance.actionPerformed(ae);

        // Assert that the "Back" action hides the current window and opens the login window
        assertFalse("Signup frame should be closed", signupInstance.isVisible());
    }

    // Test for the main method
    @Test
    public void testMain() {
        try {
            Signup.main(null); // Ensure it doesn't throw exceptions or errors
        } catch (Exception e) {
            fail("Main method should not throw any exception: " + e.getMessage());
        }
    }
}
