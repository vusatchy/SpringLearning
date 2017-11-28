package services;

import models.Ticket;
import models.User;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static Set<User> users;

    public UserService() {
        users = new HashSet<>();
        setPrimaryData();
    }

    public Set<User> getAll() {
        return users;
    }

    public Set<User> getByFirstName(String name) {
        return users.stream().filter(x -> x.getFirstName().matches(name)).collect(Collectors.toSet());
    }

    public User getUserByEmail(String mail) {
        return users.stream().filter(x -> x.getEmail().matches(mail)).findFirst().get();
    }

    public User getUserById(int id){
        return users.stream().filter(x -> x.getId()==id).findFirst().get();
    }

    public void save(User user) {
        users.add(user);
    }

    public void remove(User user){
        users.remove(user);
    }

    private void setPrimaryData(){
        User user = new User();
        user.setId(0);
        user.setTickets(new TreeSet<>());
        user.setLastName("Vusach");
        user.setFirstName("Yura");
        user.setEmail("vusatch.y@gmail.com");
        user.setBirthday(LocalDate.now());

        users.add(user);

        user = new User();
        user.setId(1);
        user.setTickets(new TreeSet<>());
        user.setLastName("Manko");
        user.setFirstName("Serhii");
        user.setEmail("srhii_manko@gmail.com");
        user.setBirthday(LocalDate.now());

        users.add(user);

        user = new User();
        user.setId(2);
        user.setTickets(new TreeSet<>());
        //Ticket ticket = new Ticket();

        //1user.getTickets().add()
        user.setLastName("Selukov");
        user.setFirstName("Vitliii");
        user.setEmail("vitalik@gmail.com");
        user.setBirthday(LocalDate.now());

        users.add(user);
    }
}
