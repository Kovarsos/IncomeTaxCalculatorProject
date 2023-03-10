package incometaxcalculator.data.io;

import incometaxcalculator.exceptions.WrongFileFormatException;

public class XMLFileReader extends FileReader {

  protected String checkFormat(String values[]) {
    String format = null;
    if (values[0].equals("<ReceiptID>")) {
        format = "xml";
    }
    return format;
    }

  protected String getValue(String values[]) throws WrongFileFormatException {
    String valueOfField = null;
    String value[] = new StringBuilder(values[1]).reverse().toString().trim().split(" ", 2);
      valueOfField = new StringBuilder(value[1]).reverse().toString();
    return valueOfField;
  }

}
