import java.util.*;

public class Main {

    private static double readNonNegative(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                double value = Double.parseDouble(line);
                if (value >= 0) return value;
                System.out.println("Value cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double grandTotal = 0;
        int count = 0;

        while (true) {
            System.out.print("Enter product type (electric/clothing, or 'done' to finish): ");
            String type = sc.nextLine().trim().toLowerCase();

            if (type.equals("done")) break;

            Product p;
            switch (type) {
                case "electric": {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    double basePrice = readNonNegative(sc, "Enter Base Price: ");
                    double fee = readNonNegative(sc, "Enter Warranty Fee: ");
                    p = new Electronic(name, basePrice, fee);
                    break;
                }
                case "clothing": {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    double basePrice = readNonNegative(sc, "Enter Base Price: ");
                    double discount = readNonNegative(sc, "Enter Discount: ");
                    p = new Clothing(name, basePrice, discount);
                    break;
                }
                default:
                    System.out.println("Invalid product type.");
                    continue;
            }

            double finalPrice = p.calculateFinalPrice();
            System.out.printf("Final Price of %s: %.2f%n", p.getName(), finalPrice);
            grandTotal += finalPrice;
            count++;
        }

        if (count > 0) {
            System.out.printf("%nProducts entered: %d%n", count);
            System.out.printf("Grand Total: %.2f%n", grandTotal);
            System.out.printf("Average Price: %.2f%n", grandTotal / count);
        }

        sc.close();
    }
}
