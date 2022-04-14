public class Extra extends Food {
    @Override
    public int calculateCost() {
        int type = this.getType();

        // return each price of extras
        switch (type) {
            case 1: // Cookies
                return 1500;
            case 2: // French Fries
                return 1300;
            case 3: // Chips
                return 1700;
            default: // Skip
                return 0;
        }
    }
}
