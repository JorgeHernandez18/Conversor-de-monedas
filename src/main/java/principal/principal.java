package principal;

import models.Moneda;
import utils.ConversionDivisa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConversionDivisa cd = new ConversionDivisa();
        byte decision = 0;
        double valor = 0;
        Moneda moneda = null;

        while (true) {
            try {
                System.out.println("Digite la operacion que desea realizar");
                System.out.println("""
                        1. USD - COP
                        2. COP - USD
                        3. USD - EUR
                        4. EUR - USD
                        5. COP - EUR
                        6. EUR - COP
                        7. COP - GBP
                        """);
                decision = sc.nextByte();

                if (decision == 8) {
                    break;
                }

                System.out.println("Digite el valor a convertir");
                valor = sc.nextDouble();

                switch (decision) {
                    case 1:
                        System.out.println(cd.Conversion("USD", "COP", valor));
                        break;
                    case 2:
                        System.out.println(cd.Conversion("COP", "USD", valor));
                        break;
                    case 3:
                        System.out.println(cd.Conversion("USD", "EUR", valor));
                        break;
                    case 4:
                        System.out.println(cd.Conversion("EUR", "USD", valor));
                        break;
                    case 5:
                        System.out.println(cd.Conversion("COP", "EUR", valor));
                        break;
                    case 6:
                        System.out.println(cd.Conversion("EUR", "COP", valor));
                        break;
                    case 7:
                        System.out.println(cd.Conversion("COP", "GBP", valor));
                        break;
                    default:
                        System.out.println("Opción no valida, por favor digitela de nuevo");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error identificado MME: " + e.getMessage() + ", vuelva a intentar");
                decision = 0;
                valor = 0;
                sc.nextLine();
            } catch (Exception e){
                System.out.println("Error en escritura");
                break;
            }
        }
        System.out.println("Gracias por usar nuestros servicios");
    }
}
