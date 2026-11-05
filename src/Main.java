import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product type (electric/clothing):");
        String type = sc.nextLine().trim();

        switch (type) {
            case "electric":
            case "Electric":
            case "ELECTRIC": {
                System.out.print("Enter Name:");
                String name = sc.nextLine();
                System.out.print("Enter Base Price:");
                double basePrice = sc.nextDouble();
                System.out.print("Enter Warranty Fee:");
                double fee = sc.nextDouble();

                Product p = new Electronic(name, basePrice, fee);
                System.out.printf("Final Price of %s: %.2f%n", p.getName(), p.calculateFinalPrice());
                break;
            }
            case "clothing":
            case "Clothing":
            case "CLOTHING": {
                System.out.print("Enter Name:");
                String name = sc.nextLine();
                System.out.print("Enter Base Price:");
                double basePrice = sc.nextDouble();
                System.out.print("Enter Discount:");
                double discount = sc.nextDouble();

                Product p = new Clothing(name, basePrice, discount);
                System.out.printf("Final Price of %s: %.2f%n", p.getName(), p.calculateFinalPrice());
                break;
            }
            default:
                System.out.println("Invalid product type.");
        }

        sc.close();
    }
}