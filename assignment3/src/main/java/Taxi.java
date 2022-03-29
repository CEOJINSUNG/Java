public class Taxi extends PublicTransport {
    private double farePerKm;
    private double distance;

    @Override
    public void calculatePayment() {
        // taxi fare: total fare = (base fare) + distance * (fare per km)
        double base = getBaseFare();
        double update = base + getDistance()*getFarePerKm();
        setTotalFare(update);
    }

    public double getFarePerKm() {
        return farePerKm;
    }

    public void setFarePerKm(double farePerKm) {
        this.farePerKm = farePerKm;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
