
package net.flood.ocrnn.util;

import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ImageUtilsTest {
    
    public ImageUtilsTest() {
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
     * Test of deepCopy method, of class ImageUtils.
     */
    @Test
    public void testDeepCopy() {
        System.out.println("deepCopy");
        BufferedImage image = null;
        BufferedImage expResult = null;
        BufferedImage result = ImageUtils.deepCopy(image);
        assertEquals(expResult, result);

    }


    @Test
    public void testFitInto() {
        System.out.println("fitInto");
        BufferedImage source = null;
        int width = 0;
        int height = 0;
        int backgroundColor = 0;
        BufferedImage expResult = null;
        BufferedImage result = ImageUtils.fitInto(source, width, height, backgroundColor);
        assertEquals(expResult, result);

        fail("The test case is a prototype.");
    }

    /**
     * Test of invertColor method, of class ImageUtils.
     */
    @Test
    public void testInvertColor() {
        System.out.println("invertColor");
        BufferedImage source = null;
        BufferedImage expResult = null;
        BufferedImage result = ImageUtils.invertColor(source);
        assertEquals(expResult, result);

        fail("The test case is a prototype.");
    }

    /**
     * Test of centerWithMassInto method, of class ImageUtils.
     */
    @Test
    public void testCenterWithMassInto() {
        System.out.println("centerWithMassInto");
        BufferedImage source = null;
        int width = 0;
        int height = 0;
        int backgroundColor = 0;
        BufferedImage expResult = null;
        BufferedImage result = ImageUtils.centerWithMassInto(source, width, height, backgroundColor);
        assertEquals(expResult, result);

    }

    /**
     * Test of cropWhiteBorder method, of class ImageUtils.
     */
    @Test
    public void testCropWhiteBorder() {
        System.out.println("cropWhiteBorder");
        BufferedImage source = null;
        BufferedImage expResult = null;
        BufferedImage result = ImageUtils.cropWhiteBorder(source);
        assertEquals(expResult, result);

        fail("The test case is a prototype.");
    }

    /**
     * Test of computeCenterOfMass method, of class ImageUtils.
     */
    @Test
    public void testComputeCenterOfMass() {
        System.out.println("computeCenterOfMass");
        BufferedImage img = null;
        int[] expResult = null;
        int[] result = ImageUtils.computeCenterOfMass(img);
        assertArrayEquals(expResult, result);

        fail("The test case is a prototype.");
    }

    /**
     * Test of fromPixelMatrix method, of class ImageUtils.
     */
    @Test
    public void testFromPixelMatrix() {
        System.out.println("fromPixelMatrix");
        int[][] pixels = null;
        BufferedImage expResult = null;
        BufferedImage result = ImageUtils.fromPixelMatrix(pixels);
        assertEquals(expResult, result);
 
        fail("The test case is a prototype.");
    }

    /**
     * Test of toPixelMatrix method, of class ImageUtils.
     */
    @Test
    public void testToPixelMatrix() {
        System.out.println("toPixelMatrix");
        BufferedImage img = null;
        int[][] expResult = null;
        int[][] result = ImageUtils.toPixelMatrix(img);
        assertArrayEquals(expResult, result);

        fail("The test case is a prototype.");
    }
    
}
