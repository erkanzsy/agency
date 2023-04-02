package demo.slope.agency.service.search;

import demo.slope.agency.dto.ChainDto;
import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.SearchDto;
import demo.slope.agency.service.search.handler.SearchHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchManager {
    protected SearchHandler searchHandler;

    public SearchManager(SearchHandler searchHandler) {
        this.searchHandler = searchHandler;
    }

    public List<FlightDto> search(SearchDto searchDto) {
        ChainDto parameters = buildChainDto(searchDto);

        searchHandler.handle(parameters);

        return parameters.getFlights();
    }

    private ChainDto buildChainDto(SearchDto searchDto) {
        ChainDto chainDto = new ChainDto();

        chainDto.setSearchDto(searchDto);

        return chainDto;
    }
}
