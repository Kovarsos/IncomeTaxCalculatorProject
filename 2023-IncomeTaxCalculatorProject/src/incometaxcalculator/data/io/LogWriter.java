package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;

import incometaxcalculator.data.management.TaxpayerManager;

public abstract class LogWriter implements FileWriter {
  TaxpayerManager manager = new TaxpayerManager();
  private static final short ENTERTAINMENT = 0;
  private static final short BASIC = 1;
  private static final short TRAVEL = 2;
  private static final short HEALTH = 3;
  private static final short OTHER = 4;
  
  protected abstract String fillData(int index);

  public void generateFile(int taxRegistrationNumber) throws IOException {
    PrintWriter outputStream = new PrintWriter(
        new java.io.FileWriter(taxRegistrationNumber + fillData(0)));
    outputStream.println(fillData(1) + manager.getTaxpayerName(taxRegistrationNumber) + fillData(14));
    outputStream.println(fillData(2) + taxRegistrationNumber + fillData(15));
    outputStream.println(fillData(3) + manager.getTaxpayerIncome(taxRegistrationNumber) + fillData(16));
    outputStream.println(fillData(4) + manager.getTaxpayerBasicTax(taxRegistrationNumber) + fillData(17));
    if (manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) > 0) {
      outputStream.println(fillData(5) + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + fillData(18));
    } else {
      outputStream.println(fillData(6) + manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) + fillData(19));
    }
    outputStream.println(fillData(7) + manager.getTaxpayerTotalTax(taxRegistrationNumber) + fillData(20));
    outputStream.println(fillData(8) + manager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber) + fillData(21));
    outputStream.println(fillData(9) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT)+ fillData(22));
    outputStream.println(fillData(10) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC) + fillData(23));
    outputStream.println(fillData(11) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL) + fillData(24));
    outputStream.println(fillData(12) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH) + fillData(25));
    outputStream.println(fillData(13) + manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER) + fillData(26));
    outputStream.close();
  }

}
