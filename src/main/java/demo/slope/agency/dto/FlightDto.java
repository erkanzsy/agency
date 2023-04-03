package demo.slope.agency.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FlightDto {
    private String uuid;
    private String provider;
    private double amount;
    private String currency;
    private List<SegmentDto> segments;
}
