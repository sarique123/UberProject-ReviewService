package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Review review;   // we have defined a 1 : 1 mapping between review and  Booking

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(nullable = false)
    private Long TotalDistance;
}
