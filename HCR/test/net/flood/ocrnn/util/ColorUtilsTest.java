
package net.flood.ocrnn.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ColorUtilsTest {
    
    public ColorUtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getColor method, of class ColorUtils.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        int startColor = 0;
        int endColor = 0;
        float percentage = 0.0F;
        int expResult = -16777216;
        int result = ColorUtils.getColor(startColor, endColor, percentage);
        assertEquals(expResult, result);

    }
    
}
