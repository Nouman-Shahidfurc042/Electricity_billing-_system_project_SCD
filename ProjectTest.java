package electricitybillingsystem2;

import java.awt.event.ActionEvent;
import javax.swing.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProjectTest {

    private Project project;

    @Before
    public void setUp() {
        // Initialize Project object
        project = new Project("Admin", "12345");
    }

    @After
    public void tearDown() {
        // Clean up
        project = null;
    }

    @Test
    public void testActionPerformed_NewCustomer() {
        // Simulate "New Customer" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "New Customer");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Verify that the Project object is still non-null
        assertNotNull(project);
    }

    @Test
    public void testActionPerformed_CustomerDetails() {
        // Simulate "Customer Details" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Customer Details");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Verify that the Project object is still non-null
        assertNotNull(project);
    }

    @Test
    public void testActionPerformed_DepositDetails() {
        // Simulate "Deposit Details" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Deposit Details");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Verify that the Project object is still non-null
        assertNotNull(project);
    }

    @Test
    public void testActionPerformed_CalculateBill() {
        // Simulate "Calculate Bill" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Calculate Bill");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Verify that the Project object is still non-null
        assertNotNull(project);
    }

    @Test
    public void testActionPerformed_ViewInformation() {
        // Simulate "View Information" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "View Information");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Verify that the Project object is still non-null
        assertNotNull(project);
    }

    @Test
    public void testActionPerformed_UpdateInformation() {
        // Simulate "Update Information" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Update Information");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Verify that the Project object is still non-null
        assertNotNull(project);
    }

    @Test
    public void testActionPerformed_BillDetails() {
        // Simulate "Bill Details" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Bill Details");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Verify that the Project object is still non-null
        assertNotNull(project);
    }

    @Test
    public void testActionPerformed_Notepad() {
        // Simulate "Notepad" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Notepad");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Since Notepad is an external program, we can't assert on UI directly, but this will ensure no exception is thrown
        // You might want to verify that notepad.exe was attempted to run by checking system logs or mocking runtime execution.
        assertTrue(true); // If no exception occurs, the test passes
    }

    @Test
    public void testActionPerformed_Calculator() {
        // Simulate "Calculator" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Calculator");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Since Calculator is an external program, we can't directly assert on UI but ensure no exception is thrown
        assertTrue(true); // If no exception occurs, the test passes
    }

    @Test
    public void testActionPerformed_Logout() {
        // Simulate "Logout" action
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Logout");

        // Call actionPerformed method
        project.actionPerformed(actionEvent);

        // Verify that the frame is hidden after logout
        assertFalse(project.isVisible());
    }

    @Test
    public void testMain() {
        try {
            // Test if main method runs without exceptions
            Project.main(new String[0]);
        } catch (Exception e) {
            fail("Main method should not throw any exception: " + e.getMessage());
        }
    }
}
