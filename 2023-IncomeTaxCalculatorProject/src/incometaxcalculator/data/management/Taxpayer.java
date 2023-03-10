package incometaxcalculator.data.management;

import java.util.Arrays;
import java.util.HashMap;

import incometaxcalculator.exceptions.WrongReceiptKindException;

public class Taxpayer {

  protected final String fullname;
  protected final int taxRegistrationNumber;
  protected final float income;
  protected int intarray[] = new int[10];
  protected double doublearray[] = new double[10];
  protected final String receiptKinds[] = {"Entertainment","Basic","Travel","Health","Other"};

  private float amountPerReceiptsKind[] = new float[5];
  private int totalReceiptsGathered = 0;
  private HashMap<Integer, Receipt> receiptHashMap = new HashMap<Integer, Receipt>(0);

  public double calculateBasicTax() {
    if (income < intarray[0]) {
      return doublearray[0] * income;
    } else if (income < intarray[1]) {
      return doublearray[1] + doublearray[2] * (income - intarray[0]);
    } else if (income < intarray[2]) {
      return doublearray[3] + doublearray[8] * (income - intarray[1]);
    } else if (income < intarray[3]) {
      return doublearray[4] + doublearray[5] * (income - intarray[2]);
    } else {
      return doublearray[6] + doublearray[7] * (income - intarray[4]);
    }
  
  }

  protected Taxpayer(String fullname, int taxRegistrationNumber, float income) {
    this.fullname = fullname;
    this.taxRegistrationNumber = taxRegistrationNumber;
    this.income = income;
  }

  public void addReceipt(Receipt receipt) throws WrongReceiptKindException
  {
     if(Arrays.asList(receiptKinds).contains(receipt.getKind()))
     {
       for (int i =0; i < receiptKinds.length;i++)
       {
         if(receiptKinds[i].equals(receipt.getKind()))
         {
           amountPerReceiptsKind[i] += receipt.getAmount();
           break;
         }
       }
       
       receiptHashMap.put(receipt.getId(), receipt);
       totalReceiptsGathered ++;
     }
     
     else {
       throw new WrongReceiptKindException();
     }
  }
  
  
  public void removeReceipt(int receiptId) throws WrongReceiptKindException {
    Receipt receipt = receiptHashMap.get(receiptId);
    if (Arrays.asList(receiptKinds).contains(receipt.getKind())) {

      for (int i =0; i < receiptKinds.length;i++)
      {
        if(receiptKinds[i].equals(receipt.getKind()))
        {
          amountPerReceiptsKind[i] -= receipt.getAmount();
          break;
        }
      }
      
      totalReceiptsGathered--;
      receiptHashMap.remove(receiptId);      
    } else {
      throw new WrongReceiptKindException();}
    
    }

  public String getFullname() {
    return fullname;
  }

  public int getTaxRegistrationNumber() {
    return taxRegistrationNumber;
  }

  public float getIncome() {
    return income;
  }

  public HashMap<Integer, Receipt> getReceiptHashMap() {
    return receiptHashMap;
  }

  public double getVariationTaxOnReceipts() {
    float totalAmountOfReceipts = getReceiptsAmount();
    if (totalAmountOfReceipts < 0.2 * income) {
      return calculateBasicTax() * 0.08;
    } else if (totalAmountOfReceipts < 0.4 * income) {
      return calculateBasicTax() * 0.04;
    } else if (totalAmountOfReceipts < 0.6 * income) {
      return -calculateBasicTax() * 0.15;
    } else {
      return -calculateBasicTax() * 0.3;
    }
  }

  private float getReceiptsAmount() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += amountPerReceiptsKind[i];
    }
    return sum;
  }

  public int getTotalReceiptsGathered() {
    return totalReceiptsGathered;
  }

  public float getAmountOfReceiptKind(short kind) {
    return amountPerReceiptsKind[kind];
  }

  public double getTotalTax() {
    return calculateBasicTax() + getVariationTaxOnReceipts();
  }

  public double getBasicTax() {
    return calculateBasicTax();
  }

}