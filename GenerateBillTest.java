
 
package electricitybillingsystem2;

import java.awt.event.ActionEvent;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenerateBillTest {

    GenerateBill instance;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setup for all tests in GenerateBillTest");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Cleanup after all tests in GenerateBillTest");
    }

    @Before
    public void setUp() {
        instance = new GenerateBill("12345"); // Mock meter number
        System.out.println("Setup before each test");
    }

    @After
    public void tearDown() {
        instance.dispose(); // Dispose of the instance after each test
        System.out.println("Cleanup after each test");
    }

    /**
     * Test the actionPerformed method for valid input.
     */
    @Test
    public void testActionPerformedWithValidInput() {
        System.out.println("Running testActionPerformedWithValidInput");

        // Mock user action: Select month and simulate button click
        instance.cmonth.select("January");
        ActionEvent ae = new ActionEvent(instance.bill, ActionEvent.ACTION_PERFORMED, "Generate Bill");

        // Execute actionPerformed
        instance.actionPerformed(ae);

    }

    /**
     * Test the actionPerformed method with missing or invalid meter number.
     */
    @Test
    public void testActionPerformedWithInvalidMeterNumber() {
        System.out.println("Running testActionPerformedWithInvalidMeterNumber");

        // Mock an invalid meter number
        GenerateBill invalidInstance = new GenerateBill("");
        invalidInstance.cmonth.select("February");
        ActionEvent ae = new ActionEvent(invalidInstance.bill, ActionEvent.ACTION_PERFORMED, "Generate Bill");

        // Execute actionPerformed
        invalidInstance.actionPerformed(ae);

        // Verify that the JTextArea contains an error message or does not contain valid bill details
        String areaText = invalidInstance.area.getText();
        assertFalse("JTextArea should not contain the meter number", areaText.contains("12345"));
        assertFalse("JTextArea should not show total payable amount", areaText.contains("Total Payable"));
    }

    /**
     * Test the main method to ensure no exceptions are thrown.
     */
    @Test
    public void testMain() {
        System.out.println("Running testMain");

        // Execute the main method
        try {
            String[] args = null;
            GenerateBill.main(args);
        } catch (Exception e) {
            fail("Main method should not throw exceptions");
        }
    }
}
