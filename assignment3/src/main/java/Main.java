import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // In both Bus and Train, they use two same questions
    // Return Station and Assign it to both
    public static Station getFarePerStationAndNumberOfStations() {
        Station station = new Station();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter fare per station (for extra stations): ");
        station.farePerStation = scanner.nextDouble();

        System.out.print("Enter number of stations: ");
        station.nStations = scanner.nextInt();
        return station;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declare an entire trip plan as a list
        Map<Integer, List> tripPlan = new HashMap<>();

        System.out.println("======= Welcome to Trip Planner =======");

        System.out.print("Number of transfers: ");

        // Get the number of transfers
        int numberOfTransfer = scanner.nextInt();

        // This is for checking the number of transport used by user
        int currentNumberOfTransport = 1;

        // line.separator means '\n' or enter in all OS
        String newline = System.getProperty("line.separator");

        while (currentNumberOfTransport <= numberOfTransfer) {
            System.out.println(
                "===============================" + newline
                + "Choose transport " + currentNumberOfTransport + ":" + newline
                + "1. Taxi  (Enter 1)" + newline
                + "2. Bus   (Enter 2)" + newline
                + "3. Train (Enter 3)" + newline
                + "0. For canceling trip (Enter 0)"
            );

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Check if choice is 0 or not
            if (choice == 0) break;

            // 개행문자 제거
            scanner.nextLine();

            System.out.print("Enter transport name: ");
            String transportName = scanner.nextLine();

            System.out.print("Enter base fare: ");
            double baseFare = scanner.nextDouble();

            if (choice == 1) {
                Taxi taxi = new Taxi();

                // Set Taxi Model
                taxi.setModel(transportName);

                // Set Base Fare
                taxi.setBaseFare(baseFare);

                // Set fare per km in taxi
                System.out.print("Enter fare per km: ");
                taxi.setFarePerKm(scanner.nextDouble());

                // Set distance of using taxi
                System.out.print("Enter distance (in km): ");
                taxi.setDistance(scanner.nextDouble());

                // Calculate Payment
                taxi.calculatePayment();

                // Add Trip plan of Taxi
                tripPlan.put(currentNumberOfTransport, List.of(taxi.getModel(), taxi.getTotalFare()));
           } else if (choice == 2) {
                Bus bus = new Bus();

                // Set Bus Model
                bus.setModel(transportName);

                // Set Base Fare
                bus.setBaseFare(baseFare);

                // From the method, set fare per station and number of stations
                bus.station = getFarePerStationAndNumberOfStations();

                // Calculate Payment
                bus.calculatePayment();

                // Add Trip plan of Bus
                tripPlan.put(currentNumberOfTransport, List.of(bus.getModel(), bus.getTotalFare()));
            } else {
                Train train = new Train();

                // Set Train Model
                train.setModel(transportName);

                // Set Base Fare
                train.setBaseFare(baseFare);

                // From the method, set fare per station and number of stations
                train.station = getFarePerStationAndNumberOfStations();

                // Calculate Payment
                train.calculatePayment();

                // Add Trip plan of Train
                tripPlan.put(currentNumberOfTransport, List.of(train.getModel(), train.getTotalFare()));
            }

            // Increase the current number of transport
            currentNumberOfTransport++;
        }

        // Declare total trip fare
        final double[] totalTripFare = {0};

        // After Trip Over, Print all trip results
        if (!tripPlan.isEmpty()) {
            System.out.println("======= Trip Plan =======");
            tripPlan.forEach((key, value) -> {
                System.out.println(
                    "Transport " + key + ": " + value.get(0) + newline
                        + "Fare: " + String.format("%.2f", value.get(1))
                );
                totalTripFare[0] += (double) value.get(1);
            });
        }

        // Print total fare and final message
        System.out.print(
            "==================================" + newline
            + "Total Trip Fare: " + String.format("%.2f", totalTripFare[0]) + newline
            + "==================================" + newline
            + "Info: if the number of staions are more than 5, there will extra charge for each extra stations"
            + newline + "===== Have a wonderful trip! ====="
        );
    }

}
