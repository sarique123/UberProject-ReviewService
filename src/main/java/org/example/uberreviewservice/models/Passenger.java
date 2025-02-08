package org.example.uberreviewservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToMany(mappedBy = "passenger",cascade = CascadeType.PERSIST)
    @JsonBackReference
    private List<Booking> bookings = new ArrayList<>();
}
