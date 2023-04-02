package demo.slope.agency.service.search.handler;

import demo.slope.agency.dto.ChainDto;
import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.service.search.SearchWrapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHandler implements Handler {
    protected SearchWrapper searchWrapper;

    public SearchHandler(SearchWrapper searchWrapper) {
        this.searchWrapper = searchWrapper;
    }

    @Override
    public void handle(ChainDto chainDto) {
        List<FlightDto> flights = searchWrapper.search(chainDto.getSearchDto());

        chainDto.addFlights(flights);
    }
}
