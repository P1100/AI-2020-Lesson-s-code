package it.polito.ai.es1.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Message {
    private String text;
    private LocalDateTime time;
}
