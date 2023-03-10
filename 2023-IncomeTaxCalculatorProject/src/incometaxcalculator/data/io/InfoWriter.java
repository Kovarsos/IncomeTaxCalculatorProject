package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;

public abstract class InfoWriter implements FileWriter {
  TaxpayerManager manager = new TaxpayerManager();
  
  protected abstract String fillData(int index);
  
  public void generateFile(int taxRegistrationNumber) throws IOException{
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + fillData(0)));
    outputStream.println(fillData(1) + manager.getTaxpayerName(taxRegistrationNumber) + fillData(15));
    outputStream.println(fillData(2) + taxRegistrationNumber + " </AFM>");
    outputStream.println(fillData(3) + manager.getTaxpayerStatus(taxRegistrationNumber) + fillData(16));
    outputStream.println(fillData(4) + manager.getTaxpayerIncome(taxRegistrationNumber) + fillData(17));
    outputStream.println();// den mas emfanize to \n se aplo notepad
    outputStream.println(fillData(5));
    outputStream.println();
    generateTaxpayerReceipts(taxRegistrationNumber, outputStream);
    outputStream.close();
  }


private void generateTaxpayerReceipts(int taxRegistrationNumber, PrintWriter outputStream) {
  
  HashMap<Integer, Receipt> receiptsHashMap = manager.getReceiptHashMap(taxRegistrationNumber);
  Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
  while (iterator.hasNext()) {
    HashMap.Entry<Integer, Receipt> entry = iterator.next();
    Receipt receipt = entry.getValue();
    outputStream.println(fillData(6) + receipt.getId() + fillData(18));
    outputStream.println(fillData(7) + receipt.getIssueDate() + fillData(19));
    outputStream.println(fillData(8) + receipt.getKind() + fillData(20));
    outputStream.println(fillData(9) + receipt.getAmount() + fillData(21));
    outputStream.println(fillData(10) + receipt.getCompany() + fillData(22));
    outputStream.println(fillData(11) + receipt.getCompany().getCountry() + fillData(23));
    outputStream.println(fillData(12) + receipt.getCompany().getCity() + fillData(24));
    outputStream.println(fillData(13) + receipt.getCompany().getStreet() + fillData(25));
    outputStream.println(fillData(14) + receipt.getCompany().getNumber() + fillData(26));
    outputStream.println();
    }
  }
}