
package net.flood.ocrnn.util;

import java.awt.Component;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileUtilsTest {
    
    public FileUtilsTest() {
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


    @Test
    public void testGetFileExtension() {
        System.out.println("getFileExtension");
        File file = null;
        String expResult = "";
        String result = FileUtils.getFileExtension(file);
        assertEquals(expResult, result);

        fail("The test case is a prototype.");
    }


    @Test
    public void testGetFileWithOtherExtension() {
        System.out.println("getFileWithOtherExtension");
        File file = null;
        String extension = "";
        File expResult = null;
        File result = FileUtils.getFileWithOtherExtension(file, extension);
        assertEquals(expResult, result);

        fail("The test case is a prototype.");
    }


    @Test
    public void testChooseFile() {
        System.out.println("chooseFile");
        Component parent = null;
        String description = "";
        String[] extensions = null;
        File expResult = null;
        File result = FileUtils.chooseFile(parent, description, extensions);
        assertEquals(expResult, result);

        fail("The test case is a prototype.");
    }
    
}
