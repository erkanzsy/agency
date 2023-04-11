package demo.slope.agency.service.history.consumer;

import demo.slope.agency.dto.FlightDto;
import demo.slope.agency.dto.SegmentDto;
import demo.slope.agency.entity.History;
import demo.slope.agency.repository.HistoryRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class Consumer {

    private HistoryRepository historyRepository;

    public Consumer(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
        //historyRepository.deleteAll();
    }

    @KafkaListener(topics = "${kafka.topic.history}", groupId = "${kafka.group}")
    public void listenMessage(List<FlightDto> flightDtos) {
        FlightDto flightDto = flightDtos.stream().min(Comparator.comparingDouble(FlightDto::getAmount)).get();

        List<SegmentDto> segments = flightDto.getSegments();

        History history = History.builder()
                .from(segments.get(0).getFrom())
                .to(segments.get(segments.size() - 1).getTo())
                .date(segments.get(0).getDepartureDate())
                .amount(flightDto.getAmount())
                .build();

        History history1 = historyRepository.findByFromAndToAndDate(history.getFrom(), history.getTo(), history.getDate());

        if (history1 == null)
        {
            historyRepository.save(history);
        } else if (history1.getAmount() > history.getAmount()) {
            historyRepository.delete(history1);
            historyRepository.save(history);
        }
    }
}
