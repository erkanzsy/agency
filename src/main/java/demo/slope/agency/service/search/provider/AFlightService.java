package demo.slope.agency.service.search.provider;


import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.ProviderResponseDto;
import demo.slope.agency.dto.SearchDto;
import demo.slope.agency.dto.SegmentDto;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class AFlightService extends ProviderService {
    @Override
    public String provider() {
        return "a-service";
    }

    @Override
    public List<FlightDto> flight(SearchDto searchDto, HttpResponse<String> response) {
        List<FlightDto> flights = new ArrayList<>();

        ProviderResponseDto[] providerResponse = parseResponse(response);

        for (ProviderResponseDto providerResponseDto : providerResponse)
        {
            int price = providerResponseDto.getPrice();

            if (price <= 0)
            {
                continue;
            }

            SegmentDto segment = SegmentDto.builder()
                    .to(searchDto.getTo())
                    .from(searchDto.getFrom())
                    .flightNumber(Integer.toString(providerResponseDto.getFlightNumber()))
                    .departureDate(this.parseDate(searchDto.getDepartureDate(), 0))
                    .arrivalDate(this.parseDate(searchDto.getDepartureDate(), 70))
                    .build();

            FlightDto flight = FlightDto.builder()
                    .segments(Arrays.asList(segment))
                    .uuid(UUID.randomUUID().toString())
                    .provider(provider())
                    .amount(price)
                    .currency("TRY")
                    .build();

            flights.add(flight);
        }

        return flights;
    }

    @Override
    public HttpRequest request(SearchDto searchDto) {
        try {
            return HttpRequest.newBuilder()
                    .uri(new URI("https://642aaebd00dfa3b5474bff75.mockapi.io/api/v1/a-service/a-service"))
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
