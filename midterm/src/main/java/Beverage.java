public class Beverage extends Food {
    private boolean ice;

    public boolean isIce() {
        return ice;
    }

    public void setIce(boolean ice) {
        this.ice = ice;
    }

    @Override
    public int calculateCost() {
        int type = this.getType();

        // return each price of beverage
        switch (type) {
            case 1: // Cola
            case 2: // Fanta have same price
                return 1000;
            case 3: // Chilsung Cider
                return 900;
            case 4: // Zero Cola
                return 1200;
            case 5: // Coffee
                return 2000;
            default: // Skip
                return 0;
        }
    }
}
