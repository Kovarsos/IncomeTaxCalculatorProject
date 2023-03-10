package incometaxcalculator.data.management;

import java.io.File;


import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import incometaxcalculator.data.io.FileReader;
import incometaxcalculator.data.io.TXTFileReader;
import incometaxcalculator.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.exceptions.WrongFileEndingException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;


class TaxpayerManagerTest {
  private static HashMap<Integer, Taxpayer> taxpayerHashMap = new HashMap<Integer, Taxpayer>(0);
  private static HashMap<Integer, Integer> receiptOwnerTRN = new HashMap<Integer, Integer>(0);
  TaxpayerManager taxpayer = new TaxpayerManager();
  FileReader reader = new TXTFileReader();
  
  
  
  @Test
  void removeTaxpayerHappyDay() throws Exception {
    String name = "Apostolos Zarras";
    int num = 123456789;
    float income = (float) 22570.0;

    taxpayer.createTaxpayer(name,num,"Married Filing Jointly",income);
 
    taxpayer.removeTaxpayer(123456789);
    assertTrue(!taxpayerHashMap.containsKey(123456789));
  }


  @Test
  void loadTaxpayerHappyDay() throws Exception {
    //String file = "123456789_INFO.txt";

       
    
    //taxpayer.createTaxpayer(file.fullname,num,"Married Filing Jointly",income);
    
    //assert(taxpayerHashMap.containsKey(123456789));
  }

  @Test
  void addReceiptHappyDay() throws Exception {
    int receiptId = 7;
    String issueDate = "01/01/2022";
    float amount = (float)10.0;
    String kind = "Basic";
    String companyName = "Coca Cola";
    String country = "Greece";
    String city = "Ioannina";
    String street = "Kiprou";
    int number = 10;
    int taxRegistrationNumber = 123456789;

    taxpayer.loadTaxpayer("123456789_INFO.txt");
    taxpayer.createReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);

    assertEquals(taxpayer.containsReceipt(7),true);
  }
  
  @Test
  void removeReceiptHappyDay() throws Exception {
    int receiptId = 7;
    String issueDate = "01/01/2022";
    float amount = (float)10.0;
    String kind = "Basic";
    String companyName = "Coca Cola";
    String country = "Greece";
    String city = "Ioannina";
    String street = "Kiprou";
    int number = 10;
    int taxRegistrationNumber = 123456789;

    taxpayer.loadTaxpayer("123456789_INFO.txt");
    taxpayer.createReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
    taxpayer.removeReceipt(7);

    assertTrue(!receiptOwnerTRN.containsKey(7));
  }
  
  @Test
  void saveLogFileHappyDayTXT() throws Exception {
    String fileFormat = "txt";
    int taxRegistrationNumber = 123456789;
    

    taxpayer.loadTaxpayer(taxRegistrationNumber + "_INFO.txt");
    taxpayer.saveLogFile(taxRegistrationNumber, fileFormat);
   
    File log = new File("123456789_LOG.txt");
    
    assertTrue(log.exists());
  }
  
  @Test
  void saveLogFileHappyDayXML() throws Exception {
    String fileFormat = "xml";
    int taxRegistrationNumber = 123456789;
    

    taxpayer.loadTaxpayer(taxRegistrationNumber + "_INFO.xml");
    taxpayer.saveLogFile(taxRegistrationNumber, fileFormat);
   
    File log = new File("123456789_LOG.xml");
    
    assertTrue(log.exists());
  }
  
  @Test
  void addReceiptWrongDateInput() throws Exception {
    int receiptId = 7;
    String issueDate = "01/2022";
    float amount = (float)10.0;
    String kind = "Basic";
    String companyName = "Coca Cola";
    String country = "Greece";
    String city = "Ioannina";
    String street = "Kiprou";
    int number = 10;
    int taxRegistrationNumber = 123456789;

    taxpayer.loadTaxpayer("123456789_INFO.txt");
    Throwable exception = assertThrows(WrongReceiptDateException.class, () -> taxpayer.createReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber));

    assertEquals("Please make sure your date is DD/MM/YYYY and try again.", exception.getMessage());
  }
  
  @Test
  void loadTaxpayerWrongFileEndingException() throws Exception {
    int taxRegistrationNumber = 123456789;

    Throwable exception = assertThrows(WrongFileEndingException.class, () -> taxpayer.loadTaxpayer(taxRegistrationNumber + "_INFO.jpeg"));

    assertEquals("Please check your file ending and try again!", exception.getMessage());
  }
  
  @Test
  void loadTaxpayerWrongFileFormatException() throws Exception {
    
    String file = "123456788_INFO.txt";
    Throwable exception = assertThrows(WrongFileFormatException.class, () -> taxpayer.loadTaxpayer(file));

    assertEquals("Please check your file format and try again!", exception.getMessage());
  }
  
  @Test
  void loadTaxpayerWrongTaxpayerStatusException() throws Exception {
    String name = "Apostolos Zarras";
    int num = 123456789;
    float income = (float) 22570.0;
    
    Throwable exception = assertThrows(WrongTaxpayerStatusException.class, () -> taxpayer.createTaxpayer(name,num,"Superman",income));
    assertEquals("Please check taxpayer's status and try again!", exception.getMessage());
  }
  
  @Test
  void addReceiptWrongKind() throws Exception {
    int receiptId = 7;
    String issueDate = "01/01/2022";
    float amount = (float)10.0;
    String kind = "Gaming";
    String companyName = "Coca Cola";
    String country = "Greece";
    String city = "Ioannina";
    String street = "Kiprou";
    int number = 10;
    int taxRegistrationNumber = 123456789;

    taxpayer.loadTaxpayer("123456789_INFO.txt");

    Throwable exception = assertThrows(WrongReceiptKindException.class, () -> taxpayer.createReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber));
    assertEquals("Please check receipts kind and try again.", exception.getMessage());
  }
  
  @Test
  void addReceiptAlreadyExists() throws Exception {
    int receiptId = 7;
    String issueDate = "01/01/2022";
    float amount = (float)10.0;
    String kind = "Basic";
    String companyName = "Coca Cola";
    String country = "Greece";
    String city = "Ioannina";
    String street = "Kiprou";
    int number = 10;
    int taxRegistrationNumber = 123456789;

    taxpayer.loadTaxpayer("123456789_INFO.txt");
    taxpayer.addReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber);
    Throwable exception = assertThrows(ReceiptAlreadyExistsException.class, () -> taxpayer.addReceipt(receiptId, issueDate, amount, kind, companyName, country, city, street, number, taxRegistrationNumber));
    assertEquals("Receipt already exists.", exception.getMessage());
  }
}

