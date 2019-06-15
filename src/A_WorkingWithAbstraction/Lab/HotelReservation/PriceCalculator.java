package A_WorkingWithAbstraction.Lab.HotelReservation;

class PriceCalculator {

    static double CalculatePrice(double pricePerDay, int numberOfDays, Season season, Discount discount) {

        int multiplier = season.getValue();
        double discountMultiplier = discount.getValue() / 100.0;

        double priceBeforeDiscount = numberOfDays * pricePerDay * multiplier;
        double discountedAmount = priceBeforeDiscount * discountMultiplier;
        double finalPrice = priceBeforeDiscount - discountedAmount;

        return finalPrice;
    }
}
