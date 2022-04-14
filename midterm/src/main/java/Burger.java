import java.util.ArrayList;

public class Burger extends Food {
    Cheese cheeseObject;
    ArrayList<Ingredients> ingredients;

    public Cheese getCheeseObject() {
        return cheeseObject;
    }

    public void setCheeseObject(Cheese cheeseObject) {
        this.cheeseObject = cheeseObject;
    }

    public ArrayList<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int calculateCost() {
        int type = this.getType();
        int burgerPrice = 0;
        int cheesePrice = this.cheeseObject.calculateCost();
        int ingredientsPrice = 0;

        // for each ingredient, add price
        for (Ingredients element : this.ingredients) {
            System.out.print(element.getType());
            ingredientsPrice += element.calculateCost();
        }

        // return cost of burger by type of burgers
        switch (type) {
            case 1: // Egg Mayo
                burgerPrice += 4000;
                break;
            case 2: // Chicken Tikka
            case 3: // Chicken Ham
                burgerPrice += 5000;
                break;
            case 4: // Roasted Chicken
                burgerPrice += 5500;
                break;
            default:
                burgerPrice += 0;
                break;
        }

        // return final price of burger
        return burgerPrice + cheesePrice + ingredientsPrice;
    }
}
