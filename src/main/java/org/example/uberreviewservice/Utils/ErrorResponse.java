package org.example.uberreviewservice.Utils;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private boolean success;
    private int statusCode;
    private String message;
    private String details;
    private LocalDateTime timestamp;
}
