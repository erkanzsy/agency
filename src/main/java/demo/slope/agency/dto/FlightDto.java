package demo.slope.agency.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class FlightDto {
    private double amount;
    private String currency;
    private ArrayList<SegmentDto> segments;
}
