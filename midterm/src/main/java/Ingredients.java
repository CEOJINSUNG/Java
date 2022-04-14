public class Ingredients extends Food {
    @Override
    public int calculateCost() {
        int type = this.getType();

        switch (type) {
            case 3: // Cucumbers
            case 4: // Olives have same price
                return 50;
            default: // Both Lettuce and Tomatoes is free, there is no need to add price
                return 0;
        }
    }
}
