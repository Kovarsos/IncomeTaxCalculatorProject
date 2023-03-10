package incometaxcalculator.data.io;

public class TXTLogWriter extends LogWriter {

  protected String fillData(int index) {
    final String Data[] = {"_LOG.txt","Name: ","AFM: ","Income: ","Basic Tax: ","Tax Increase: ",
        "Tax Decrease: ", "Total Tax: ","TotalReceiptsGathered: ","Entertainment: ","Basic: ","Travel: ","Health: ",
        "Other: "," "," "," "," "," "," "," "," "," "," "," "," "," "}; 
    return Data[index];
  }

}
