package demo.slope.agency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private String uuid;
    private String provider;
    private double amount;
    private String currency;
    private List<SegmentDto> segments;
}
