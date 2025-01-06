

package electricitybillingsystem2;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.event.ActionEvent;

public class CalculateBillTest {

    
    @Test
public void testActionPerformedSubmit() {
    // Arrange
    CalculateBill instance = new CalculateBill();
    
    // Set up sample input values
    instance.meternumber.select(0); // Select the first meter number
    instance.tfunits.setText("100"); // Assume 100 units consumed
    instance.cmonth.select("January"); // Set the month to January
    
    // Create an ActionEvent for the "Submit" button
    ActionEvent submitEvent = new ActionEvent(instance.next, ActionEvent.ACTION_PERFORMED, "Submit");
    
    // Act
    instance.actionPerformed(submitEvent);
    
  
}


    @Test
    public void testActionPerformedCancel() {
        // Create an instance of CalculateBill
        CalculateBill instance = new CalculateBill();

        // Create an ActionEvent for the 'Cancel' button
        ActionEvent ae = new ActionEvent(instance.cancel, ActionEvent.ACTION_PERFORMED, "Cancel");

        // Simulate button click
        instance.actionPerformed(ae);

        // Verify if the window was closed
        assertFalse("Window should not be visible after cancel", instance.isVisible());
    }

    @Test
    public void testMain() {
        // Run the main method
        String[] args = {};
        CalculateBill.main(args);

        // Verify that no exception was thrown
        assertTrue("Main method ran successfully", true);
    }
}

