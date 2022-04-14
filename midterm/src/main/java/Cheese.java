public class Cheese extends Food {
    @Override
    public int calculateCost() {
        int type = this.getType();

        // return a price of cheese per type
        switch (type) {
            case 2: // Swiss
                return 100;
            default: // American Cheese and Cheddar is free so there is no need to add price
                return 0;
        }
    }
}
