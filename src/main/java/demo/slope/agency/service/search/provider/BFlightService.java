package demo.slope.agency.service.search.provider;


import com.google.gson.Gson;
import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.SearchDto;
import demo.slope.agency.dto.SegmentDto;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BFlightService implements ProviderService {
    @Override
    public String provider() {
        return "b-service";
    }

    @Override
    public List<FlightDto> flight(SearchDto searchDto, HttpResponse<String> response) {
        List<FlightDto> flights = new ArrayList<>();

        SegmentDto segment = SegmentDto.builder()
                .to(searchDto.getTo())
                .from(searchDto.getFrom())
                .flightNumber(String.valueOf((int) (Math.random() * 49) + 100))
                .departureDate(this.convertToLocalDateViaInstant(searchDto.getDepartureDate()))
                .arrivalDate(this.convertToLocalDateViaInstant(searchDto.getDepartureDate()).plus(70, ChronoUnit.MINUTES))
                .build();

        List<SegmentDto> segments = new ArrayList<>();
        segments.add(segment);

        FlightDto flight = FlightDto.builder()
                .segments(segments)
                .amount((int) (Math.random()) * 49 + 1000)
                .currency("TRY")
                .build();

        flights.add(flight);

        return flights;
    }

    @Override
    public HttpRequest request(SearchDto searchDto) {
        Gson gson = new Gson();
        String body = gson.toJson(searchDto);

        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                        .uri(new URI("https://a-service.free.beeceptor.com"))
                        .POST(HttpRequest.BodyPublishers.ofString(body))
                        .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return request;
    }

    public LocalDateTime convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
