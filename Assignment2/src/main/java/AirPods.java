import java.util.Scanner;

// AirPods is child of Product
public class AirPods extends Product {

    @Override
    public void getUserSelection() {
        // AirPods base price is $120
        this.setBasePrice(120);

        Scanner scanner = new Scanner(System.in);

        // Get Options From User
        System.out.println("Base cost of the AirPods: $" + getBasePrice());
        System.out.print("Which model do you want (AirPods3 or AirPodsPro or AirPodsMax): ");
        String model = scanner.nextLine(); // Type of model
        System.out.print("How many do you want to buy: ");
        int quantity = scanner.nextInt(); // Type for quantity of user selections

        // Set Options From Scanner
        this.setModel(model);
        this.setQuantity(quantity);

        // if there is another options except base, print out for check
        if (!model.equals("AirPods3")) {
            System.out.println("===== check =====");
            System.out.println("Model (" + model + ") ------ +" + (model.equals("AirPodsPro") ? "$100" : "$200"));
        }

    }

    @Override
    public void calculateCost() {
        System.out.println();
        double total = (double) getBasePrice();

        // Detect the different model
        // and plus the options price
        if (getModel().equals("AirPodsPro")) {
            total += 100;
        }
        if (getModel().equals("AirPodsMax")) {
            total += 200;
        }

        System.out.println("Total cost for one AirPods: $" + String.format("%.2f", total));
        this.setTotalCost((int) total * getQuantity());
        System.out.println("Total cost (quantity x "+ getQuantity() +"): $" + String.format("%.2f", (double) getTotalCost()));
    }
}
