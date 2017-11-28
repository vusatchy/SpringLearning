package services;

import models.Auditorium;
import models.Event;
import models.Rating;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Event event = new Event();
        event.setId(0);
        event.setName("Terminator");
        event.setBasePrice(70);
        event.setRating(Rating.HIGH);
        NavigableSet<LocalDateTime> airDates = new TreeSet<>();
        airDates.add(LocalDateTime.of(2017,12,17,12,00));
        airDates.add(LocalDateTime.of(2017,12,17,14,45));
        airDates.add(LocalDateTime.of(2017,12,17,21,20));
        event.setAirDates(airDates);
        NavigableMap<LocalDateTime, Auditorium> auditoriums = new TreeMap<>();
        Auditorium auditorium = new Auditorium();
        auditorium.setName("Blue");
        auditorium.setNumberOfSeats(25);
        Long vip [] = {26L,27L,28L};
        auditorium.setVipSeats(Arrays.stream(vip).collect(Collectors.toSet()));
        auditoriums.put(LocalDateTime.of(2017,12,17,12,00),auditorium);
        auditoriums.put(LocalDateTime.of(2017,12,17,14,45),auditorium);
        auditoriums.put(LocalDateTime.of(2017,12,17,21,20),auditorium);
        event.setAuditoriums(auditoriums);
        events.add(event);


        event = new Event();
        event.setId(1);
        event.setName("Titanic");
        event.setBasePrice(65);
        event.setRating(Rating.MID);
        airDates = new TreeSet<>();
        airDates.add(LocalDateTime.of(2017,12,8,11,30));
        airDates.add(LocalDateTime.of(2017,12,8,13,25));
        airDates.add(LocalDateTime.of(2017,12,8,17,55));
        event.setAirDates(airDates);
         auditoriums = new TreeMap<>();
        auditorium = new Auditorium();
        auditorium.setName("Red");
        auditorium.setNumberOfSeats(100);
        Long seats [] = {100L,101L,102L,103L,104L};
        auditorium.setVipSeats(Arrays.stream(seats).collect(Collectors.toSet()));
        auditoriums.put(LocalDateTime.of(2017,12,8,11,30),auditorium);
        auditoriums.put(LocalDateTime.of(2017,12,8,13,25),auditorium);
        auditoriums.put(LocalDateTime.of(2017,12,8,17,55),auditorium);
        event.setAuditoriums(auditoriums);
        events.add(event);

    }


}
