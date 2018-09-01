
package net.flood.ocrnn.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MathUtilsTest {
    
    public MathUtilsTest() {
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
     * Test of logistic method, of class MathUtils.
     */
    @Test
    public void testLogistic() {
        System.out.println("logistic");
        double x = 0.0;
        double expResult = 0.5;
        double result = MathUtils.logistic(x);
        assertEquals(expResult, result, 0.5);

    }

    /**
     * Test of dLogistic method, of class MathUtils.
     */
    @Test
    public void testDLogistic() {
        System.out.println("dLogistic");
        double x = 0.0;
        double expResult = 0.25;
        double result = MathUtils.dLogistic(x);
        assertEquals(expResult, result, 0.25);

    }

    /**
     * Test of clamp method, of class MathUtils.
     */
    @Test
    public void testClamp() {
        System.out.println("clamp");
        Object min = null;
        Object max = null;
        Object value = null;
        Object expResult = 1;
        Object result = MathUtils.clamp(-1, 1, 1);
        assertEquals(expResult, result);

    }
    
}
