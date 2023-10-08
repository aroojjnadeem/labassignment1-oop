public enum TicketType {
    FIRST_CLASS("First Class"),
    SECOND_CLASS("Second Class");

    private final String displayName;

    TicketType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

