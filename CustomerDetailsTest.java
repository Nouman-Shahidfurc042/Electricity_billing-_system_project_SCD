/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
//package electricitybillingsystem2;
//
//import java.awt.event.ActionEvent;
//import javax.swing.JButton;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class CustomerDetailsTest {
//    
//    /**
//     * Test of actionPerformed method, of class CustomerDetails.
//     */
//    @Test
//    public void testActionPerformed() {
//        System.out.println("Testing actionPerformed");
//
//        // Create an instance of CustomerDetails
//        CustomerDetails instance = new CustomerDetails();
//        
//        // Simulate a button click event for the Print button
//        ActionEvent ae = new ActionEvent(instance.print, ActionEvent.ACTION_PERFORMED, "Print");
//        
//        try {
//            instance.actionPerformed(ae);
//        } catch (Exception e) {
//            fail("Exception occurred during actionPerformed: " + e.getMessage());
//        }
//
//        // If no exception, test passed for actionPerformed
//        assertTrue("ActionPerformed executed successfully.", true);
//    }
//
//    /**
//     * Test of main method, of class CustomerDetails.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("Testing main");
//        
//        try {
//            String[] args = null;
//            CustomerDetails.main(args);
//        } catch (Exception e) {
//            fail("Exception occurred during main method execution: " + e.getMessage());
//        }
//
//        // If no exception, test passed for main
//        assertTrue("Main executed successfully.", true);
//    }
//}


package electricitybillingsystem2;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerDetailsTest {
    
    /**
     * Test to ensure the GUI components are initialized correctly.
     */
    @Test
    public void testGUIInitialization() {
        System.out.println("Testing GUI Initialization");
        
        // Create an instance of CustomerDetails
        CustomerDetails instance = new CustomerDetails();
        
        // Check if the table is initialized
        assertNotNull("Table should be initialized", instance.table);
        
        // Check if the Print button is initialized
        assertNotNull("Print button should be initialized", instance.print);
        
        // Check if JScrollPane is added
        boolean scrollPaneFound = false;
        for (Component comp : instance.getContentPane().getComponents()) {
            if (comp instanceof JScrollPane) {
                scrollPaneFound = true;
                break;
            }
        }
        assertTrue("ScrollPane should be added to the GUI", scrollPaneFound);
    }

    /**
     * Test the actionPerformed method for Print button.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("Testing actionPerformed");

        // Create an instance of CustomerDetails
        CustomerDetails instance = new CustomerDetails();
        
        // Simulate a button click event for the Print button
        ActionEvent ae = new ActionEvent(instance.print, ActionEvent.ACTION_PERFORMED, "Print");
        
        try {
            instance.actionPerformed(ae);
        } catch (Exception e) {
            fail("Exception occurred during actionPerformed: " + e.getMessage());
        }

        // If no exception, test passed for actionPerformed
        assertTrue("ActionPerformed executed successfully.", true);
    }

    /**
     * Test the database connection and table population.
     */
    @Test
    public void testDatabaseConnectionAndTablePopulation() {
        System.out.println("Testing Database Connection and Table Population");
        
        // Create an instance of CustomerDetails
        CustomerDetails instance = new CustomerDetails();
        
        // Check if table is populated
        JTable table = instance.table;
        assertTrue("Table should have rows populated", table.getRowCount() > 0);
    }

    /**
     * Test the main method to ensure the application launches successfully.
     */
    @Test
    public void testMain() {
        System.out.println("Testing main");
        
        try {
            String[] args = null;
            CustomerDetails.main(args);
        } catch (Exception e) {
            fail("Exception occurred during main method execution: " + e.getMessage());
        }

        // If no exception, test passed for main
        assertTrue("Main executed successfully.", true);
    }

    /**
     * Test if the Print button is functioning properly.
     */
    @Test
    public void testPrintButtonFunctionality() {
        System.out.println("Testing Print Button Functionality");

        // Create an instance of CustomerDetails
        CustomerDetails instance = new CustomerDetails();

        // Simulate a button click
        try {
            instance.print.doClick();
        } catch (Exception e) {
            fail("Exception occurred during Print button click: " + e.getMessage());
        }

        // If no exception, test passed for Print button functionality
        assertTrue("Print button executed successfully.", true);
    }
}
