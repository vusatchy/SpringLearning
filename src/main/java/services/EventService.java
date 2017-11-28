package services;

import models.Event;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventService {

    private static Set<Event> events;

    public EventService() {
        events = new HashSet<>();
        setPrimaryData();
    }


    public void save(Event event){
        events.add(event);
    }

    public void remove(Event event){
        events.remove(event);
    }

    public Set<Event> getAll() {
            return  events;
    }


    public Event getById(int id){
        return events.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    public Event getByName(String name){
        return events.stream().filter(x -> x.getName().equals(name)).findFirst().get();
    }

    public Set<Event> getForDateRange(LocalDate from, LocalDate to){
            return events.stream().filter(x->x.airsOnDates(from,to)).collect(Collectors.toSet());
    }

    public Set<Event> getNextEvents(LocalDate to){
        return events.stream().filter(x->x.airsOnDateTo(to)).collect(Collectors.toSet());
    }

    private void setPrimaryData(){

    }


}
