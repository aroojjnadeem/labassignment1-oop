public class Train {
    private String name;
    private int capacity;
    private boolean[] seats; // Boolean array to track seat availability
    private String departureTime;
    private double ticketPrice;
    private int totalTravelers;

    public Train(String name, int capacity, String departureTime, double ticketPrice) {
        this.name = name;
        this.capacity = capacity;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
        seats = new boolean[capacity];
        totalTravelers = 0;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getTotalTravelers() {
        return totalTravelers;
    }

    public int getAvailableSeatsCount() {
        int count = 0;
        for (boolean seat : seats) {
            if (!seat) {
                count++;
            }
        }
        return count;
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber <= 0 || seatNumber > capacity) {
            return false;
        }
        if (!seats[seatNumber - 1]) {
            seats[seatNumber - 1] = true;
            totalTravelers++;
            return true;
        }
        return false;
    }
}
