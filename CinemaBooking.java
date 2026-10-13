class CinemaBooking {
    String movieName;
    double ticketPrice;
    int numberOfTickets;
    String customerName;

    // Default constructor
    CinemaBooking() {
        movieName = "Avatar";
        ticketPrice = 200.00;
    }

    // Parameterized constructor
    CinemaBooking(String customerName, String movieName,
                  double ticketPrice, int numberOfTickets) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    // Method overloading
    void bookTickets(int tickets) {
        numberOfTickets = tickets;
    }

    void bookTickets(int tickets, String customer) {
        numberOfTickets = tickets;
        customerName = customer;
    }

    void displayBooking() {
        System.out.println("\nCustomer Name   : " + customerName.toUpperCase());
        System.out.println("Movie Name      : " + movieName.toUpperCase());

        if (numberOfTickets <= 0) {
            System.out.println("Booking Status  : Invalid number of tickets");
            return;
        }

        System.out.printf("Ticket Price    : Rs. %.2f%n", ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Booking Status  : Booking Successful");

        double total = ticketPrice * numberOfTickets;
        double discount = numberOfTickets >= 5 ? total * 0.10 : 0;
        double finalAmount = total - discount;

        System.out.printf("Total Amount    : Rs. %.2f%n", total);
        System.out.printf("Discount        : Rs. %.2f%n", discount);
        System.out.printf("Final Amount    : Rs. %.2f%n", finalAmount);
    }

    public static void main(String[] args) {
        System.out.println("========== CINEMA TICKET BOOKING ==========");

        // Using parameterized constructor
        CinemaBooking b1 =
            new CinemaBooking("Banu", "Avatar", 200.00, 5);
        b1.displayBooking();

        // Using default constructor and overloaded method
        CinemaBooking b2 = new CinemaBooking();
        b2.bookTickets(2, "Pavan");

        System.out.println("\nCustomer Name   : " + b2.customerName.toUpperCase());
        System.out.println("Movie Name      : " + b2.movieName.toUpperCase());
        System.out.println("Number of Tickets: " + b2.numberOfTickets);

        // Compare customer names
        if (b1.customerName.equalsIgnoreCase(b2.customerName)) {
            System.out.println("Both bookings belong to the same customer.");
        } else {
            System.out.println("Bookings belong to different customers.");
        }
    }
}