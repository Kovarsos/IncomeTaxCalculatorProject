package incometaxcalculator.data.management;

import java.io.File;
import java.io.IOException;

import incometaxcalculator.data.io.FileWriter;
import incometaxcalculator.data.io.TXTInfoWriter;
import incometaxcalculator.data.io.TXTLogWriter;
import incometaxcalculator.data.io.XMLInfoWriter;
import incometaxcalculator.data.io.XMLLogWriter;
import incometaxcalculator.exceptions.WrongFileFormatException;

public class FileWriterFactory {
  public FileWriter createFileWriter (int taxRegistrationNumber) throws IOException{
    if (new File(taxRegistrationNumber + "_INFO.xml").exists()) {
      XMLInfoWriter writer = new XMLInfoWriter();
      return writer;
    } else if (new File(taxRegistrationNumber + "_INFO.txt").exists()) {
      TXTInfoWriter writer = new TXTInfoWriter();
      return writer;
    } else
      throw new IOException();
  }
  
  public FileWriter createFileWriter (int taxRegistrationNumber, String fileFormat) throws IOException,WrongFileFormatException{
    if (fileFormat.equals("xml")) {
      XMLLogWriter writer = new XMLLogWriter();
      return writer;
    } else if (fileFormat.equals("txt")) {
      TXTLogWriter writer = new TXTLogWriter();
      return writer;
    } else
      throw new WrongFileFormatException();
  }

}
