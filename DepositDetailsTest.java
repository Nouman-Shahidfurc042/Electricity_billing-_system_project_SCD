
package electricitybillingsystem2;

import java.awt.event.ActionEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for DepositDetails
 */
public class DepositDetailsTest {

    /**
     * Test for GUI initialization of DepositDetails.
     */
    @Test
    public void testGUIInitialization() {
        System.out.println("Testing GUI Initialization");

        // Create an instance of DepositDetails
        DepositDetails instance = new DepositDetails();

        // Check if all GUI components are initialized
        assertNotNull("Meter Number dropdown should be initialized", instance.meternumber);
        assertNotNull("Month dropdown should be initialized", instance.cmonth);
        assertNotNull("Search button should be initialized", instance.search);
        assertNotNull("Print button should be initialized", instance.print);
        assertNotNull("Table should be initialized", instance.table);

        System.out.println("GUI initialization passed.");
    }

    /**
     * Test for the Meter Number dropdown population.
     */
    @Test
    public void testMeterNumberDropdownPopulation() {
        System.out.println("Testing Meter Number Dropdown Population");

        // Create an instance of DepositDetails
        DepositDetails instance = new DepositDetails();

        // Ensure meter numbers are populated
        int count = instance.meternumber.getItemCount();
        assertTrue("Meter number dropdown should have items", count > 0);

        System.out.println("Meter Number dropdown has " + count + " items.");
    }

    /**
     * Test for the Month drop down population.
     */
    @Test
    public void testMonthDropdownPopulation() {
        System.out.println("Testing Month Dropdown Population");

        // Create an instance of DepositDetails
        DepositDetails instance = new DepositDetails();

        // Ensure months are populated
        int count = instance.cmonth.getItemCount();
        assertTrue("Month dropdown should have items", count > 0);

        System.out.println("Month dropdown has " + count + " items.");
    }

    /**
     * Test for the Search button action.
     */


    /**
     * Test for the Search button with invalid data.
     */
    @Test
    public void testSearchWithInvalidData() {
        System.out.println("Testing Search Button with Invalid Data");

        // Create an instance of DepositDetails
        DepositDetails instance = new DepositDetails();

        // Simulate invalid dropdown selections
        instance.meternumber.select("invalid_meter_number"); // Replace with a value not in the database
        instance.cmonth.select("NonExistentMonth"); // Replace with an invalid month

        // Simulate a button click event for the Search button
        ActionEvent ae = new ActionEvent(instance.search, ActionEvent.ACTION_PERFORMED, "Search");

        try {
            instance.actionPerformed(ae);

            // Verify that the table has zero rows (no results)
            int rowCount = instance.table.getRowCount();
            assertEquals("Table should not have rows for invalid search criteria", 0, rowCount);

            System.out.println("Search button action with invalid data passed. Row count: " + rowCount);
        } catch (Exception e) {
            fail("Exception occurred during Search button action with invalid data: " + e.getMessage());
        }
    }
    
    
    
       /**
     * Test for the Print button action.
     */
    @Test
    public void testPrintButtonAction() {
        System.out.println("Testing Print Button Action");

        // Create an instance of DepositDetails
        DepositDetails instance = new DepositDetails();

        // Simulate a button click event for the Print button
        ActionEvent ae = new ActionEvent(instance.print, ActionEvent.ACTION_PERFORMED, "Print");

        try {
            instance.actionPerformed(ae);

            // If no exception occurs, print action is successful
            assertTrue("Print button action executed successfully.", true);

            System.out.println("Print button action passed.");
        } catch (Exception e) {
            fail("Exception occurred during Print button action: " + e.getMessage());
        }
    }

    /**
     * Test for the main method of DepositDetails.
     */
    @Test
    public void testMain() {
        System.out.println("Testing Main Method");

        try {
            String[] args = null;
            DepositDetails.main(args);

            // If no exception occurs, main method executed successfully
            assertTrue("Main method executed successfully.", true);

            System.out.println("Main method passed.");
        } catch (Exception e) {
            fail("Exception occurred during Main method execution: " + e.getMessage());
        }
    }
}
