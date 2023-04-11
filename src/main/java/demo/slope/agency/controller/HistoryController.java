package demo.slope.agency.controller;

import demo.slope.agency.dto.HistoryDto;
import demo.slope.agency.dto.SearchDto;
import demo.slope.agency.service.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @GetMapping("/v1.json")
    public ResponseEntity<List<HistoryDto>> history(@Validated @RequestBody SearchDto searchDto) {
        return ResponseEntity.ok(historyService.historyBySearchDto(searchDto));
    }
}
