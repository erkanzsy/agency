package demo.slope.agency.service.search;

import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.SearchDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    protected SearchManager searchManager;

    public SearchService(SearchManager searchManager) {
        this.searchManager = searchManager;
    }

    public List<FlightDto> search(SearchDto searchDto) {
        return searchManager.search(searchDto);
    }
}
