package services;


import models.Event;
import models.Ticket;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.strategy.DiscountStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
public class DiscountService {

    @Autowired
    private List<DiscountStrategy> discountStrategies;

    public double getDiscount(User user, Event event, LocalDateTime dateTime, Set<Ticket> tickets) {
        double disc = 0;
        double temp;
        for (DiscountStrategy ds : discountStrategies) {
            temp = ds.calculateDiscountedPrice(user, event, dateTime,tickets);
            if (temp < disc) {
                disc = temp;
            }
        }
        return disc;
    }


    public List<DiscountStrategy> getDiscountStrategies() {
        return discountStrategies;
    }
}
