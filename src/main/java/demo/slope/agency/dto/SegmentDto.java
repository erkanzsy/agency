package demo.slope.agency.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.ArrayList;

@Data
public class SegmentDto {
    private String from;
    private String to;
    private LocalTime departureDate;
    private LocalTime arrivalDate;
    private String flightNumber;
}
