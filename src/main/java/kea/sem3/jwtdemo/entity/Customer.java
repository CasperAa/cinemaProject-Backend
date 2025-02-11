package kea.sem3.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kea.sem3.jwtdemo.dto.CustomerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(length = 100)
    String username;
    String email;
    int birthday;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Reservation> reservations = new HashSet <>();


    public Customer(int id, String username, String surname, String email, int birthday) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.birthday = birthday;
    }

    public Customer() {
    }

    public Customer(CustomerRequest body) {
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }


}