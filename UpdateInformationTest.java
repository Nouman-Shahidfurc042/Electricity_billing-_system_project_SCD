package electricitybillingsystem2;

import org.junit.*;
import javax.swing.*;
import java.sql.*;

public class UpdateInformationTest {

    private UpdateInformation updateInfo;
    private static String testMeterNumber = "12345"; // Example meter number for testing

    @BeforeClass
    public static void setUpDatabase() {
        // Prepare the database for tests
        try {
            Conn c = new Conn();
            c.s.executeUpdate("INSERT INTO customer (meter_no, name, address, city, state, email, phone) " +
                    "VALUES ('12345', 'John Doe', '123 Elm St', 'Gotham', 'NY', 'john.doe@example.com', '1234567890')");
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Failed to set up test database.");
        }
    }

    @Before
    public void setUp() {
        // Initialize the UpdateInformation instance with test meter number
        SwingUtilities.invokeLater(() -> updateInfo = new UpdateInformation(testMeterNumber));
        try {
            Thread.sleep(1000); // Allow time for the Swing UI to initialize
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadCustomerInformation() {
        SwingUtilities.invokeLater(() -> {
            // Verify that customer information is loaded correctly
            Assert.assertEquals("John Doe", updateInfo.name.getText());
            Assert.assertEquals("123 Elm St", updateInfo.tfaddress.getText());
            Assert.assertEquals("Gotham", updateInfo.tfcity.getText());
            Assert.assertEquals("NY", updateInfo.tfstate.getText());
            Assert.assertEquals("john.doe@example.com", updateInfo.tfemail.getText());
            Assert.assertEquals("1234567890", updateInfo.tfphone.getText());
        });
    }

    @Test
    public void testUpdateCustomerInformation() {
        SwingUtilities.invokeLater(() -> {
            // Simulate updating customer information
            updateInfo.tfaddress.setText("456 Oak St");
            updateInfo.tfcity.setText("Metropolis");
            updateInfo.tfstate.setText("CA");
            updateInfo.tfemail.setText("jane.doe@example.com");
            updateInfo.tfphone.setText("9876543210");

            // Trigger the "Update" button
            updateInfo.update.doClick();
        });

        try {
            Thread.sleep(1000); // Allow time for the database operation to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify the updated values in the database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer WHERE meter_no = '" + testMeterNumber + "'");
            if (rs.next()) {
                Assert.assertEquals("456 Oak St", rs.getString("address"));
                Assert.assertEquals("Metropolis", rs.getString("city"));
                Assert.assertEquals("CA", rs.getString("state"));
                Assert.assertEquals("jane.doe@example.com", rs.getString("email"));
                Assert.assertEquals("9876543210", rs.getString("phone"));
            } else {
                Assert.fail("Customer record not found after update.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Assert.fail("Database query failed.");
        }
    }

    @Test
    public void testCancelAction() {
        SwingUtilities.invokeLater(() -> {
            // Simulate clicking the "Cancel" button
            updateInfo.cancel.doClick();

            // Verify that the window is closed
            Assert.assertFalse("Window should close when Cancel is clicked", updateInfo.isVisible());
        });
    }

    @After
    public void tearDown() {
        SwingUtilities.invokeLater(() -> updateInfo.dispose());
    }

    @AfterClass
    public static void cleanUpDatabase() {
        // Clean up the test data in the database
        try {
            Conn c = new Conn();
            c.s.executeUpdate("DELETE FROM customer WHERE meter_no = '12345'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
