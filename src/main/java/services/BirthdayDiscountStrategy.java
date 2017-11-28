package services;

import models.*;

import java.time.LocalDateTime;
import java.util.Set;

public class BirthdayDiscountStrategy implements DiscountStrategy {

    private static final int AMOUNT_OF_DAYS = 5;
    private static final double DISCOUNT = 0.005;
    private static final double RATIO = 1.25;

    @Override
    public double calculateDiscountedPrice(User user, Event event, LocalDateTime localDateTime, Set<Ticket> tickets) {
        Auditorium auditorium = event.getAuditoriums().get(localDateTime);
        double price = tickets.stream().mapToDouble(x -> x.getSeat()) //костиль?
                .reduce(0, (x, y) -> auditorium.isVip((long) y) ? x + event.getBasePrice() * RATIO : x + event.getBasePrice());

        if (event.getRating().equals(Rating.HIGH)) {
            price = price * RATIO;
        }
        if (localDateTime.toLocalDate().isBefore(user.getBirthday().plusDays(AMOUNT_OF_DAYS))) {
            price = price * DISCOUNT;
        }
        return price;
    }

    @Override
    public String toString() {
        return "BirthdayDiscountStrategy{}";
    }
}
