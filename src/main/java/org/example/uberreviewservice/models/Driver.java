package org.example.uberreviewservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Driver extends BaseModel {

    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
//    private String phoneNumber;
//
//    @Column(nullable = false)
//    private String address;

    @Column(nullable = false,unique = true)
    private String licenceNumber;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    @JsonBackReference
    private List<Booking> bookings = new ArrayList<>();
}
