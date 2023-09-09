import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        // Initialize exchange rates (for example purposes)
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);  // Base currency (US Dollar)
        exchangeRates.put("EUR", 0.85); // Euro
        exchangeRates.put("GBP", 0.73); // British Pound
        // Add more exchange rates as needed
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = exchangeRates.getOrDefault(fromCurrency, 1.0);
        double toRate = exchangeRates.getOrDefault(toCurrency, 1.0);

        return amount * (toRate / fromRate);
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the base currency (e.g., USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., EUR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);

        System.out.printf("%.2f %s is equivalent to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);

        scanner.close();
    }
}
