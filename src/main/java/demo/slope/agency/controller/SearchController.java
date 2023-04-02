package demo.slope.agency.controller;

import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.SearchDto;
import demo.slope.agency.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/v1/search.json")
    public List<FlightDto> search(@Validated @RequestBody SearchDto searchDto) {
        return searchService.search(searchDto);
    }
}
