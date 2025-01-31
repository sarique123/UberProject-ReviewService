package org.example.uberreviewservice.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "bookingreview")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // IDENTITY means auto increment
    Long id;

    @Column(nullable = false)
    String content;

    Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)  // this annotation tells spring about the formats of date object to be stored . i.e, date,time,timestamp
    @CreatedDate     // this annotation tells spring that only handle it for object creation
    Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate     // this annotation tells spring that only handle it for object update
    Date updatedAt;
}
