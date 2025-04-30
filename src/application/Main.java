package application;

import entities.CreditCard;
import entities.Purchase;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the credit card limit: ");
        double limit = sc.nextDouble();
        CreditCard creditCard = new CreditCard(limit);

        sc.nextLine();

        int exit = 1;
        while(exit != 0) {
            System.out.println("Enter the purchase description:");
            String description = sc.nextLine();

            System.out.println("Enter the purchase amount:");
            double price = sc.nextDouble();

            Purchase purchase = new Purchase(description, price);
            boolean purchaseRealized = creditCard.makePurchase(purchase);

            if (purchaseRealized) {
                System.out.println("Purchase successful!");
                System.out.println("Enter 0 to exit or 1 to continue.");
                exit = sc.nextInt();
            } else {
                System.out.println("Insufficient funds!");
                exit = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("PURCHASES REALIZED:\n");

        for (Purchase purchase: creditCard.getPurchaseList()) {
            System.out.println(purchase.getDescription() + " - " + purchase.getPrice());
        }
        System.out.println("\n***********************");

        System.out.println("\nCredit card balance: " + creditCard.getBalance());

        sc.close();
    }
}
