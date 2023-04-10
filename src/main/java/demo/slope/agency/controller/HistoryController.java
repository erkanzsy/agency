package demo.slope.agency.controller;

import demo.slope.agency.entity.History;
import demo.slope.agency.repository.HistoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private HistoryRepository historyRepository;

    public HistoryController(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @GetMapping("/v1")
    public ResponseEntity<Iterable<History>> history() {
        Iterable<History> histories = historyRepository.findAll();

        return ResponseEntity.ok(histories);
    }


    @GetMapping("/v2")
    public ResponseEntity<Iterable<History>> query() {
        String sDate1="31/12/2000";
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

        String sDate2="31/12/2050";
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);

        Iterable<History> histories = historyRepository.findByFromAndToAndDateBetweenOrderByDateAsc("SAW", "BER", date1, date2);

        return ResponseEntity.ok(histories);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
