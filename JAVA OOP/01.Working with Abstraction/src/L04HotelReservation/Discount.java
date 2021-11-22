package L04HotelReservation;

public enum Discount {

    VIP(0.2),
    SECOND_VISIT(0.1),
    NONE(0);

    private double percentage;

    Discount(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public static Discount parseDiscount(String discount) {
        switch (discount) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalStateException("Unknown discount type " + discount);
        }
    }
}
