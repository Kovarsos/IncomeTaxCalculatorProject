package incometaxcalculator.data.management;

public class MarriedFilingSeparatelyTaxpayer extends Taxpayer {

  public MarriedFilingSeparatelyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    super.intarray[0] = 18040;
    super.intarray[1] = 71680;
    super.intarray[2] = 90000;
    super.intarray[3] = 127120;
    super.doublearray[0] = 0.0535;
    super.doublearray[1] = 965.14;
    super.doublearray[2] = 0.0705;
    super.doublearray[3] = 4746.76;
    super.doublearray[4] = 6184.88;
    super.doublearray[5] = 0.0785;
    super.doublearray[6] = 9098.80;
    super.doublearray[7] = 0.0985;
    super.doublearray[8] = doublearray[5];
  }


}