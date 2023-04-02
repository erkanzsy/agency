package demo.slope.agency.service.search;

import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.SearchDto;
import demo.slope.agency.service.search.provider.ProviderService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;

@Service
public class SearchWrapper {
    public Map<String, ProviderService> providers = new HashMap<>();
    public HttpClient httpClient;

    public SearchWrapper() {
        ServiceLoader<ProviderService> loader = ServiceLoader.load(ProviderService.class);

        for (ProviderService providerService : loader) {
            providers.put(providerService.provider(), providerService);
        }

        System.out.println(providers);

        httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(1))
                .build();
    }

    public List<FlightDto> search(SearchDto searchDto) {
        List<FlightDto> allFlights = new ArrayList<>();

        for (Map.Entry<String, ProviderService> provider : providers.entrySet()) {
            ProviderService providerService = provider.getValue();
            HttpRequest request = providerService.request(searchDto);

            try {
                HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                List<FlightDto> flights = providerService.flight(searchDto, httpResponse);

                allFlights.addAll(flights);
            } catch (IOException e) {
            } catch (InterruptedException e) {
            } catch (NullPointerException e) {
            }
        }

        return allFlights;
    }
}
