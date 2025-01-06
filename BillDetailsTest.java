

package electricitybillingsystem2;

import org.junit.*;
import javax.swing.*;
import java.awt.*;
import static org.junit.Assert.*;

public class BillDetailsTest {

    private static final String TEST_METER_NUMBER = "12345";
    private BillDetails billDetails;
    
        @Before
    public void setUp() {
        SwingUtilities.invokeLater(() -> billDetails = new BillDetails(TEST_METER_NUMBER));
        try {
            Thread.sleep(2000); // Allow time for Swing UI to initialize
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBillDetailsTable() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            assertNotNull(billDetails); // Ensure the frame is initialized

            JTable table = null;
            for (Component component : billDetails.getContentPane().getComponents()) {
                if (component instanceof JScrollPane) {
                    table = (JTable) ((JScrollPane) component).getViewport().getView();
                    break;
                }
            }

            assertNotNull(table); // Ensure the JTable is present
            assertTrue("Table should have rows", table.getRowCount() > 0); // Ensure data is populated
        });
    }

@Test
public void testCancelButtonClick() {
    SwingUtilities.invokeLater(() -> {
        try {
            JButton cancelButton = null;
            for (Component component : billDetails.getContentPane().getComponents()) {
                if (component instanceof JButton && ((JButton) component).getText().equalsIgnoreCase("Cancel")) {
                    cancelButton = (JButton) component;
                    break;
                }
            }

            assertNotNull("Cancel button should exist", cancelButton);

            if (cancelButton != null) {
                cancelButton.doClick();
                assertFalse("Window should be closed after clicking Cancel", billDetails.isVisible());
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred: " + e.getMessage());
        }
    });

    // Allow the EDT to process the task
    try {
        Thread.sleep(500); // Short delay to ensure the click event is processed
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}



    @After
    public void tearDown() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            if (billDetails != null) {
                billDetails.dispose();
            }
        });
    }
}
