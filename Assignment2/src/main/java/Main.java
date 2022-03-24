import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Welcome Apple korea ====");
            System.out.println("What do you want to buy?");
            System.out.println("Choose 1 for MacBook");
            System.out.println("Choose 2 for iPhone");
            System.out.println("Choose 3 for AirPods");
            System.out.println("Choose 0 for Exit");
            System.out.print("Please enter your choice: ");
            // userSelection means the number of options chosen by user
            int userSelection = scanner.nextInt();
            System.out.println("==============================");

            if (userSelection == 0) {
                // 0 means Exit so program will be finished
                System.exit(0);
            } else if (userSelection == 1) {
                // 1. create MacBook Object
                MacBook macBook = new MacBook();

                // 2. get options from user
                macBook.getUserSelection();

                // 3. print total cost
                macBook.calculateCost();

            } else if (userSelection == 2) {
                // 1. create iPhone Object
                iPhone iPhone = new iPhone();

                // 2. get options from user
                iPhone.getUserSelection();

                // 3. print total cost
                iPhone.calculateCost();

            } else {
                // 1. create AirPods Object
                AirPods airPods = new AirPods();

                // 2. get options from user
                airPods.getUserSelection();

                // 3. print total cost
                airPods.calculateCost();
            }

            int purchase = scanner.nextInt();

            System.out.println("Do you want to purchase something else (Yes: 1, No: 0)" + purchase);

            if (purchase == 1) {
                continue;
            } else {
                System.out.print("Thank you for your purchase!");
                break;
            }

        }

    }

}
