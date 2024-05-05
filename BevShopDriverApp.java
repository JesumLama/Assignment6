import java.util.Scanner;
import enums.Day;
import enums.Size;

public class BevShopDriverApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order an alcoholic drink is " + bevShop.getMinAgeForAlcohol());

        System.out.println("Start please a new order:");
        System.out.println("Your Total Order for now is " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));
        System.out.print("Would you please enter your name: ");
        String customerName = scanner.nextLine();
        System.out.print("Would you please enter your age: ");
        int customerAge = Integer.parseInt(scanner.nextLine());

        if (bevShop.isValidAge(customerAge)) {
            System.out.println("Your age is above " + bevShop.getMinAgeForAlcohol() + " and you are eligible to order alcohol.");
            bevShop.startNewOrder(12, Day.MONDAY, customerName, customerAge);

            while (true) {
                if (bevShop.isEligibleForMore()) {
                    System.out.println("Would you please add another alcohol drink (yes/no): ");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
                        System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                        System.out.println("Your current alcohol drink order is less than " + bevShop.getMaxOrderForAlcohol());
                        System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));
                    } else if (choice.equalsIgnoreCase("no")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                } else {
                    System.out.println("You have reached the maximum number of alcohol drinks for this order.");
                    System.out.print("Would you please add a COFFEE to your order (yes/no): ");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("yes")) {
                        bevShop.processCoffeeOrder("Latte", Size.SMALL, false, false);
                        System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getTotalItems());
                        System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));
                    }
                    break;
                }
            }

        } else {
            System.out.println("Your age is not appropriate for an alcohol drink!!");
            System.out.print("Would you please add a drink to your order (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                System.out.println("The Total price on the Order: " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));
                System.out.println("The total number of fruits is " + bevShop.getMaxNumOfFruits());
                System.out.println("You reached a Maximum number of fruits");
                System.out.println("Total price on the second Order: " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));
                System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
            }
        }

        System.out.println("#------------------------------------#");
        System.out.println("Would you please start a new order");
        System.out.print("Would you please enter your name: ");
        customerName = scanner.nextLine();

        System.out.print("Would you please enter your age: ");
        customerAge = Integer.parseInt(scanner.nextLine());

        if (bevShop.isValidAge(customerAge)) {
            bevShop.startNewOrder(15, Day.FRIDAY, customerName, customerAge);
            System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));

            System.out.println("Would you please add a SMOOTHIE to order");
            bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);
            System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));

            

            System.out.println("Would you please add a COFFEE to order");
            bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
            System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));


            System.out.println("Would you like to add another alcohol drink? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
                System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
                System.out.println("Your current alcohol drink order is less than " + bevShop.getMaxOrderForAlcohol());
                System.out.println("The Total Price on the Order: " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));
            } else if (choice.equalsIgnoreCase("no")) {
                System.out.println("No additional alcohol drinks will be added to your order.");
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }

            System.out.println("The total number of fruits is " + bevShop.getMaxNumOfFruits());
            System.out.println("You reached a Maximum number of fruits");
            System.out.println("Total price on the second Order: " + bevShop.totalOrderPrice(bevShop.totalNumOfMonthlyOrders()));
            System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
        }
    }
}