package services;


import models.Event;
import models.Ticket;
import models.User;

import java.time.LocalDateTime;
import java.util.Set;

public interface DiscountStrategy {
    double calculateDiscountedPrice(User user, Event event, LocalDateTime localDateTime, Set<Ticket> tickets);
}
