package demo.slope.agency.service.search;

import demo.slope.agency.dto.ChainDto;
import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.SearchDto;
import demo.slope.agency.service.search.handler.HistoryHandler;
import demo.slope.agency.service.search.handler.SearchHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchManager {
    protected SearchHandler searchHandler;
    protected HistoryHandler historyHandler;

    public SearchManager(SearchHandler searchHandler, HistoryHandler historyHandler) {
        this.searchHandler = searchHandler;
        this.historyHandler = historyHandler;
    }

    public List<FlightDto> search(SearchDto searchDto) {
        ChainDto parameters = buildChainDto(searchDto);

        searchHandler.handle(parameters);

        historyHandler.handle(parameters);

        return parameters.getFlights();
    }

    private ChainDto buildChainDto(SearchDto searchDto) {
        ChainDto chainDto = new ChainDto();

        chainDto.setSearchDto(searchDto);

        return chainDto;
    }
}
