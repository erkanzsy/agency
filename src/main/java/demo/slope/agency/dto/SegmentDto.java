package demo.slope.agency.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SegmentDto {
    private String from;
    private String to;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String flightNumber;
}
