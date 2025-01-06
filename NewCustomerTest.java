package electricitybillingsystem2;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

public class NewCustomerTest {

    private NewCustomer newCustomer;

    @Before
    public void setUp() {
        // Instantiate the NewCustomer frame
        newCustomer = new NewCustomer();
    }

    @Test
    public void testNextButtonAction() {
        // Simulate user entering data in the form
        newCustomer.tfname.setText("John Doe");
        newCustomer.tfaddress.setText("123 Main St");
        newCustomer.tfcity.setText("New York");
        newCustomer.tfstate.setText("NY");
        newCustomer.tfemail.setText("john.doe@example.com");
        newCustomer.tfphone.setText("1234567890");

        // Simulate the click of the 'Next' button
        ActionEvent actionEvent = new ActionEvent(newCustomer.next, ActionEvent.ACTION_PERFORMED, "Next");
        newCustomer.actionPerformed(actionEvent);

        // The frame should not be visible after the action
        assertFalse(newCustomer.isVisible());
    }

    @Test
    public void testCancelButtonAction() {
        // Simulate the click of the 'Cancel' button
        ActionEvent actionEvent = new ActionEvent(newCustomer.cancel, ActionEvent.ACTION_PERFORMED, "Cancel");
        newCustomer.actionPerformed(actionEvent);

        // After clicking 'Cancel', the frame should be closed, and setVisible(false) should be called
        assertFalse(newCustomer.isVisible());
    }

    @Test
    public void testMeterNumberGeneration() {
        // Verify that the meter number is being generated and displayed
        String meterNumber = newCustomer.lblmeter.getText();
        assertNotNull("Meter number should be generated", meterNumber);
        assertTrue("Meter number should be a valid number", meterNumber.matches("\\d+"));
    }

//    @Test
//    public void testFormValidation() {
//        // Empty fields should trigger no action
//        newCustomer.tfname.setText("");
//        newCustomer.tfaddress.setText("");
//        newCustomer.tfcity.setText("");
//        newCustomer.tfstate.setText("");
//        newCustomer.tfemail.setText("");
//        newCustomer.tfphone.setText("");
//
//        // Simulate the click of the 'Next' button with empty fields
//        ActionEvent actionEvent = new ActionEvent(newCustomer.next, ActionEvent.ACTION_PERFORMED, "Next");
//        newCustomer.actionPerformed(actionEvent);
//
//        // Verify that no action occurs if the fields are empty
//        // In this case, no database query should be executed
//        // In a real case, you would verify if the validation works by checking if the form is not submitted.
//        // But we don't have an actual database, so we'll assume that no action was taken if no frame changes.
//        assertTrue(newCustomer.isVisible()); // Ensure the window is still visible (validation failed)
//    }
    
    

    @Test
    public void testMainMethod() {
        // Test the main method to see if it runs without errors
        String[] args = null;
        NewCustomer.main(args);
    }
}
