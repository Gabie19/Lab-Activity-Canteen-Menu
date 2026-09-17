import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int totalQuantity = 0;
        double totalAmount = 0.0;
        double totalDeduction = 0.0;
        boolean isStudent = false; 

        System.out.println("Welcome to the Campus Canteen!");

        while (true) {
            System.out.println("\n======      CANTEEN MENU     ======\n1. Chicken Meal        - Php 65.00\n2. Porkchop Meal       - Php 65.00\n3. French Fries        - Php 35.00\n4. Soda                - Php 25.00\n5. Tuna Sandwich       - Php 45.00\n===================================");

            System.out.print("\nEnter item number (1-5): ");
            int itemNumber = scanner.nextInt();
            
            if (itemNumber < 1 || itemNumber > 5) {
                System.out.println("\nInvalid entry! Item number must be 1-5.");
                System.out.println("Proceeding directly to the next ordering attempt...");
                continue; 
            }

            System.out.print("Enter quantity (1-10): ");
            int quantity = scanner.nextInt();
            
            if (quantity < 1 || quantity > 10) {
                System.out.println("\nInvalid entry! Quantity number must be 1-10.");
                System.out.println("Proceeding directly to the next ordering attempt...");
                continue; 
            }

            System.out.print("Are you a student? (Y/N): ");
            String studentInput = scanner.next();

            if (studentInput.equalsIgnoreCase("Y")) {
                isStudent = true;
            } else if (studentInput.equalsIgnoreCase("N")) {
                isStudent = false;
            }

            double price = 0.0;
            switch (itemNumber) {
                case 1: price = 65.00; break;
                case 2: price = 65.00; break;
                case 3: price = 35.00; break;
                case 4: price = 25.00; break;
                case 5: price = 45.00; break;
            }

            double currentOrderAmount = price * quantity;
            
            double discountRate = 0.0;
            if (isStudent && currentOrderAmount >= 500.00) {
                discountRate = 0.15; 
            } 
            else if (isStudent && currentOrderAmount < 500.00) {
                discountRate = 0.10; 
            } 
            else if (!isStudent && currentOrderAmount >= 500.00) {
                discountRate = 0.05; 
            } 
            else {
                discountRate = 0.00; 
            }

            double currentDeduction = currentOrderAmount * discountRate;
            double currentAmountToPay = currentOrderAmount - currentDeduction;

            totalQuantity += quantity;
            totalAmount += currentOrderAmount;
            totalDeduction += currentDeduction;

            System.out.printf("\nSubtotal: Php %.2f\n", currentOrderAmount);
            System.out.printf("Discount: Php %.2f\n", currentDeduction);
            System.out.printf("Order total: Php %.2f\n", currentAmountToPay);

            System.out.print("\nDo you want to order again? (Y/N): ");
            String orderAgain = scanner.next();

            if (orderAgain.equalsIgnoreCase("N")) {
                break;
            }
        }

        double finalAmountToPay = totalAmount - totalDeduction;

        System.out.println("\n==========  ORDER SUMMARY ==========");
        System.out.println("Total items:               " + totalQuantity);
        System.out.printf("Total before discount:     Php %.2f\n", totalAmount);
        System.out.printf("Total discount:            Php %.2f\n", totalDeduction);
        System.out.printf("Final amount to pay:       Php %.2f\n", finalAmountToPay);
        
        scanner.close();
    }
}