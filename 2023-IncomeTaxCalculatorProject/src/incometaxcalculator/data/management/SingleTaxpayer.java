package incometaxcalculator.data.management;

public class SingleTaxpayer extends Taxpayer {

  public SingleTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    super.intarray[0] = 24680;
    super.intarray[1] = 81080;
    super.intarray[2] = 90000;
    super.intarray[3] = 152540;
    super.doublearray[0] = 0.0535;
    super.doublearray[1] = 1320.38;
    super.doublearray[2] = 0.0705;
    super.doublearray[3] = 5296.58;
    super.doublearray[4] = 5996.80;
    super.doublearray[5] = 0.0785;
    super.doublearray[6] = 10906.19;
    super.doublearray[7] = 0.0985;
    super.doublearray[8] = doublearray[5];
  }

}