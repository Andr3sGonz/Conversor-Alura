import java.util.Scanner;
import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        System.out.print("Ingrese la moneda de origen (ej. USD, EUR, COP): ");
        String fromCurrency = scanner.next();

        System.out.print("Ingrese la moneda de destino (ej. USD, EUR, COP): ");
        String toCurrency = scanner.next();

        CurrencyConverter converter = new CurrencyConverter();
        double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);

        System.out.printf("%.2f %s equivale a %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);
    }
}
