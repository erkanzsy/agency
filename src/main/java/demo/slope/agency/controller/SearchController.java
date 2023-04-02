package demo.slope.agency.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @GetMapping("/v1/search.json")
    public ResponseEntity<?> search() {
        return ResponseEntity.ok().build();
    }
}
