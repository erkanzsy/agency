package demo.slope.agency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SegmentDto {
    private String from;
    private String to;
    private Date departureDate;
    private Date arrivalDate;
    private String flightNumber;
}
