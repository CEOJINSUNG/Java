import java.util.Scanner;

// iPhone is child of Product
public class iPhone extends Product {

    // Memory means the capacity of storage of model so this options should exist for user selection
    private int memory;

    // Color has three type like base, Gold, Silver
    private String color;

    // Because fields of product are private, Getter and Setter method is necessary
    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // There are two override methods.
    // The first is for getting user selected options
    // The second is for calculating total cost based by options
    @Override
    public void getUserSelection() {
        // iPhone base price is $800
        this.setBasePrice(800);

        Scanner scanner = new Scanner(System.in);

        String model = scanner.next(); // Type of model
        String color = scanner.next(); // Type of color
        int memory = scanner.nextInt(); // Type of memory
        int quantity = scanner.nextInt(); // Type for quantity of user selections

        // Get Options From User
        System.out.println("Base cost of the iPhone: $" + getBasePrice());
        System.out.println("Which model do you want (iPhone12 or iPhone13): " + model);
        System.out.println("Color (base, Gold, Silver): " + color);
        System.out.println("Memory (64, 128, 256, 512): " + memory);
        System.out.println("How many do you want to buy: " + quantity);

        // Set Options From Scanner
        this.setModel(model);
        this.setColor(color);
        this.setMemory(memory);
        this.setQuantity(quantity);

        // if there is another options except base, print out for check
        if (!model.equals("iPhone12") || !color.equals("base") || memory != 64) {
            System.out.println("===== check =====");
            if (!model.equals("iPhone12")) {
                System.out.println("Model (iPhone13) ------ +$200");
            }
            if (!color.equals("base")) {
                System.out.println("Color (" + color + ") ------ +" + (color.equals("Gold") ? "$20" : "$10"));
            }
            if (memory != 64) {
                System.out.println("Memory (" + memory + ") ------ +" +
                    (memory == 128 ? "$100" : (
                            memory == 256 ? "$200" : "$300"
                        )
                    )
                );
            }
        }
    }

    @Override
    public void calculateCost() {
        double total = (double) getBasePrice();

        // Detect the different [model, color, memory] and plus the options price
        if (getModel().equals("iPhone13")) {
            total += 200;
        }
        if (!getColor().equals("base")) {
            switch (getColor()) {
                case "Gold":
                    total += 20;
                    break;
                case "Silver":
                    total += 10;
                    break;
                default:
                    break;
            }
        }
        if (getMemory() != 64) {
            switch (getMemory()) {
                case 128:
                    total += 100;
                    break;
                case 256:
                    total += 200;
                    break;
                case 512:
                    total += 300;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Total cost for one iPhone: $" + String.format("%2.f", total));
        this.setTotalCost((int) total * getQuantity());
        System.out.println("Total cost (quantity x "+ getQuantity() +"): $" + String.format("%2.f", (double) getTotalCost()));
    }
}
