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
    public void calculateCost() {
        super.calculateCost();
    }
}
