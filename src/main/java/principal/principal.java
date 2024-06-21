package principal;

import utils.ConversionDivisa;

public class principal {
    public static void main(String[] args) {
        ConversionDivisa cd = new ConversionDivisa();

        System.out.println(cd.Conversion("EUR","USD", 100));

    }
}
