package services;

import models.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class TenTicketsDiscountStrategy implements DiscountStrategy {

    private static final double DISCOUNT = 0.5;
    private static final double RATIO = 1.25;

    @Override
    public double calculateDiscountedPrice(User user, Event event, LocalDateTime localDateTime, Set<Ticket> tickets) {
        Auditorium auditorium = event.getAuditoriums().get(localDateTime);
        int counter = user.getTickets().size();
        double price = 0;
        double addPrice;
        Set<Long> seats = tickets.stream().map(Ticket::getSeat).collect(Collectors.toSet());
        for (Long seat : seats) {
            if (auditorium.isVip(seat)) {
                addPrice = event.getBasePrice() * RATIO;
            } else {
                addPrice = event.getBasePrice();
            }
            if (counter % 10 == 0) {
                addPrice = addPrice - addPrice * DISCOUNT;
            }
            price += addPrice;
            counter++;
        }
        return price;
    }

    @Override
    public String toString() {
        return "TenTicketsDiscountStrategy{}";
    }
}
