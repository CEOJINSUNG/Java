public class Beverage extends Food {
    private boolean ice;

    public boolean isIce() {
        return ice;
    }

    public void setIce(boolean ice) {
        this.ice = ice;
    }

    @Override
    public void calculateCost() {
        super.calculateCost();
    }
}
