import java.util.Scanner;

public class CurrencyConverter {

    // Define conversion rates
    // Example rates: 1 USD = 0.85 EUR, 1 USD = 110.0 JPY, etc.
    private static final double USD_TO_EUR = 0.85;
    private static final double EUR_TO_USD = 1.18;
    private static final double USD_TO_JPY = 110.0;
    private static final double JPY_TO_USD = 0.0091;
    private static final double EUR_TO_JPY = 129.53;
    private static final double JPY_TO_EUR = 0.0077;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display options to the user
        System.out.println("Choose the currency you want to convert from:");
        System.out.println("1. USD");
        System.out.println("2. EUR");
        System.out.println("3. JPY");
        int fromCurrency = scanner.nextInt();

        System.out.println("Choose the currency you want to convert to:");
        System.out.println("1. USD");
        System.out.println("2. EUR");
        System.out.println("3. JPY");
        int toCurrency = scanner.nextInt();

        System.out.println("Enter the amount to convert:");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);

        System.out.println("Converted amount: " + convertedAmount);
    }

    public static double convertCurrency(int fromCurrency, int toCurrency, double amount) {
        if (fromCurrency == toCurrency) {
            return amount;
        }

        switch (fromCurrency) {
            case 1: // USD
                return convertFromUSD(toCurrency, amount);
            case 2: // EUR
                return convertFromEUR(toCurrency, amount);
            case 3: // JPY
                return convertFromJPY(toCurrency, amount);
            default:
                throw new IllegalArgumentException("Invalid currency choice");
        }
    }

    private static double convertFromUSD(int toCurrency, double amount) {
        switch (toCurrency) {
            case 2: // USD to EUR
                return amount * USD_TO_EUR;
            case 3: // USD to JPY
                return amount * USD_TO_JPY;
            default:
                throw new IllegalArgumentException("Invalid currency choice");
        }
    }

    private static double convertFromEUR(int toCurrency, double amount) {
        switch (toCurrency) {
            case 1: // EUR to USD
                return amount * EUR_TO_USD;
            case 3: // EUR to JPY
                return amount * EUR_TO_JPY;
            default:
                throw new IllegalArgumentException("Invalid currency choice");
        }
    }

    private static double convertFromJPY(int toCurrency, double amount) {
        switch (toCurrency) {
            case 1: // JPY to USD
                return amount * JPY_TO_USD;
            case 2: // JPY to EUR
                return amount * JPY_TO_EUR;
            default:
                throw new IllegalArgumentException("Invalid currency choice");
        }
    }
}
