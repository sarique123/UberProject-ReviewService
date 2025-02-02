package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel{

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "passenger",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Booking> bookings = new ArrayList<>();
}
