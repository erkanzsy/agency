package demo.slope.agency.service.history;

import demo.slope.agency.converter.HistoryConverter;
import demo.slope.agency.dto.HistoryDto;
import demo.slope.agency.dto.SearchDto;
import demo.slope.agency.entity.History;
import demo.slope.agency.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {
    long DAY_IN_MS = 1000 * 60 * 60 * 24;

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    HistoryConverter historyConverter;

    public List<HistoryDto> historyBySearchDto(SearchDto searchDto) {
        Date date = searchDto.getDepartureDate();

        long from = date.getTime() - (3 * DAY_IN_MS);
        long to = date.getTime() + (3 * DAY_IN_MS);

        List<History> histories = historyRepository.findByFromAndToAndDateBetweenOrderByDateAsc(
                searchDto.getFrom(),
                searchDto.getTo(),
                new Date(from),
                new Date(to)
        );

        return histories.stream().map(historyConverter::convertEntityToDto).collect(Collectors.toList());
    }

}
