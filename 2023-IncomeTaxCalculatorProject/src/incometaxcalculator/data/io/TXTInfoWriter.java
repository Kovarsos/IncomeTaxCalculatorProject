package incometaxcalculator.data.io;
public class TXTInfoWriter extends InfoWriter {
  
  protected String fillData(int index) {
    final String Data[] = {"_INFO.txt","Name: ","AFM: ","Status: ","Income: ","Receipts:",
        "Receipt ID: ", "Date: ","Kind: ","Amount: ","Company: ","Country: ","City: ",
        "Street: ","Number: "," "," "," "," "," "," "," "," "," "," "," "}; 
    return Data[index];
  }
}