package services;

import models.Auditorium;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class AuditoriumService {

    private  static Set<Auditorium> auditoriums;


    public AuditoriumService(){
        auditoriums=new HashSet<>();
    }

    public Set<Auditorium> getAll(){
        return auditoriums;
    }
    public Auditorium getByName(String name){
        return auditoriums.stream().filter(x->x.getName().equals(name)).findFirst().get();
    }

}
