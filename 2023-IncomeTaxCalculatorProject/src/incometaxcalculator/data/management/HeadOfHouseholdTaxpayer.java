package incometaxcalculator.data.management;

public class HeadOfHouseholdTaxpayer extends Taxpayer {

  public HeadOfHouseholdTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    super.intarray[0] = 30390;
    super.intarray[1] = 90000;
    super.intarray[2] = 122110;
    super.intarray[3] = 203390;
    super.doublearray[0] = 0.0535;
    super.doublearray[1] = 1625.87;
    super.doublearray[2] = 0.0705;
    super.doublearray[3] = 5828.38;
    super.doublearray[4] = 8092.13;
    super.doublearray[5] = 0.0785;
    super.doublearray[6] = 14472.61;
    super.doublearray[7] = 0.0985;
    super.doublearray[8] = doublearray[2];
  }
  

}