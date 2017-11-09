package test.demo;

import demo.Comparison;
import demo.EncryptionAndDecryption;
import demo.License;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
* License Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®ÔÂ 24, 2017</pre> 
* @version 1.0 
*/ 
public class LicenseTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: GetHardwareInfo() 
* 
*/ 
@Test
public void testGetHardwareInfo() throws Exception { 
//TODO: Test goes here...
    License license = new License();
    license.getHardwareInfo();
}

@Test
public void testEncrypt() throws Exception {
    EncryptionAndDecryption encryptionAndDecryption = new EncryptionAndDecryption();
    String str = encryptionAndDecryption.encrypt("192.168.88.1|Windows 10|00-50-56-C0-00-08");
    encryptionAndDecryption.decrypt(str);
}

@Test
public void testComparison() throws Exception {
    Comparison comparison = new Comparison();
    boolean flag = comparison.comparison();
    System.out.println(flag);
}

} 
