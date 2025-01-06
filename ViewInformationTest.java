package electricitybillingsystem2;

import java.awt.Component;
import org.junit.*;
import javax.swing.*;
import java.sql.*;

import static org.junit.Assert.*;

public class ViewInformationTest {

    private static final String TEST_METER_NUMBER = "12345";
    private ViewInformation viewInfo;

    @BeforeClass
    public static void setUpDatabase() {
        // Prepare the test data in the database
        try {
            Conn c = new Conn();
            c.s.executeUpdate("INSERT INTO customer (meter_no, name, address, city, state, email, phone) VALUES " +
                    "('12345', 'John Doe', '123 Elm St', 'New York', 'NY', 'johndoe@example.com', '5551234567')");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Database setup failed: " + e.getMessage());
        }
    }

    @Before
    public void setUp() {
        SwingUtilities.invokeLater(() -> viewInfo = new ViewInformation(TEST_METER_NUMBER));
        try {
            Thread.sleep(2000); // Allow time for Swing UI to initialize
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCustomerInformationDisplayedCorrectly() {
        // Validate customer data displayed in ViewInformation
        SwingUtilities.invokeLater(() -> {
            assertNotNull(viewInfo); // Ensure the frame is initialized

            JLabel nameLabel = getLabelByBounds(viewInfo, 250, 80);
            JLabel addressLabel = getLabelByBounds(viewInfo, 250, 200);
            JLabel cityLabel = getLabelByBounds(viewInfo, 250, 260);
            JLabel stateLabel = getLabelByBounds(viewInfo, 650, 80);
            JLabel emailLabel = getLabelByBounds(viewInfo, 650, 140);
            JLabel phoneLabel = getLabelByBounds(viewInfo, 650, 200);
            JLabel meterLabel = getLabelByBounds(viewInfo, 250, 140);

            assertEquals("John Doe", nameLabel.getText());
            assertEquals("123 Elm St", addressLabel.getText());
            assertEquals("New York", cityLabel.getText());
            assertEquals("NY", stateLabel.getText());
            assertEquals("johndoe@example.com", emailLabel.getText());
            assertEquals("5551234567", phoneLabel.getText());
            assertEquals(TEST_METER_NUMBER, meterLabel.getText());
        });
    }

    @Test
    public void testCancelButtonClosesWindow() {
        // Test that the cancel button closes the frame
        SwingUtilities.invokeLater(() -> {
            JButton cancelButton = viewInfo.cancel;
            cancelButton.doClick();
            assertFalse("Window should be closed after clicking Cancel", viewInfo.isVisible());
        });
    }

    @After
    public void tearDown() {
        if (viewInfo != null) {
            SwingUtilities.invokeLater(() -> viewInfo.dispose());
        }
    }

    @AfterClass
    public static void cleanUpDatabase() {
        // Remove the test data from the database
        try {
            Conn c = new Conn();
            c.s.executeUpdate("DELETE FROM customer WHERE meter_no = '" + TEST_METER_NUMBER + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private JLabel getLabelByBounds(JFrame frame, int x, int y) {
        // Find a JLabel component in the frame by its bounds
        for (Component component : frame.getContentPane().getComponents()) {
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                if (label.getBounds().x == x && label.getBounds().y == y) {
                    return label;
                }
            }
        }
        throw new AssertionError("Label not found at coordinates: (" + x + ", " + y + ")");
    }
}
