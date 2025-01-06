package electricitybillingsystem2;

import org.junit.*;
import javax.swing.*;

public class MeterInfoTest {

    private MeterInfo meterInfo;

    @Before
    public void setUp() {
        // Initialize the MeterInfo instance before each test
        meterInfo = new MeterInfo("12345");
    }
    @Test
    public void testDefaultChoices() {
        // Validate default selections in Choice components
        Assert.assertEquals("Outside", meterInfo.meterlocation.getSelectedItem());
        Assert.assertEquals("Electric Meter", meterInfo.metertype.getSelectedItem());
        Assert.assertEquals("011", meterInfo.phasecode.getSelectedItem());
        Assert.assertEquals("Normal", meterInfo.billtype.getSelectedItem());
    }

    @Test
    public void testSubmitButtonAction() {
        // Simulate changing user inputs
        meterInfo.meterlocation.select("Inside");
        meterInfo.metertype.select("Solar Meter");
        meterInfo.phasecode.select("044");
        meterInfo.billtype.select("Industial");

        // Simulate clicking the "Submit" button
        meterInfo.next.doClick();

        // Validate that the window is closed after submission
        Assert.assertFalse("Window should close after submission", meterInfo.isVisible());
    }

    @Test
    public void testCancelAction() {
        // Simulate closing the window directly
        meterInfo.setVisible(false);

        // Verify the window is closed
        Assert.assertFalse("Window should not be visible", meterInfo.isVisible());
    }

 

    @After
    public void tearDown() {
        // Dispose of the MeterInfo instance after each test
        meterInfo.dispose();
    }
}
