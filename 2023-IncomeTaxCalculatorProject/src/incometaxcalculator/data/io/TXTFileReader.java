package incometaxcalculator.data.io;

import incometaxcalculator.exceptions.WrongFileFormatException;

public class TXTFileReader extends FileReader {

  protected String checkFormat(String values[]) {
    String format = null;
    if (values[0].equals("Receipt")) {
      if (values[1].equals("ID:")) {
        format = "txt";
      }
    }
    return format;
    }
  
  protected String getValue(String values[]) throws WrongFileFormatException {
    String valueOfField = null;
      values[1] = values[1].trim();
      valueOfField = values[1];
      return valueOfField;
  }

}