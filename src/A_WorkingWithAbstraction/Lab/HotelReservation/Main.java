package A_WorkingWithAbstraction.Lab.HotelReservation;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s");

        double pricePerDay = Double.parseDouble(data[0]);
        int numberOfDays = Integer.parseInt(data[1]);

        Season season = null;
        switch (data[2]) {
            case "Spring":
                season = Season.SPRING;
                break;
            case "Summer":
                season = Season.SUMMER;
                break;
            case "Autumn":
                season = Season.AUTUMN;
                break;
            case "Winter":
                season = Season.WINTER;
                break;
        }

        Discount discountType = null;
        switch (data[3]) {
            case "VIP":
                discountType = Discount.VIP;
                break;
            case "SecondVisit":
                discountType = Discount.SECONDVISIT;
                break;
            case "None":
                discountType = Discount.NONE;
                break;
        }

        double totalPrice = PriceCalculator.CalculatePrice(pricePerDay, numberOfDays, season, discountType);

        System.out.printf("%.2f", totalPrice);
    }
}
