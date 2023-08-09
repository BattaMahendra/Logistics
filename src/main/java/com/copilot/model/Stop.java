package com.copilot.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stop {
    private int lat;
    private int lon;
    private int stopId;
    private int distance; 
}
