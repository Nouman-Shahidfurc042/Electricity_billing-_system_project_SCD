package electricitybillingsystem2;

import java.awt.Window;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;

public class SplashTest {

    private Splash splash;

    @Before
    public void setUp() {
        // Initialize Splash frame
        splash = new Splash();
    }

    @After
    public void tearDown() {
        // Clean up
        splash.setVisible(false);
        splash = null;
    }

    @Test
    public void testSplashScreenVisible() throws InterruptedException {
        // Test if the splash screen is visible after creation
        assertTrue(splash.isVisible());
        
        // Wait for a few seconds to let the animation happen
        Thread.sleep(500); // Wait for some time (less than 3 seconds)
        
        // After a short period, the splash screen should still be visible
        assertTrue(splash.isVisible());
    }

    @Test
    public void testSplashScreenDisappears() throws InterruptedException {
        // Test if the splash screen disappears after the specified time
        Thread.sleep(3500); // Wait for splash screen to hide
        
        // After sleep, splash screen should be hidden
        assertFalse(splash.isVisible());
    }


    
    @Test
public void testLoginFrameAppears() throws InterruptedException {
    // After splash screen disappears, check if Login frame appears
    Thread.sleep(3500); // Wait for splash to disappear

    // Get all open frames and check if the Login frame is visible
    boolean loginFrameFound = false;
    for (Window window : Window.getWindows()) {
        if (window instanceof Login && window.isVisible()) {
            loginFrameFound = true;
            break;
        }
    }

    // Assert that the Login frame is visible
    assertTrue("Login frame should be visible after splash screen", loginFrameFound);
}

}
