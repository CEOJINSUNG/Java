import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the type of burger
        Burger burger = new Burger();

        System.out.print(
            "=================== \n"
            + "Welcome to SKKU-SUBWAY! \n"
            + "Choose burgers (sandwiches): \n"
            + "1. Egg Mayo - 4,000 won \n"
            + "2. Chicken Tikka - 5,000 won \n"
            + "3. Chicken Ham - 5,000 won \n"
            + "4. Roasted Chicken - 5,500 won \n"
            + "0. Cancel Order \n"
            + "Select Burger (1-5) : "
        );
        int burgerType = scanner.nextInt();

        // if burger type is 0, system exit
        if (burgerType == 0) {
            System.exit(1);
        }

        burger.setType(burgerType);

        // Get the Cheese Type
        Cheese cheese = new Cheese();
        System.out.print(
            "=================== \n"
            + "Select Cheese Type: \n"
            + "1. American Cheese - (+0 won) \n"
            + "2. Swiss - (+100 won) \n"
            + "3. Cheddar - (+0 won)"
            + "Select Cheese (1-3): "
        );
        int cheeseType = scanner.nextInt();
        cheese.setType(cheeseType);
        burger.setCheeseObject(cheese);

        // Get Ingredients
        // For getting multiple ingredients, declare array of ingredient
        ArrayList<Ingredients> ingredients = new ArrayList<>();
        while (true) {
            Ingredients ingredient = new Ingredients();
            System.out.print(
                "=================== \n"
                    + "Select Ingredients: \n"
                    + "1. Lettuce - (+0 won) \n"
                    + "2. Tomatoes - (+0 won) \n"
                    + "3. Cucumbers - (+50 won) \n"
                    + "4. Olives - (+50 won) \n"
                    + "0. Skip \n"
                    + "Select Ingredients (1-4): "
            );
            int ingredientsType = scanner.nextInt();

            // if user input 0, exit of ingredients
            if (ingredientsType == 0) {
                break;
            } else {
                // set ingredient type of single one
                ingredient.setType(ingredientsType);

                // add it to array
                ingredients.add(ingredient);
            }
        }
        burger.setIngredients(ingredients);

        // Get Beverages
        Beverage beverage = new Beverage();
        System.out.print(
            "=================== \n"
            + "1. Cola - 1,000 won \n"
            + "2. Fanta - 1,100 won \n"
            + "3. Chilsung Cider - 900 won \n"
            + "4. Zero cola - 1,200 won \n"
            + "5. Coffee - 2,000 won \n"
            + "0. Skip \n"
            + "Select Beverage (1-5): "
        );
        int beverageType = scanner.nextInt();
        beverage.setType(beverageType);

        // Ask if user wants ice and beverage type is not zero
        if (beverage.getType() != 0) {
            System.out.print(
                "=================== \n"
                    + "With ice? (0 [no] or 1[yes]): "
            );
            // transform int to boolean after get values
            int ice = scanner.nextInt();
            beverage.setIce(ice == 1);
        }

        // Get Extra
        Extra extra = new Extra();
        System.out.print(
            "=================== \n"
            + "1. Cookies - 1,500 won \n"
            + "2. French Fries - 1,300 won \n"
            + "3. Chips - 1,700 won \n"
            + "0. Skip \n"
            + "Select Beverage (1-3): "
        );
        int extraType = scanner.nextInt();
        extra.setType(extraType);

        // Print a final Receipt
        int burgerTotalPrice = burger.calculateCost();
        int beverageTotalPrice = beverage.calculateCost();
        int extraTotalPrice = extra.calculateCost();

        System.out.println("===================");
        System.out.println("| Burger (with cheese and ingredients): " + Integer.toString(burgerTotalPrice));

        // Only if type of beverage is not zero
        if (beverage.getType() != 0) {
            // Ask whether beverage includes ice
            if (beverage.isIce()) {
                System.out.println("| Beverage (with ice): " + Integer.toString(beverageTotalPrice));
            } else {
                System.out.println("| Beverage (without ice): " + Integer.toString(beverageTotalPrice));
            }
        }

        // Ask whether extra exists
        if (extra.getType() != 0) { // if extra type is not zero, it means there is another extra
            System.out.println("| Extra: " + Integer.toString(extraTotalPrice));
        }

        // Print out a total price
        System.out.println("| Total: " + Integer.toString(burgerTotalPrice + beverageTotalPrice + extraTotalPrice));
    }
}
