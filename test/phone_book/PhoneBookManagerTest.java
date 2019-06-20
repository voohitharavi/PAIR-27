/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone_book;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PhoneBookManagerTest {
    
    
    
    String user = "unknown";
    String number = "123456";
    String university = "uni";
    String company = "theco";
    String year="1984";
    
    public PhoneBookManagerTest() {
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
     * Test of createManagerInst method, of class PhoneBookManager.
     */
    @Test
    public void testCreateManagerInst() {
        
        PhoneBookManager result = PhoneBookManager.createManagerInst();
        assertEquals(PhoneBookManager.class.isInstance(result), true);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addPhoneInfo method, of class PhoneBookManager.
     */
    
    /*
    add phone information with name and number
    */
    @Test
    public void testAddPhoneInfo() {
        System.out.println("addPhoneInfo");
        String name = "NAME1";    // enter name as NAME1
        String phone = "75757542";  // enter telephone number
        PhoneBookManager manager = PhoneBookManager.createManagerInst();// create instance for java class PhoneBookManager
        boolean expResult = true; // true value represents when contact information is saved successfully
        boolean result = manager.addPhoneInfo(name, phone); // add contact information
        assertEquals(expResult, result); //check contact information is saved into the list
        System.out.println("Contact information has been added successfully");
    }
    
    /*
    add phone information with empty name
    */
    @Test
    public void testAddPhoneInfoJustNameAndNumberWithEmptyName() {
        System.out.println("addPhoneInfo with empty name");
        String name = ""; // enter empty name
        String phone = "7896666"; // enter telphone number
        PhoneBookManager manager = PhoneBookManager.createManagerInst();// create instance for java class PhoneBookManager
        boolean expResult = false; // expected value is false as contact cannot be saved with empty name
        boolean result = manager.addPhoneInfo(name, phone); // add contact infomation
        assertEquals(expResult, result);// check contact infomartion is saved or not
        System.out.println("Contact information cannot be saved with empty name");
    }
    
    @Test
    /*
    add phone information with empty number
    */
    public void testAddPhoneInfoJustNameAndNumberWithEmptyNumber() {
        System.out.println("addPhoneInfo with empty number");
        String name = "Name2"; // enter name as NAME2
        String phone = ""; // enter empty telephone number
        PhoneBookManager manager = PhoneBookManager.createManagerInst(); // create instance for java class PhoneBookManager
        boolean expResult = false; //expected value is false as contact cannot be saved with empty number
        boolean result = manager.addPhoneInfo(name, phone); // add contact information
        assertEquals(expResult, result); // check contact information is saved into the list
        System.out.println("Contact information cannot be saved with empty number");
    }    
    
    
    
}
