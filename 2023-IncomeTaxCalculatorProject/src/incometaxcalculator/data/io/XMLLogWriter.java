package incometaxcalculator.data.io;

public class XMLLogWriter extends LogWriter {
  
  protected String fillData(int index) {
    final String Data[] = {"_LOG.xml","<Name> ","<AFM> ","<Income> ","<BasicTax> ","<TaxIncrease> ",
        "<TaxDecrease> ", "<TotalTax> ","<Receipts> ","<Entertainment> ","<Basic> ","<Travel> ","<Health> ",
        "<Other> "," </Name>"," </AFM>"," </Income>"," </BasicTax>"," </TaxIncrease>"," </TaxDecrease>"," </TotalTax>"," </Receipts>",
        " </Entertainment>"," </Basic>"," </Travel>"," </Health>"," </Other>"}; 
    return Data[index];
  }
}
