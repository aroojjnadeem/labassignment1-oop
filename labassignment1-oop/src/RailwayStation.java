public class RailwayStation {
    private Train[] trains;
    private String stationName;

    public RailwayStation(String stationName, Train[] trains) {
        this.stationName = stationName;
        this.trains = trains;
    }

    public void displayAvailableTrains() {
        System.out.println("Available Trains at " + stationName + ":");
        for (int i = 0; i < trains.length; i++) {
            if (trains[i] != null) {
                System.out.println(i + 1 + ". " + trains[i].getName());
            }
        }
    }

    public boolean bookTicket(int trainIndex, int seatNumber, TicketType ticketType) {
        if (trainIndex >= 0 && trainIndex < trains.length && trains[trainIndex] != null) {
            Train train = trains[trainIndex];
            if (train.bookSeat(seatNumber)) {
                System.out.println("Ticket booked on " + train.getName() + " - Seat " + seatNumber +
                        " (" + ticketType + " Class, Cost: $" + train.getTicketPrice() + ")");
                return true;
            } else {
                System.out.println("Seat " + seatNumber + " is already booked or invalid.");
            }
        }
        return false;
    }

    public void displaySeatsInfo() {
        System.out.println("Seats Information at " + stationName + ":");
        System.out.printf("%-20s %-15s %-15s %-15s %-15s%n", "Train", "Departure Time", "Booked Seats", "Total Seats", "Ticket Price");
        for (int i = 0; i < trains.length; i++) {
            if (trains[i] != null) {
                Train train = trains[i];
                String departureTime = train.getDepartureTime();
                int bookedSeats = train.getTotalTravelers();
                int totalSeats = train.getCapacity();
                double ticketPrice = train.getTicketPrice();
                System.out.printf("%-20s %-15s %-15d %-15d $%-14.2f%n", train.getName(), departureTime, bookedSeats, totalSeats, ticketPrice);
            }
        }
    }

    public double calculateDailyIncome() {
        double income = 0;
        for (Train train : trains) {
            if (train != null) {
                income += train.getTotalTravelers() * train.getTicketPrice();
            }
        }
        return income;
    }

    public Train[] getTrains() {
        return trains;
    }

    public String getStationName() {
        return stationName;
    }
}
