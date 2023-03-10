package incometaxcalculator.data.io;
public class XMLInfoWriter extends InfoWriter {
  
  protected String fillData(int index) {
    final String Data[] = {"_INFO.xml","<Name> ","<AFM> ","<Status> ","<Income> ","<Receipts>",
        "<ReceiptID> ", "<Date> ","<Kind> ","<Amount> ","<Company> ","<Country> ","<City> ",
        "<Street> ","<Number: >"," </Name>"," </Status>"," </Income>"," </ReceiptID>"," </Date>"," </Kind>"," </Amount>"," </Company>"," </Country>"," </City>"," </Street>", "</Number: >"}; 
    return Data[index];
  }
}