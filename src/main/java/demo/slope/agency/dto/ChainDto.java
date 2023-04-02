package demo.slope.agency.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChainDto {
    SearchDto searchDto;
    List<FlightDto> flights;

    public List<FlightDto> addFlights(List<FlightDto> newFlights) {
        if (flights == null || flights.isEmpty())
        {
            flights = new ArrayList<>();
        }

        flights.addAll(newFlights);

        return flights;
    }
}
