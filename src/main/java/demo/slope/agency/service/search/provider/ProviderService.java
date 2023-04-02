package demo.slope.agency.service.search.provider;

import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.SearchDto;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public interface ProviderService {
    String provider();
    List<FlightDto> flight(SearchDto searchDto, HttpResponse<String> response);
    HttpRequest request(SearchDto searchDto);
}
