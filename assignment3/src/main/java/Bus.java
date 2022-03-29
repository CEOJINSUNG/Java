public class Bus extends PublicTransport {

    public Station station;

    @Override
    public void calculatePayment() {
        int numberOfStation = station.nStations;
        double farePerStation = station.farePerStation;

        if (numberOfStation < 5) {
            // total fare = (base fare)
            setTotalFare(getBaseFare());
        } else {
            // total fare = (base fare) + ((number of station) - 5) * (fare per station)
            double base = getBaseFare();
            double update = base + (numberOfStation-5) * farePerStation;
            setTotalFare(update);
        }
    }
}
