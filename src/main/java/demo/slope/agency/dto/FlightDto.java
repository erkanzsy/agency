package demo.slope.agency.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FlightDto {
    private double amount;
    private String currency;
    private List<SegmentDto> segments;
}
