package demo.slope.agency.service.search;

import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.SearchDto;
import demo.slope.agency.service.search.provider.ProviderService;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class SearchWrapper {
    public Map<String, ProviderService> providers = new HashMap<>();
    public HttpClient httpClient;

    public SearchWrapper() {
        ServiceLoader<ProviderService> loader = ServiceLoader.load(ProviderService.class);

        for (ProviderService providerService : loader) {
            providers.put(providerService.provider(), providerService);
        }

        httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(1)).build();
    }

    public List<FlightDto> search(SearchDto searchDto) {
        List<FlightDto> allFlights = new ArrayList<>();

        for (Map.Entry<String, ProviderService> provider : providers.entrySet()) {
            ProviderService providerService = provider.getValue();
            HttpRequest request = providerService.request(searchDto);

            try {
                CompletableFuture<Void> cf = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenAccept(result -> {
                    List<FlightDto> flights = providerService.flight(searchDto, result);
                    allFlights.addAll(flights);
                });

                cf.get(3, TimeUnit.SECONDS);
            } catch (ExecutionException e) {
                // Logger
            } catch (InterruptedException e) {
                // Logger
            } catch (TimeoutException e) {
                // Logger
            }
        }

        return allFlights;
    }
}
