package demo.slope.agency.service.search.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.ProviderResponseDto;
import demo.slope.agency.dto.SearchDto;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public abstract class ProviderService {
    public abstract String provider();
    public abstract List<FlightDto> flight(SearchDto searchDto, HttpResponse<String> response);
    public abstract HttpRequest request(SearchDto searchDto);

    public LocalDateTime parseDate(long timestamp, int extraMinutes) {

        LocalDateTime time = new Timestamp(timestamp).toLocalDateTime();

        return time.plus(extraMinutes, ChronoUnit.MINUTES);
    }

    public ProviderResponseDto[] parseResponse(HttpResponse<String> response)
    {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(response.body(), ProviderResponseDto[].class);
    }
}
