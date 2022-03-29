public abstract class PublicTransport implements Payable {
    private String model;
    private double baseFare;
    private double totalFare;

    @Override
    public void calculatePayment() {

    }

    public String getModel() { return model; }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }
}
