import java.util.Scanner;

public class RailwayStationSystem {
    public static void main(String[] args) {
        // Create predefined trains for three railway stations
        Train[] station1Trains = {
                new Train("Express Train A", 100, "10:00 AM", 50.0),
                new Train("Local Train B", 80, "11:30 AM", 30.0),
        };
        Train[] station2Trains = {
                new Train("Superfast Train X", 120, "09:15 AM", 60.0),
                new Train("Local Train Y", 90, "12:45 PM", 25.0),
        };
        Train[] station3Trains = {
                new Train("High-speed Train M", 150, "08:30 AM", 70.0),
                new Train("Express Train N", 110, "02:00 PM", 55.0),
        };

        RailwayStation[] railwayStations = {
                new RailwayStation("Station 1", station1Trains),
                new RailwayStation("Station 2", station2Trains),
                new RailwayStation("Station 3", station3Trains),
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Railway Station System!");

        while (true) {
            System.out.println("Select a railway station:");
            for (int i = 0; i < railwayStations.length; i++) {
                System.out.println(i + 1 + ". " + railwayStations[i].getStationName());
            }

            System.out.print("Enter the station number (0 to exit): ");
            int stationChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (stationChoice == 0) {
                break;
            } else if (stationChoice >= 1 && stationChoice <= railwayStations.length) {
                RailwayStation station = railwayStations[stationChoice - 1];

                while (true) {
                    station.displayAvailableTrains();

                    System.out.print("Enter the train number to book a ticket (0 to return to station selection): ");
                    int trainChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    if (trainChoice == 0) {
                        break;
                    } else if (trainChoice >= 1 && trainChoice <= station.getTrains().length) {
                        System.out.print("Enter the seat number: ");
                        int seatNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        // Select the ticket type (First Class or Second Class)
                        System.out.println("Select the ticket class:");
                        for (int i = 0; i < TicketType.values().length; i++) {
                            System.out.println(i + 1 + ". " + TicketType.values()[i]);
                        }
                        System.out.print("Enter the ticket class: ");
                        int classChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        if (classChoice >= 1 && classChoice <= TicketType.values().length) {
                            TicketType ticketType = TicketType.values()[classChoice - 1];
                            if (station.bookTicket(trainChoice - 1, seatNumber, ticketType)) {
                                // Ticket booked
                            } else {
                                System.out.println("Invalid seat number or seat already booked.");
                            }
                        } else {
                            System.out.println("Invalid ticket class choice.");
                        }
                    } else {
                        System.out.println("Invalid train choice. Please try again.");
                    }
                }

                station.displaySeatsInfo();
                double dailyIncome = station.calculateDailyIncome();
                System.out.println("Daily Income at " + station.getStationName() + ": $" + dailyIncome);
            } else {
                System.out.println("Invalid station choice. Please try again.");
            }
        }

        // Display the final table showing collective data of the three stations
        System.out.println("Final Table Showing Collective Data of the Three Stations:");
        System.out.printf("%-20s %-15s %-15s %-15s %-15s%n", "Station", "Train", "Departure Time", "Booked Seats", "Total Seats");
        for (RailwayStation station : railwayStations) {
            for (Train train : station.getTrains()) {
                if (train != null) {
                    String stationName = station.getStationName();
                    String trainName = train.getName();
                    String departureTime = train.getDepartureTime();
                    int bookedSeats = train.getTotalTravelers();
                    int totalSeats = train.getCapacity();
                    System.out.printf("%-20s %-20s %-15s %-15d %-15d%n", stationName, trainName, departureTime, bookedSeats, totalSeats);
                }
            }
        }

        // Calculate and display the total daily income
        double totalDailyIncome = 0;
        for (RailwayStation station : railwayStations) {
            totalDailyIncome += station.calculateDailyIncome();
        }
        System.out.println("Total Daily Income for All Stations: $" + totalDailyIncome);

        System.out.println("Thank you for using the Railway Station System!");
        scanner.close();
    }
}
