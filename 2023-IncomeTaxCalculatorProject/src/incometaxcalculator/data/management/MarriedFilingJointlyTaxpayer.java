package incometaxcalculator.data.management;

public class MarriedFilingJointlyTaxpayer extends Taxpayer {

  public MarriedFilingJointlyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    
    super.intarray[0] = 36080;
    super.intarray[1] = 90000;
    super.intarray[2] = 143350;
    super.intarray[3] = 254240;
    super.doublearray[0] = 0.0535;
    super.doublearray[1] = 1930.28;
    super.doublearray[2] = 0.0705;
    super.doublearray[3] = 5731.64;
    super.doublearray[4] = 9492.82;
    super.doublearray[5] = 0.0785;
    super.doublearray[6] = 18197.69;
    super.doublearray[7] = 0.0985;
    super.doublearray[8] = doublearray[5];
  }

}